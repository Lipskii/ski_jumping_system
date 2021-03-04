package com.lipskii.ski_jumping_system.rest;


import com.lipskii.ski_jumping_system.dto.*;
import com.lipskii.ski_jumping_system.entity.*;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
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


    @GetMapping("/skiClubs")
    public List<SkiClubDTO> getSkiClubs() {
        return skiClubService.getAllClubsDTO();
    }

    @GetMapping("/skiClubs/{country}")
    public List<SkiClubDTO> getSkiClubsByCountry(@PathVariable("country") String country) {

        return skiClubService.getClubsByCountryDTO(countryService.findCountryByName(country));
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.findAll();
    }

//    @GetMapping("/countries/venues")
//    public List<Country> getCountriesWithVenues() {
//        return countryService.findAllWithVenues();
//    }

    @GetMapping("/countries/venues")
    public List<CountryWithVenuesDTO> getCountriesWithVenues() {
        return countryService.findAllWithVenues();
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.findAll();
    }

    @GetMapping("/cities/{country}")
    public List<CityDTO> getCitiesByCountry(@PathVariable("country") String country) {
        return cityService.getCitiesByCountry(countryService.findCountryByName(country));
    }

    @GetMapping("/hills/{venueId}")
    public List<Hill> getHillsByVenue(@PathVariable("venueId") int venueId) {
        return hillService.findAllByVenueId(venueId);
    }

    @PutMapping("hills/{hillId}")
    public ResponseEntity<Hill> putHill(@PathVariable("hillId") int hillId, @RequestBody Hill hill){
        System.out.println(hill);
        return ResponseEntity.ok(hill);
    }

    @GetMapping("/regions/{country}")
    public List<RegionDTO> getRegionsByCountry(@PathVariable("country") String country) {
        return regionService.findRegionsByCountry(countryService.findCountryByName(country));
    }

    @GetMapping("/skis")
    public List<SkisDTO> getSkis() {
        return skisService.findAll();
    }

    @GetMapping("/skiJumper/{country}")
    public List<SkiJumperDTO> getSkiJumpersByCountry(@PathVariable("country") String country) {
        return skiJumperService.getSkiJumpersByCountry(country);
    }

    @GetMapping("/sizeOfHill")
    public List<SizeOfHill> getSizesOfHil() {
        return sizeOfHillService.findAll();
    }

    @GetMapping("/venues/{countryId}")
    public List<VenueDTO> getVenuesByCountry(@PathVariable("countryId") String countryId) {
        return venueService.findAllByCountry(Integer.parseInt(countryId));
    }

    @GetMapping("/venues")
    public List<VenueDTO> getVenues(){
        return venueService.findAll();
    }

    @DeleteMapping("/venue/{id}")
    public ResponseEntity<Integer> deleteVenue(@PathVariable("id") int id) {

        System.out.println("deleting " + id);
        boolean isDeleted = venueService.deleteByIdBool(id);
        System.out.println(isDeleted);

        if (isDeleted) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/venue")
    public Venue addVenue(@RequestBody Map<String, String> body, HttpServletResponse response) {

        Venue venue;


            if (!body.get("capacity").equals("")) {
                venue = new Venue(
                        body.get("name").trim(),
                        Integer.parseInt(body.get("yearOfOpening")),
                        Integer.parseInt(body.get("capacity")),
                        skiClubService.findById(Integer.parseInt(body.get("skiClub"))).get(),
                        cityService.findById(Integer.parseInt(body.get("city"))).get()
                );
            } else {
                venue = new Venue(body.get("name"),
                        Integer.parseInt(body.get("yearOfOpening")),
                        skiClubService.findById(Integer.parseInt(body.get("skiClub"))).get(),
                        cityService.findById(Integer.parseInt(body.get("city"))).get());
            }

            return venueService.save(venue);


    }

    //TODO tymczasowe rozwiązanie
    @PostMapping("/hillVersion")
    public ResponseEntity<Integer> addHillVersion(@RequestBody Map<String, String> body) {

        System.out.println(body.toString());
        Hill hill;

        try {
            if (body.get("hillId") == null || body.get("hillId").equals("")) {
                hill = new Hill(body.get("name"),
                        venueService.findById(Integer.parseInt(body.get("venueId"))).orElseThrow(Exception::new),
                        sizeOfHillService.findById(Integer.parseInt(body.get("sizeId"))).orElseThrow(Exception::new));
                hillService.save(hill);
            } else {
                hill = hillService.findById(Integer.parseInt(body.get("hillId"))).orElseThrow(Exception::new);
            }


            HillVersion hillVersion;

            if (body.get("r2l") == null || body.get("r2l").equals("")) {
                hillVersion = new HillVersion(
                        hill,
                        Integer.parseInt(body.get("validSinceYear")),
                        Integer.parseInt(body.get("validUntilYear")),
                        BigDecimal.valueOf(Double.parseDouble(body.get("kPoint"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("hillSize"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("es"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("e1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("e2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("gamma"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("r1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("t"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("alpha"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("s"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("v0"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("h"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("n"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("p"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("l1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("l2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("betaP"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("beta"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("betaL"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("l"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("rl"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("zu"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("r2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("a"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("b1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("b2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("bk"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("bu"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("d"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("q"))),
                        body.get("certificate"),
                        LocalDate.of(
                                Integer.parseInt(body.get("validSinceYear")),
                                Integer.parseInt(body.get("validSinceMonth")),
                                Integer.parseInt(body.get("validSinceDay"))
                        ),
                        LocalDate.of(
                                Integer.parseInt(body.get("validUntilYear")),
                                Integer.parseInt(body.get("validUntilMonth")),
                                Integer.parseInt(body.get("validUntilDay"))
                        ));
            } else {
                hillVersion = new HillVersion(
                        hill,
                        Integer.parseInt(body.get("validSinceYear")),
                        Integer.parseInt(body.get("validUntilYear")),
                        BigDecimal.valueOf(Double.parseDouble(body.get("kPoint"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("hillSize"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("es"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("e1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("e2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("gamma"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("r1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("t"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("alpha"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("s"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("v0"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("h"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("n"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("p"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("l1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("l2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("betaP"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("beta"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("betaL"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("l"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("rl"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("r2l"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("zu"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("r2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("a"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("b1"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("b2"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("bk"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("bu"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("d"))),
                        BigDecimal.valueOf(Double.parseDouble(body.get("q"))),
                        body.get("certificate"),
                        LocalDate.of(
                                Integer.parseInt(body.get("validSinceYear")),
                                Integer.parseInt(body.get("validSinceMonth")),
                                Integer.parseInt(body.get("validSinceDay"))
                        ),
                        LocalDate.of(
                                Integer.parseInt(body.get("validUntilYear")),
                                Integer.parseInt(body.get("validUntilMonth")),
                                Integer.parseInt(body.get("validUntilDay"))
                        ));
            }


            hillVersionService.save(hillVersion);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/skiJumper")
    public ResponseEntity addSkiJumper(@RequestBody Map<String, String> body) {

        Person person;

        if (!body.get("city").equals("")) {
            person = new Person(body.get("firstName").trim(),
                    body.get("lastName").trim(),
                    genderService.findById(Integer.parseInt(body.get("gender"))).get(),
                    Integer.parseInt(body.get("birthdateDay")),
                    Integer.parseInt(body.get("birthdateMonth")),
                    Integer.parseInt(body.get("birthdateYear")),
                    countryService.findCountryByName(body.get("country")),
                    cityService.findById(Integer.parseInt(body.get("city"))).get()
            );
        } else {
            person = new Person(body.get("firstName").trim(),
                    body.get("lastName").trim(),
                    genderService.findById(Integer.parseInt(body.get("gender"))).get(),
                    Integer.parseInt(body.get("birthdateDay")),
                    Integer.parseInt(body.get("birthdateMonth")),
                    Integer.parseInt(body.get("birthdateYear")),
                    countryService.findCountryByName(body.get("country"))
            );
        }


        personService.save(person);

        boolean isActive = true;
        if (body.get("isActive").equals("false")) {
            isActive = false;
        }

        SkiJumper skiJumper = new SkiJumper();
        skiJumper.setPerson(person);
        skiJumper.setActive(isActive);
        skiJumper.setAll_time_points(BigDecimal.ZERO);
        if (!body.get("skiClub").equals("")) {
            skiJumper.setSkiClub(skiClubService.findById(Integer.parseInt(body.get("skiClub"))).get());
        }
        if (!body.get("skis").equals("")) {
            skiJumper.setSkis(skisService.findById(Integer.parseInt(body.get("skis"))).get());
        }

        skiJumperService.save(skiJumper);

        return ResponseEntity.ok(skiJumper);
    }

    @PostMapping("/city")
    public ResponseEntity addCity(@RequestBody Map<String, String> body) {

        City city = new City(body.get("name"), regionService.findRegionByName(body.get("region")));
        cityService.save(city);

        return ResponseEntity.ok(city);
    }

    @PostMapping("/skiClub")
    public ResponseEntity addSkiClub(@RequestBody Map<String, String> body) {
        System.out.println(body);

        if (cityService.findById(Integer.parseInt(body.get("cityId").trim())).isPresent()) {
            City city = cityService.findById(Integer.parseInt(body.get("cityId").trim())).get();
            SkiClub skiClub = new SkiClub(body.get("name").trim(), city);
            skiClubService.save(skiClub);
            return ResponseEntity.ok(skiClub);
        }

        return (ResponseEntity) ResponseEntity.notFound();
    }

}
