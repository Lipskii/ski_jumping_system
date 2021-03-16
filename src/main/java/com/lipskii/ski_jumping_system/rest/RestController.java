package com.lipskii.ski_jumping_system.rest;


import com.lipskii.ski_jumping_system.dto.*;
import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

//TODO error handling

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final AllTimePointsSystemService allTimePointsSystemService;
    private final CityService cityService;
    private final CountryService countryService;
    private final CompetitionService competitionService;
    private final DisqualificationTypeService disqualificationTypeService;
    private final GenderService genderService;
    private final HillService hillService;
    private final HillVersionService hillVersionService;
    private final JuryService juryService;
    private final JuryTypeService juryTypeService;
    private final PersonService personService;
    private final RegionService regionService;
    private final ResultService resultService;
    private final SeasonService seasonService;
    private final SeriesService seriesService;
    private final SizeOfHillService sizeOfHillService;
    private final SkiClubService skiClubService;
    private final SkiJumperService skiJumperService;
    private final SkisService skisService;
    private final VenueService venueService;
    private final WeatherService weatherService;


    @Autowired
    public RestController(AllTimePointsSystemService allTimePointsSystemService, CityService cityService, CountryService countryService, CompetitionService competitionService, DisqualificationTypeService disqualificationTypeService, GenderService genderService, HillService hillService, HillVersionService hillVersionService, JuryService juryService, JuryTypeService juryTypeService, PersonService personService, RegionService regionService, ResultService resultService, SeasonService seasonService, SeriesService seriesService, SizeOfHillService sizeOfHillService, SkiClubService skiClubService, SkiJumperService skiJumperService, SkisService skisService, VenueService venueService, WeatherService weatherService) {
        this.allTimePointsSystemService = allTimePointsSystemService;
        this.cityService = cityService;
        this.countryService = countryService;
        this.competitionService = competitionService;
        this.disqualificationTypeService = disqualificationTypeService;
        this.genderService = genderService;
        this.hillService = hillService;
        this.hillVersionService = hillVersionService;
        this.juryService = juryService;
        this.juryTypeService = juryTypeService;
        this.personService = personService;
        this.regionService = regionService;
        this.resultService = resultService;
        this.seasonService = seasonService;
        this.seriesService = seriesService;
        this.sizeOfHillService = sizeOfHillService;
        this.skiClubService = skiClubService;
        this.skiJumperService = skiJumperService;
        this.skisService = skisService;
        this.venueService = venueService;
        this.weatherService = weatherService;
    }


    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.getCitiesOrderByName();
    }


    @GetMapping("/cities/country/{countryId}")
    public List<City> getCitiesByCountry(@PathVariable("countryId") int countryId) {
        return cityService.getCitiesByCountry(countryId);
    }

    @GetMapping("/cities/skiClubs")
    public List<City> getCitiesWithSkiClubs() {
        return cityService.findAllWithSkiClubs();
    }

    @GetMapping("/cities/skiJumpers")
    public List<City> getCitiesWithSkiJumpers() {
        return cityService.findAllWithSkiJumpers();
    }

    @GetMapping("/cities/venues")
    public List<City> getCitiesWithVenues() {
        return cityService.findAllWithVenues();
    }

    @PostMapping("/city")
    public City addCity(@RequestBody City city) {
        city.setName(city.getName().trim());
        cityService.save(city);
        return city;
    }

    @GetMapping("/competitions")
    public List<Competition> getCompetitions() {
        return competitionService.findAll();
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.findAll();
    }

    @GetMapping("/countries/jury")
    public List<Country> getCountriesWithJury() {
        return countryService.findAllWithJury();
    }

    @GetMapping("/countries/people")
    public List<Country> getCountriesWithPeople() {
        return countryService.findAllWithPeople();
    }

    @GetMapping("/countries/skiClubs")
    public List<Country> getCountriesWithSkiClubs() {
        return countryService.findAllWithSkiClubs();
    }

    @GetMapping("/countries/skiJumpers")
    public List<Country> getCountriesWithSkiJumpers() {
        return countryService.findAllWithSkiJumpers();
    }

    @GetMapping("/countries/venues")
    public List<Country> getCountriesWithVenues() {
        return countryService.findAllWithVenues();
    }

    @GetMapping("/genders")
    public List<Gender> getGenders() {
        return genderService.findAll();
    }

    @GetMapping("/hills")
    public List<Hill> getHills() {
        return hillService.findAll();
    }

    @PostMapping("/hills")
    public Hill addHill(@RequestBody Hill hill) {
        hillService.save(hill);
        return hill;
    }

    @PutMapping("hills/{hillId}")
    public ResponseEntity<Hill> updateHill(@PathVariable("hillId") int hillId, @RequestBody Hill requestHill) throws ResourceNotFoundException {

        if (hillService.findById(hillId).isPresent()) {
            requestHill.setId(hillId);
            hillService.save(requestHill);
        } else {
            throw new ResourceNotFoundException("No hill found for id: " + hillId);
        }

        return ResponseEntity.ok(requestHill);
    }

    @GetMapping("/hills/{venueId}")
    public List<Hill> getHillsByVenue(@PathVariable("venueId") int venueId) {
        return hillService.findAllByVenueId(venueId);
    }

    @PostMapping("/hillVersion")
    public HillVersion addHillVersion(@RequestBody HillVersion hillVersion) {
        hillVersionService.save(hillVersion);
        return hillVersion;
    }

    @GetMapping("/jury")
    public List<JuryDTO> getJury() {
        return juryService.findAllDTO();
    }

    @GetMapping("/jury/rd")
    public List<JuryDTO> getRDs() {
        return juryService.findAllRaceDirectors();
    }

    @GetMapping("/jury/td")
    public List<JuryDTO> getTDs() {
        return juryService.findAllTechnicalDelegates();
    }

    @GetMapping("/jury/coc")
    public List<JuryDTO> getChiefs() {
        return juryService.findAllChiefsOfCompetitions();
    }

    @GetMapping("/jury/ec")
    public List<JuryDTO> getEquipmentControllers() {
        return juryService.findAllEquipmentControllers();
    }

    @GetMapping("/jury/judges")
    public List<JuryDTO> getJudges() {
        return juryService.findAllJudges();
    }

    @GetMapping("/jury/atd")
    public List<JuryDTO> getTDAssistants() {
        return juryService.findAllTDAssistants();
    }

    @GetMapping("/jury/ard")
    public List<JuryDTO> getRDAssistants() {
        return juryService.findAllRDAssistants();
    }

    @PostMapping("/jury")
    public Jury saveJury(@RequestBody Jury jury) {
        juryService.save(jury);
        return jury;
    }

    @GetMapping("/jury/country/{countryId}")
    public List<JuryDTO> getJuryByCountry(@PathVariable("countryId") int countryId) {
        return juryService.findAllByCountryId(countryId);
    }

    @GetMapping("/juryTypes")
    public List<JuryType> getJuryTypes() {
        return juryTypeService.findAll();
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return personService.findAllOrderedByLastName();
    }

    @GetMapping("/people/country/{countryId}")
    public List<Person> getPeopleByCountryId(@PathVariable("countryId") int countryId) {
        return personService.findAllByCountryId(countryId);
    }

    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person) {
        personService.save(person);
        return person;
    }

    @PostMapping(value = "/people/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadPersonPhoto(@RequestPart MultipartFile file, @RequestPart("personId") int personId)
            throws ResourceNotFoundException {
        Person person = personService.findById(personId).orElseThrow(() -> new ResourceNotFoundException("No person found for id " + personId));

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\Users\\Bartek\\IdeaProjects\\ski_jumping_system\\src\\files\\athletes\\" + file.getOriginalFilename());
            Files.write(path, bytes);
            person.setPhoto(file.getOriginalFilename());
        } catch (IOException e) {
            System.out.println(e.getCause().getMessage());
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


//    @PostMapping(value = "/results/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity uploadFile(@RequestPart MultipartFile file) {
//        System.out.println(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
//        try {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get("C:\\Users\\Bartek\\IdeaProjects\\ski_jumping_system\\src\\files\\" + file.getOriginalFilename());
//            System.out.println(path);
//            Files.write(path, bytes);
//        } catch (IOException e) {
//            System.out.println(e.getCause().getMessage());
//            ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok().build();
//    }

    @PutMapping("/people/{personId}")
    public Person updatePerson(@RequestBody Person person, @PathVariable("personId") int personId) throws ResourceNotFoundException {

        if (personService.findById(personId).isPresent()) {
            person.setId(personId);
            personService.save(person);
        } else {
            throw new ResourceNotFoundException("No person found for id: " + personId);
        }

        return person;
    }

    @GetMapping("/regions")
    public List<Region> getRegions() {
        return regionService.findAllOrderByName();
    }

    @GetMapping("/regions/country/{countryId}")
    public List<Region> getRegionsByCountry(@PathVariable("countryId") int countryId) {
        return regionService.getRegionsByCountry(countryId);
    }

    @GetMapping("/sizeOfHill")
    public List<SizeOfHill> getSizesOfHil() {
        return sizeOfHillService.findAll();
    }

    @GetMapping("/skiClubs")
    public List<SkiClubDTO> getSkiClubs() {
        return skiClubService.findAllOrderByNameDTO();
    }

    @PostMapping("/skiClubs")
    public SkiClub addSkiClubs(@RequestBody SkiClub skiClub) {
        skiClubService.save(skiClub);
        return skiClub;
    }

    @PutMapping("/skiClubs/{skiClubId}")
    public ResponseEntity<SkiClub> updateSkiClub(@PathVariable("skiClubId") int skiClubId, @RequestBody SkiClub skiClub)
            throws ResourceNotFoundException {
        if (skiClubService.findById(skiClubId).isPresent()) {
            skiClub.setId(skiClubId);
            skiClubService.save(skiClub);
        } else {
            throw new ResourceNotFoundException("No ski club found for id: " + skiClubId);
        }

        return ResponseEntity.ok(skiClub);
    }

    @GetMapping("/skiClubs/city/{cityId}")
    public List<SkiClubDTO> getSkiClubsByCity(@PathVariable("cityId") int cityId) {
        return skiClubService.findAllByCityIdDTO(cityId);
    }

    @GetMapping("/skiClubs/country/{countryId}")
    public List<SkiClubDTO> getSkiClubsByCountry(@PathVariable("countryId") int countryId) {
        return skiClubService.findAllByCountryIdDTO(countryId);
    }

    @GetMapping("/skiJumpers")
    public List<SkiJumperDTO> getSkiJumpers() {
        return skiJumperService.findAllDTO();
    }

    @PostMapping("/skiJumpers")
    public SkiJumper addSkiJumper(@RequestBody SkiJumper skiJumper) {
        skiJumperService.save(skiJumper);
        return skiJumper;
    }

    @PutMapping("/skiJumpers/{skiJumperId}")
    public SkiJumper updateSkiJumper(@RequestBody SkiJumper skiJumper, @PathVariable("skiJumperId") int skiJumperId) throws ResourceNotFoundException {

        if (skiJumperService.findById(skiJumperId).isPresent()) {
            skiJumper.setId(skiJumperId);
            skiJumperService.save(skiJumper);
        } else {
            throw new ResourceNotFoundException("No jumper found for id: " + skiJumperId);
        }

        return skiJumper;
    }

    @GetMapping("/skiJumpers/city/{cityId}")
    public List<SkiJumperDTO> getSkiJumpersByCity(@PathVariable("cityId") int cityId) {
        return skiJumperService.findAllByCityIdDTO(cityId);
    }

    @GetMapping("/skiJumpers/country/{countryId}")
    public List<SkiJumperDTO> getSkiJumpersByCountry(@PathVariable("countryId") int countryId) {
        return skiJumperService.findAllByCountryIdDTO(countryId);
    }

    @GetMapping("/skis")
    public List<Skis> getSkis() {
        return skisService.findAll();
    }

    @GetMapping("/venues")
    public List<VenueDTO> getVenues() {
        return venueService.findAllDTO();
    }

    @PostMapping("/venues")
    public Venue saveVenue(@RequestBody Venue venue) {
        venueService.save(venue);
        return venue;
    }

    @PutMapping("/venues/{venueId}")
    public ResponseEntity<Venue> updateVenue(@RequestBody Venue venue, @PathVariable("venueId") int venueId) throws ResourceNotFoundException {

        if (venueService.findById(venueId).isPresent()) {
            venue.setId(venueId);
            venueService.save(venue);
        } else {
            throw new ResourceNotFoundException("No venue found for id: " + venueId);
        }

        return ResponseEntity.ok(venue);
    }

    @DeleteMapping("/venues/{venueId}")
    public Map<String, Boolean> deleteVenue(@PathVariable("venueId") int venueId) {

        Venue venue = venueService.findById(venueId)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found for this id :: " + venueId));

        System.out.println(venue);
        venueService.delete(venue);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

    @GetMapping("/venues/city/{cityId}")
    public List<VenueDTO> getVenuesByCity(@PathVariable("cityId") int cityId) {
        return venueService.getVenuesByCity(cityId);
    }

    @GetMapping("/venues/country/{countryId}")
    public List<VenueDTO> getVenuesByCountry(@PathVariable("countryId") int countryId) {
        return venueService.findAllByCountryDTO(countryId);
    }

}
