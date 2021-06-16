package com.lipskii.ski_jumping_system.service;

import com.lipskii.ski_jumping_system.bucket.BucketName;
import com.lipskii.ski_jumping_system.dao.HillRepository;
import com.lipskii.ski_jumping_system.entity.Hill;
import com.lipskii.ski_jumping_system.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class HillService implements ServiceInterface {

    private final HillRepository hillRepository;
    private final VenueService venueService;
    private final FileStore fileStore;

    @Autowired
    public HillService(HillRepository hillRepository, @Lazy VenueService venueService, FileStore fileStore) {
        this.hillRepository = hillRepository;
        this.venueService = venueService;
        this.fileStore = fileStore;
    }

    @Override
    public List<Hill> findAll() {
        return hillRepository.findAll();
    }

    public List<Hill> get(Specification<Hill> spec, Sort sort) {
        return hillRepository.findAll(spec, sort);
    }

    @Override
    public Optional<Hill> findById(int id) {
        return hillRepository.findById(id);
    }


    public List<Hill> findAllByVenueId(int venueId){
        return hillRepository.findAllByVenue(venueService.findById(venueId).orElseThrow(() -> new ResourceNotFoundException("No hills in venue with id=" + venueId)));
    }

    @Override
    @Transactional
    public Hill save(Object obj) {
        return hillRepository.save((Hill) obj);
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        Hill hill = hillRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("hill does not exist!"));
        System.out.println(hill);
        hillRepository.deleteHillById(id);
    }


    @Transactional
    public Hill updateHill(int hillId, Hill requestHill) {
        if (hillRepository.findById(hillId).isPresent()) {
            requestHill.setId(hillId);
            hillRepository.save(requestHill);
        } else {
            throw new ResourceNotFoundException("No hill found for id: " + hillId);
        }

        return requestHill;
    }

    public void uploadHillPhoto(MultipartFile file, int hillId) {

            isFileEmpty(file);

            //check if file is an image
            isImage(file);

            Hill hill = getPersonOrThrow(hillId);

            //Grab some metadata from file if any
            Map<String, String> metadata = extractMetadata(file);

            //Store the image in s3 and update database (userProfileImageLink) with s3 image link
            String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "hill_" + hill.getId());
            String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());

            try {
                fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
                hill.setPhoto(filename);
                hillRepository.save(hill);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }

    }

    public byte[] downloadHillPhoto(int hillid) {
        Hill hill = getPersonOrThrow(hillid);

        String path = String.format("%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                "hill_" + hill.getId());

        return hill.getPhoto()
                .map(key -> fileStore.download(path, key))
                .orElse(new byte[0]);

    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private Hill getPersonOrThrow(int hillId) {
        return hillRepository.findById(hillId).orElseThrow(() -> new ResourceNotFoundException("No hill found for id " + hillId));
    }

    private void isImage(MultipartFile file) {
        if(!Arrays.asList(
                ContentType.IMAGE_JPEG.getMimeType(),
                ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("File must be an image" + file.getContentType());
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
    }
}
