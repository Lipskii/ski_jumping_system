package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.db_data.FetchPeople;
import com.lipskii.ski_jumping_system.db_data.FetchedPersonObject;
import com.lipskii.ski_jumping_system.db_data.FisSearchUri;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Country;
import com.lipskii.ski_jumping_system.entity.Region;
import com.lipskii.ski_jumping_system.service.CityService;
import com.lipskii.ski_jumping_system.service.CountryService;
import com.lipskii.ski_jumping_system.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    private final CityService cityService;
    private final CountryService countryService;
    private final FetchPeople fetchPeople;
    private final RegionService regionService;
    protected final Logger log = Logger.getLogger(getClass().getName());


    @Autowired
    public HomeController(CityService cityService, CountryService countryService, FetchPeople fetchPeople, RegionService regionService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.fetchPeople = fetchPeople;
        this.regionService = regionService;
    }

    @GetMapping("/")
    public String connectionTest(Model model){

        return "helloworld";
    }

    @GetMapping("/addregions")
    public String addRegions(Model model){

        List<Country> countries = countryService.findAll();
        countries.remove(0);
        model.addAttribute("countries",countries);

        System.out.println(countryService.findFirstById());
        model.addAttribute("selectedCountry",countryService.findFirstById());

        List<Region> regions = regionService.findAll();
        model.addAttribute("regions",regions);

        model.addAttribute("region",new Region());

        return "addregions";
    }

    @PostMapping("/addregions")
    public String addRegions(@ModelAttribute("region") Region region, Model model){

        region.setName(region.getName().trim());
        regionService.save(region);

        List<Region> regions = regionService.findAll();
        model.addAttribute("regions",regions);

        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);

        model.addAttribute("selectedCountry",region.getCountry());

        return "addregions";
    }

    @PostMapping("/addathletes")
    public String addAthletes(@ModelAttribute("searchUri") FisSearchUri searchUri, Model model){

        String searchLink = "https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&" +
                "firstname=&sectorcode=JP" +
                "&gendercode=M" +
                "&birthyear=" + searchUri.getDecade() +
                "&skiclub=" +
                "&skis=" +
                "&nationcode=" + searchUri.getCode() +
                "&fiscode=" +
                "&status=" +
                "&search=true";

        ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch(searchLink);
        model.addAttribute("peopleData",fetchedPersonObjectList);

        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);

        List<Region> regions = regionService.findRegionByCountryCode(searchUri.getCode());
        model.addAttribute("regions",regions);

        List<City> cities = cityService.findCityByCountry(searchUri.getCode());
        model.addAttribute("cities",cities);

        model.addAttribute("searchUri",searchUri);

        model.addAttribute("city",new City());



        return "addathletes";
    }

    @GetMapping("/addathletes")
    public String addAthletes(Model model){
        System.out.println("GET");

       ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&sectorcode=JP&gendercode=M&birthyear=2020&skiclub=&skis=&nationcode=POL&fiscode=&status=&search=true");
       model.addAttribute("peopleData",fetchedPersonObjectList);

       List<Region> regions = regionService.findAll();
       model.addAttribute("regions",regions);

       List<City> cities = cityService.findCityByCountry("POL");
       model.addAttribute("cities",cities);

       List<Country> countries = countryService.findAll();
       model.addAttribute("countries",countries);

       model.addAttribute("city",new City());

       model.addAttribute("searchUri", new FisSearchUri());

        return "addathletes";
    }

    @GetMapping("/addathletes/{code}")
    public String addAthletes(Model model, @PathVariable String code){


        ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&sectorcode=JP&gendercode=M&birthyear=2020&skiclub=&skis=&nationcode=POL&fiscode=&status=&search=true");
        model.addAttribute("peopleData",fetchedPersonObjectList);

        List<Region> regions = regionService.findAll();
        model.addAttribute("regions",regions);

        List<City> cities = cityService.findCityByCountry(code);
        model.addAttribute("cities",cities);

        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);

        model.addAttribute("city",new City());

        model.addAttribute("searchUri", new FisSearchUri());

        return "addathletes";
    }

    @PostMapping("/addcity")
    public String addCity(@ModelAttribute("city") City city){
        System.out.println(city.getRegion().getCountry().getCode());
        System.out.println("CITY " + city);
        return "redirect:/addathletes/" + city.getRegion().getCountry().getCode();
    }
}
