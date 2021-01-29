package com.lipskii.ski_jumping_system.rest;


import com.lipskii.ski_jumping_system.dto.CityDTO;
import com.lipskii.ski_jumping_system.dto.CountryDTO;
import com.lipskii.ski_jumping_system.dto.RegionDTO;
import com.lipskii.ski_jumping_system.dto.SkiClubDTO;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.SkiClub;
import com.lipskii.ski_jumping_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final SkisService skisService;
    private final VenueService venueService;
    private final WeatherService weatherService;

    @Autowired
    public RestController(CountryService countryService, AllTimePointsSystemService allTimePointsSystemService, CityService cityService, CompetitionService competitionService, DisqualificationTypeService disqualificationTypeService, GenderService genderService, HillService hillService, HillVersionService hillVersionService, JudgeService judgeService, JuryService juryService, JuryTypeService juryTypeService, PersonService personService, RegionService regionService, ResultService resultService, SeasonService seasonService, SeriesService seriesService, SizeOfHillService sizeOfHillService, SkiClubService skiClubService, SkisService skisService, VenueService venueService, WeatherService weatherService) {
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
    public List<CountryDTO> getCountries() {
        return countryService.findAllDTO();
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.findAll();
    }

    @GetMapping("/cities/{country}")
    public List<CityDTO> getCitiesByCountry(@PathVariable("country") String country) {
        return cityService.getCitiesByCountry(countryService.findCountryByName(country));
    }

    @GetMapping("/regions/{country}")
    public List<RegionDTO> getRegionsByCountry(@PathVariable("country") String country) {
        return regionService.findRegionsByCountry(countryService.findCountryByName(country));
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
