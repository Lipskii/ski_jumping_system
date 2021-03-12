package com.lipskii.ski_jumping_system.rest;


import com.lipskii.ski_jumping_system.dto.*;
import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    private final JudgeService judgeService;
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
    public RestController(AllTimePointsSystemService allTimePointsSystemService, CityService cityService, CountryService countryService, CompetitionService competitionService, DisqualificationTypeService disqualificationTypeService, GenderService genderService, HillService hillService, HillVersionService hillVersionService, JudgeService judgeService, JuryService juryService, JuryTypeService juryTypeService, PersonService personService, RegionService regionService, ResultService resultService, SeasonService seasonService, SeriesService seriesService, SizeOfHillService sizeOfHillService, SkiClubService skiClubService, SkiJumperService skiJumperService, SkisService skisService, VenueService venueService, WeatherService weatherService) {
        this.allTimePointsSystemService = allTimePointsSystemService;
        this.cityService = cityService;
        this.countryService = countryService;
        this.competitionService = competitionService;
        this.disqualificationTypeService = disqualificationTypeService;
        this.genderService = genderService;
        this.hillService = hillService;
        this.hillVersionService = hillVersionService;
        this.judgeService = judgeService;
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
    public List<City> getCitiesWithSkiClubs(){
        return cityService.findAllWithSkiClubs();
    }

    @GetMapping("/cities/skiJumpers")
    public List<City> getCitiesWithSkiJumpers(){
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

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.findAll();
    }

    @GetMapping("/countries/skiClubs")
    public List<Country> getCountriesWithSkiClubs(){
        return countryService.findAllWithSkiClubs();
    }

    @GetMapping("/countries/skiJumpers")
    public List<Country> getCountriesWithSkiJumpers(){
        return countryService.findAllWithSkiJumpers();
    }

    @GetMapping("/countries/venues")
    public List<Country> getCountriesWithVenues() {
        return countryService.findAllWithVenues();
    }

    @GetMapping("/genders")
    public List<Gender> getGenders(){
        return genderService.findAll();
    }

    @PostMapping("/hill")
    public Hill addHill(@RequestBody Hill hill) {
        hillService.save(hill);
        return hill;
    }

    @PutMapping("hills/{hillId}")
    public ResponseEntity<Hill> updateHill(@PathVariable("hillId") int hillId, @RequestBody Hill requestHill) throws ResourceNotFoundException {

        if(hillService.findById(hillId).isPresent()){
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
    public HillVersion addHillVersion(@RequestBody HillVersion hillVersion){
        hillVersionService.save(hillVersion);
        return hillVersion;
    }

    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person){
        personService.save(person);
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
    public SkiClub addSkiClubs(@RequestBody SkiClub skiClub){
        skiClubService.save(skiClub);
        return skiClub;
    }

    @PutMapping("/skiClubs/{skiClubId}")
    public ResponseEntity<SkiClub> updateSkiClub(@PathVariable("skiClubId") int skiClubId,@RequestBody SkiClub skiClub)
            throws ResourceNotFoundException{
        if(skiClubService.findById(skiClubId).isPresent()){
            skiClub.setId(skiClubId);
            skiClubService.save(skiClub);
        } else {
            throw new ResourceNotFoundException("No ski club found for id: " + skiClubId);
        }

        return ResponseEntity.ok(skiClub);
    }

    @GetMapping("/skiClubs/city/{cityId}")
    public List<SkiClubDTO> getSkiClubsByCity(@PathVariable("cityId") int cityId){
        return skiClubService.findAllByCityIdDTO(cityId);
    }

    @GetMapping("/skiClubs/country/{countryId}")
    public List<SkiClubDTO> getSkiClubsByCountry(@PathVariable("countryId") int countryId) {
        return skiClubService.findAllByCountryIdDTO(countryId);
    }

    @GetMapping("/skiJumpers")
    public List<SkiJumperDTO> getSkiJumpers(){
        return skiJumperService.findAllDTO();
    }

    @PostMapping("/skiJumpers")
    public SkiJumper addSkiJumper(@RequestBody SkiJumper skiJumper){
        skiJumperService.save(skiJumper);
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
    public Venue saveVenue(@RequestBody Venue venue){
        venueService.save(venue);
        return venue;
    }

    @PutMapping("/venues/{venueId}")
    public ResponseEntity<Venue> updateVenue(@RequestBody Venue venue, @PathVariable("venueId") int venueId) throws ResourceNotFoundException {

        if(venueService.findById(venueId).isPresent()){
            venue.setId(venueId);
            venueService.save(venue);
        } else {
            throw new ResourceNotFoundException("No venue found for id: " + venueId);
        }

        return ResponseEntity.ok(venue);
    }

    @DeleteMapping("/venue/{venueId}")
    public ResponseEntity<Integer> deleteVenue(@PathVariable("venueId") int id) {

        System.out.println("deleting " + id);
        boolean isDeleted = venueService.deleteByIdBool(id);
        System.out.println(isDeleted);

        if (isDeleted) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/venues/city/{cityId}")
    public List<VenueDTO> getVenuesByCity(@PathVariable("cityId") int cityId){
        return venueService.getVenuesByCity(cityId);
    }

    @GetMapping("/venues/country/{countryId}")
    public List<VenueDTO> getVenuesByCountry(@PathVariable("countryId") int countryId) {
        return venueService.findAllByCountryDTO(countryId);
    }

}
