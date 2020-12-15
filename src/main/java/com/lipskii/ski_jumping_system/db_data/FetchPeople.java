package com.lipskii.ski_jumping_system.db_data;

import com.lipskii.ski_jumping_system.service.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base for further implementing. Will be deleted later.
 */
@Component
public class FetchPeople {

    protected final Logger log = Logger.getLogger(FetchPeople.class.getName());

    private final PersonService personService;
    private final CountryService countryService;
    private final CityService cityService;
    private final GenderService genderService;
    private final RegionService regionService;

    @Autowired
    public FetchPeople(PersonService personService, CountryService countryService, CityService cityService, GenderService genderService,
                       RegionService regionService) {
        this.personService = personService;
        this.countryService = countryService;
        this.cityService = cityService;
        this.genderService = genderService;
        this.regionService = regionService;
    }


    public ArrayList<FetchedPersonObject> fetchPeopleFromFisSearch(String link) {

        List<String> biographiesLinks = new ArrayList<>();
        ArrayList<FetchedPersonObject> fetchedPersonObjects = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(link).get();
            Elements elements = doc.getElementsByClass("table-row");
            for (Element element : elements) {
                biographiesLinks.add(element.attr("href"));
            }

            // fetchPeopleFromBiographies(biographiesLinks);
            fetchedPersonObjects = getPeopleFromBiographies(biographiesLinks);

        } catch (Exception e) {
            log.log(Level.WARNING, "Links to fis biographies not loaded properly", e);
        }

        return fetchedPersonObjects;
    }

    private ArrayList<FetchedPersonObject> getPeopleFromBiographies(List<String> biographiesLinks) {
        ArrayList<FetchedPersonObject> arrayList = new ArrayList<>();

        for (String biographyLink : biographiesLinks) {
            log.log(Level.INFO, "Current biography link: " + biographyLink);
            try {
                Document doc = Jsoup.connect(biographyLink).get();


                String firstName = doc.getElementsByClass("athlete-profile__name").text();
                if(firstName.lastIndexOf(" ") > -1) {
                    firstName = firstName.substring(0, firstName.lastIndexOf(" ")).trim();
                }


                String lastName = doc.getElementsByClass("athlete-profile__lastname").text();
                if(lastName.length() > 1 ) {
                    lastName = lastName.charAt(0) + lastName.substring(1).toLowerCase().trim();
                }


                String countryBio;
                countryBio = doc.getElementsByClass("country__name").text();


                String cityBio;
                cityBio = doc.getElementById("Residence").text();
                cityBio = cityBio.replaceAll("Residence", "");
                cityBio = cityBio.replaceAll("– –", "");
                cityBio = cityBio.trim();


                String birthdate_year = "";
                String birthdate_month = "";
                String birthdate_day = "";
                String birthdate = doc.getElementById("Birthdate").text();
                birthdate = birthdate.replaceAll("Birthdate", "").trim();

                if (birthdate.length() == 4) {
                    birthdate_year = birthdate;
                }
                if (birthdate.length() == 10) {
                    birthdate_day = birthdate.substring(0, 2);
                    birthdate_month = birthdate.substring(3, 5);
                    birthdate_year = birthdate.substring(6);
                }

                log.log(Level.INFO, "Read biography with data: " + firstName + " " + lastName + " " +
                        countryBio + " " + cityBio + " " + birthdate_day + "-" + birthdate_month + "-" + birthdate_year);

                FetchedPersonObject fetchedPersonObject = new FetchedPersonObject(firstName,lastName,countryBio,cityBio,birthdate_day,birthdate_month,birthdate_year);
                arrayList.add(fetchedPersonObject);

            } catch (IOException e) {
                log.log(Level.WARNING, "Error reading biography", e);
            }
        }
        return arrayList;
    }

    //        private void fetchPeopleFromBiographies(List < String > biographiesLinks) {
//            for (String biographyLink : biographiesLinks) {
//                log.log(Level.INFO, "Current biography link: " + biographyLink);
//                try {
//                    Document doc = Jsoup.connect(biographyLink).get();
//
//                    String firstName = doc.getElementsByClass("athlete-profile__name").text();
//                    firstName = firstName.substring(0, firstName.lastIndexOf(" ")).trim();
//
//                    String lastName = doc.getElementsByClass("athlete-profile__lastname").text();
//                    lastName = lastName.charAt(0) + lastName.substring(1).toLowerCase().trim();
//
//                    String countryBio;
//                    countryBio = doc.getElementsByClass("country__name").text();
//                    Country country = new Country("countryBio", countryBio.substring(0, 3).toUpperCase());
//                    countryService.saveIfNotExists(country);
//
//                    String cityBio;
//                    cityBio = doc.getElementById("Residence").text();
//                    cityBio = cityBio.replaceAll("Residence", "");
//                    cityBio = cityBio.replaceAll("– –", "");
//                    cityBio = cityBio.trim();
//                    log.log(Level.INFO, "cityBio name is: " + cityBio);
//
//                    if (!cityBio.equals("")) {
//                        log.log(Level.INFO, "cityBio for: " + firstName + " " + lastName + " is not empty");
//                        City city = new City(cityBio, regionService.findById(13).get());         //just to test
//                        cityService.saveIfNotExists(city);
//                    } else {
//                        log.log(Level.WARNING, "cityBio for: " + firstName + " " + lastName + " is empty");
//                    }
//
//                    String birthdate_year = "";
//                    String birthdate_month = "";
//                    String birthdate_day = "";
//                    String birthdate = doc.getElementById("Birthdate").text();
//                    birthdate = birthdate.replaceAll("Birthdate", "").trim();
//
//                    if (birthdate.length() == 4) {
//                        birthdate_year = birthdate;
//                    }
//                    if (birthdate.length() == 10) {
//                        birthdate_day = birthdate.substring(0, 2);
//                        birthdate_month = birthdate.substring(3, 5);
//                        birthdate_year = birthdate.substring(6);
//                    }
//                    log.log(Level.INFO, "Read biography with data: " + firstName + " " + lastName + " " +
//                            countryBio + " " + cityBio + " " + birthdate_day + "-" + birthdate_month + "-" + birthdate_year);
//
//                } catch (IOException e) {
//                    log.log(Level.WARNING, "Error reading biography", e);
//                }
//            }
//        }
}
