package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.db_data.FetchPeople;
import com.lipskii.ski_jumping_system.db_data.FetchSkiClubs;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Region;
import com.lipskii.ski_jumping_system.entity.SkiClub;
import com.lipskii.ski_jumping_system.service.CityService;
import com.lipskii.ski_jumping_system.service.CountryService;
import com.lipskii.ski_jumping_system.service.RegionService;
import com.lipskii.ski_jumping_system.service.SkiClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class HomeController {

    private final CityService cityService;
    private final CountryService countryService;
    private final FetchPeople fetchPeople;
    private final RegionService regionService;
    private final SkiClubService skiClubService;
    protected final Logger log = Logger.getLogger(getClass().getName());


    @Autowired
    public HomeController(CityService cityService, CountryService countryService, FetchPeople fetchPeople,
                          RegionService regionService, SkiClubService skiClubService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.fetchPeople = fetchPeople;
        this.regionService = regionService;
        this.skiClubService = skiClubService;
    }

    @GetMapping("/")
    public String connectionTest(Model model) {

        return "helloworld";
    }

//    @GetMapping("/addregions")
//    public String addRegions(Model model) {
//
//        List<Country> countries = countryService.findAll();
//        countries.remove(0);
//        model.addAttribute("countries", countries);
//
//        System.out.println(countryService.findFirstById());
//        model.addAttribute("selectedCountry", countryService.findFirstById());
//
//        List<Region> regions = regionService.findAll();
//        model.addAttribute("regions", regions);
//
//        model.addAttribute("region", new Region());
//
//        return "addregions";
//    }
//
//    @PostMapping("/addregions")
//    public String addRegions(@ModelAttribute("region") Region region, Model model) {
//
//        region.setName(region.getName().trim());
//        regionService.save(region);
//
//        List<Region> regions = regionService.findAll();
//        model.addAttribute("regions", regions);
//
//        List<Country> countries = countryService.findAll();
//        model.addAttribute("countries", countries);
//
//        model.addAttribute("selectedCountry", region.getCountry());
//
//        return "addregions";
//    }
//
////    @PostMapping("/addathletes")
////    public String addAthletes(@ModelAttribute("searchUri") FisSearchUri searchUri, Model model){
////
////        //TODO remove duplicate code
////        String searchLink = "https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&" +
////                "firstname=&sectorcode=JP" +
////                "&gendercode=M" +
////                "&birthyear=" + searchUri.getDecade() +
////                "&skiclub=" +
////                "&skis=" +
////                "&nationcode=" + searchUri.getCode() +
////                "&fiscode=" +
////                "&status=" +
////                "&search=true";
////
////        ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch(searchLink);
////        model.addAttribute("peopleData",fetchedPersonObjectList);
////
////        List<Country> countries = countryService.findAll();
////        model.addAttribute("countries",countries);
////
////        List<Region> regions = regionService.findRegionByCountryCode(searchUri.getCode());
////        model.addAttribute("regions",regions);
////
////        Country country = countryService.findCountryByCode(searchUri.getCode());
////        model.addAttribute("selectedCountry",country);
////
////        List<City> cities = cityService.findCitiesByCountry(searchUri.getCode());
////        model.addAttribute("cities",cities);
////
////        model.addAttribute("searchUri",searchUri);
////
////        model.addAttribute("city",new City());
////
////        return "addathletes";
////    }
////
////    @GetMapping("/addathletes")
////    public String addAthletes(Model model, @RequestParam("selectedCountryId") int selectedCountryId){
////
////        System.out.println("GET");
////        ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&sectorcode=JP" +
////                "&gendercode=M" +
////                "&birthyear=2020" +
////                "&skiclub=&skis=" +
////                "&nationcode=POL" +
////                "&fiscode=&status=&search=true");
////        model.addAttribute("peopleData",fetchedPersonObjectList);
////
////        List<Region> regions = regionService.findAll();
////        model.addAttribute("regions",regions);
////
////        List<City> cities = cityService.findCitiesByCountry("POL");
////        model.addAttribute("cities",cities);
////
////        Country country = countryService.findById(selectedCountryId).get();
////        System.out.println("SELECTED COUNTRY: " + country);
////        model.addAttribute("selectedCountry",country);
////
////        List<Country> countries = countryService.findAll();
////        model.addAttribute("countries",countries);
////
////        model.addAttribute("city",new City());
////
////        model.addAttribute("searchUri", new FisSearchUri());
////
////        return "addathletes";
////    }
////
////    @GetMapping("/addathletes?{code}*{decade}")
////    public String addAthletes(Model model, @PathVariable("code") String code, @PathVariable("decade") String decade){
////
////        System.out.println("CODE" + code);
////        System.out.println("decade" + decade);
////        ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&sectorcode=JP&gendercode=M&" +
////                "birthyear=" + decade +
////                "&skiclub=&skis=" +
////                "&nationcode=" + code +
////                "&fiscode=&status=&search=true");
////
////        model.addAttribute("peopleData",fetchedPersonObjectList);
////
////        List<Region> regions = regionService.findAll();
////        model.addAttribute("regions",regions);
////
////        List<City> cities = cityService.findCitiesByCountry(code);
////        model.addAttribute("cities",cities);
////
////        List<Country> countries = countryService.findAll();
////        model.addAttribute("countries",countries);
////
////        model.addAttribute("city",new City());
////
////        model.addAttribute("searchUri", new FisSearchUri());
////
////        return "addathletes";
////    }
//
////    //TODO Fix bug with mapping
////    @PostMapping("/addcity")
////    public String addCity(@ModelAttribute("city") City city, Model model, @ModelAttribute("searchUri") FisSearchUri searchUri) {
////
////        //cityService.save(city);
////
////        String searchLink = "https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&" +
////                "firstname=&sectorcode=JP" +
////                "&gendercode=M" +
////                "&birthyear=" + searchUri.getDecade() +
////                "&skiclub=" +
////                "&skis=" +
////                "&nationcode=" + searchUri.getCode() +
////                "&fiscode=" +
////                "&status=" +
////                "&search=true";
////
////
////        ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch(searchLink);
////        model.addAttribute("peopleData",fetchedPersonObjectList);
////
////        List<Country> countries = countryService.findAll();
////        model.addAttribute("countries",countries);
////
////        List<Region> regions = regionService.findRegionByCountryCode(searchUri.getCode());
////        model.addAttribute("regions",regions);
////
////        Country country = countryService.findCountryByCode(searchUri.getCode());
////        model.addAttribute("selectedCountry",country);
////
////        List<City> cities = cityService.findCitiesByCountry(searchUri.getCode());
////        model.addAttribute("cities",cities);
////
////        model.addAttribute("searchUri",searchUri);
////
////        model.addAttribute("city",new City());
////
////        return "redirect:/addathletes?selectedCountryId=501";
////    }
//
//
//    @GetMapping("/addathletes")
//    public String addAthletes(Model model, @RequestParam("id") int selectedCountryId, @RequestParam("decade") String decade){
//
//
//        return "addathletes";
//    }
//
//
//    @GetMapping("/insertskiclubs")
//    public String insertSkiClubs(Model model, @RequestParam("code") String code){
//        FetchSkiClubs fetchSkiClubs = new FetchSkiClubs("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&sectorcode=JP&gendercode=M&" +
//                "birthyear=" +
//                "&skiclub=" +
//                "&skis=&nationcode=" + code +
//                "&fiscode=&status=&search=true");
//
//        model.addAttribute("countries", countryService.findAll());
//        model.addAttribute("country",new Country());
//        model.addAttribute("newCity",new City());
//
//        model.addAttribute("skiClubsInDB",skiClubService.findAllByCountryCode(code));
//        model.addAttribute("skiClubsFromFis",fetchSkiClubs.getSkiClubs().toArray(new String[0]));
//        model.addAttribute("cities",cityService.findCitiesByCountryOrderByName(code));
//        model.addAttribute("regions",regionService.findRegionsByCountryCode(code));
//        model.addAttribute("newSkiClub",new SkiClub());
//
//        return "insertskiclubs";
//    }
//
//    @PostMapping("/insertskiclubs")
//    public String insertSkiClubs(@ModelAttribute("newSkiClub") SkiClub skiClub){
//
//        skiClub.setName(skiClub.getName().trim());
//        log.log(Level.INFO,"Saving " + skiClub + " into database");
//        skiClubService.save(skiClub);
//
//        return "redirect:/insertskiclubs?code=" + skiClub.getCity().getRegion().getCountry().getCode();
//    }
//
//    @PostMapping("/insertskiclubs/changecode")
//    public String insertSkiClubsChangeCode(@ModelAttribute("country") Country country){
//
//        log.log(Level.INFO,"Reloading insertskiclubs with code = " + country.getCode());
//        country = countryService.findById(country.getId()).get();
//        return "redirect:/insertskiclubs?code=" + country.getCode();
//    }
//
//    @PostMapping("/insertskiclubs/addcity")
//    public String insertSkiClubsAddCity(@ModelAttribute("city") City city){
//
//        city.setName(city.getName().trim());
//        log.log(Level.INFO,"Saving " + city + " into database");
//        cityService.save(city);
//
//        return "redirect:/insertskiclubs?code=" + city.getRegion().getCountry().getCode();
//    }
}















