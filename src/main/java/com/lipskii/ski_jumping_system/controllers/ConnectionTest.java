package com.lipskii.ski_jumping_system.controllers;

import com.lipskii.ski_jumping_system.db_data.FetchPeople;
import com.lipskii.ski_jumping_system.db_data.FetchedPersonObject;
import com.lipskii.ski_jumping_system.entity.City;
import com.lipskii.ski_jumping_system.entity.Region;
import com.lipskii.ski_jumping_system.service.CityService;
import com.lipskii.ski_jumping_system.service.CountryService;
import com.lipskii.ski_jumping_system.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConnectionTest {

    private final CityService cityService;
    private final CountryService countryService;
    private final FetchPeople fetchPeople;
    private final RegionService regionService;


    @Autowired
    public ConnectionTest(CityService cityService, CountryService countryService, FetchPeople fetchPeople, RegionService regionService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.fetchPeople = fetchPeople;
        this.regionService = regionService;
    }

    @GetMapping("/")
    public String connectionTest(){

        return "helloworld";
    }

    @GetMapping("/addathletes")
    public String addAthletes(Model model){

       ArrayList<FetchedPersonObject> fetchedPersonObjectList = fetchPeople.fetchPeopleFromFisSearch("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&sectorcode=JP&gendercode=M&birthyear=1990&skiclub=&skis=&nationcode=POL&fiscode=&status=&search=true");
       model.addAttribute("peopleData",fetchedPersonObjectList);

       List<Region> regions = regionService.findAll();
       model.addAttribute("regions",regions);

       List<City> cities = cityService.findAll();
       model.addAttribute("cities",cities);

        return "addathletes";
    }
}
