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

    @GetMapping("/countries/venues")
    public List<Country> getCountriesWithVenues() {
        return countryService.findAllWithVenues();
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
    public List<SkiClub> getSkiClubs() {
        return skiClubService.findAllOrderByName();
    }

    @GetMapping("/skiClubs/city/{cityId}")
    public List<SkiClub> getSkiClubsByCity(@PathVariable("cityId") int cityId){
        return skiClubService.findAllByCityId(cityId);
    }

    @GetMapping("/skiClubs/country/{countryId}")
    public List<SkiClub> getSkiClubsByCountry(@PathVariable("countryId") int countryId) {
        return skiClubService.findAllByCountryId(countryId);
    }

    @GetMapping("/skiJumper/{country}")
    public List<SkiJumperDTO> getSkiJumpersByCountry(@PathVariable("country") String country) {
        return skiJumperService.getSkiJumpersByCountry(country);
    }

    @GetMapping("/skis")
    public List<SkisDTO> getSkis() {
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

    //TEMPORARY SOLUTION will be fixed in next days
//    @PostMapping("/skiJumper")
//    public ResponseEntity addSkiJumper(@RequestBody Map<String, String> body) {
//
//        Person person;
//
//        if (!body.get("city").equals("")) {
//            person = new Person(body.get("firstName").trim(),
//                    body.get("lastName").trim(),
//                    genderService.findById(Integer.parseInt(body.get("gender"))).get(),
//                    Integer.parseInt(body.get("birthdateDay")),
//                    Integer.parseInt(body.get("birthdateMonth")),
//                    Integer.parseInt(body.get("birthdateYear")),
//                    countryService.findCountryByName(body.get("country")),
//                    cityService.findById(Integer.parseInt(body.get("city"))).get()
//            );
//        } else {
//            person = new Person(body.get("firstName").trim(),
//                    body.get("lastName").trim(),
//                    genderService.findById(Integer.parseInt(body.get("gender"))).get(),
//                    Integer.parseInt(body.get("birthdateDay")),
//                    Integer.parseInt(body.get("birthdateMonth")),
//                    Integer.parseInt(body.get("birthdateYear")),
//                    countryService.findCountryByName(body.get("country"))
//            );
//        }
//
//
//        personService.save(person);
//
//        boolean isActive = true;
//        if (body.get("isActive").equals("false")) {
//            isActive = false;
//        }
//
//        SkiJumper skiJumper = new SkiJumper();
//        skiJumper.setPerson(person);
//        skiJumper.setActive(isActive);
//        skiJumper.setAll_time_points(BigDecimal.ZERO);
//        if (!body.get("skiClub").equals("")) {
//            skiJumper.setSkiClub(skiClubService.findById(Integer.parseInt(body.get("skiClub"))).get());
//        }
//        if (!body.get("skis").equals("")) {
//            skiJumper.setSkis(skisService.findById(Integer.parseInt(body.get("skis"))).get());
//        }
//
//        skiJumperService.save(skiJumper);
//
//        return ResponseEntity.ok(skiJumper);
//    }

//    @PostMapping("/skiClub")
//    public ResponseEntity addSkiClub(@RequestBody Map<String, String> body) {
//        System.out.println(body);
//
//        if (cityService.findById(Integer.parseInt(body.get("cityId").trim())).isPresent()) {
//            City city = cityService.findById(Integer.parseInt(body.get("cityId").trim())).get();
//            SkiClub skiClub = new SkiClub(body.get("name").trim(), city);
//            skiClubService.save(skiClub);
//            return ResponseEntity.ok(skiClub);
//        }
//
//        return (ResponseEntity) ResponseEntity.notFound();
//    }

}
