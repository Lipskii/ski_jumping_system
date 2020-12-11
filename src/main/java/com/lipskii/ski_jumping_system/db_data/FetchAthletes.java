package com.lipskii.ski_jumping_system.db_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Jsoup testing class (to be removed later).
 */

public class FetchAthletes {
    public static void main(String[] args) {
        List<String> biographiesLinks = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&sectorcode=JP&gendercode=M&birthyear=&skiclub=&skis=&nationcode=POL&fiscode=&status=&search=true").get();
            Elements elements = doc.getElementsByClass("table-row");

            for (Element element : elements) {
                biographiesLinks.add(element.attr("href"));
            }

        } catch (Exception e) {
            System.out.println("Error with reading links to FIS biographies: " + e);
        }


        for (String s : biographiesLinks) {
            System.out.println("***************************************************************************************");
            System.out.println(s);
            try {
                Document doc = Jsoup.connect(s).get();
                String firstName = doc.getElementsByClass("athlete-profile__name").text();
                firstName = firstName.substring(0, firstName.lastIndexOf(" ")).trim();

                String lastName = doc.getElementsByClass("athlete-profile__lastname").text();
                lastName = lastName.charAt(0) + lastName.substring(1).toLowerCase().trim();

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

                String country;
                country = doc.getElementsByClass("country__name").text();

                String city;
                city = doc.getElementById("Residence").text();
                city = city.replaceAll("Residence", "");
                city = city.replaceAll("– –", "");
                city = city.trim();

                boolean statusBool = true;
                String status;
                status = doc.getElementById("Status").text();
                status = status.replaceAll("Status","").trim();
                if(status.equals("Retired") || status.equals("Not active")){
                    statusBool = false;
                }

                String skis;
                skis = doc.getElementById("Skis").text();
                System.out.println(skis);
                skis = skis.replaceAll("Skis","");

                String skiClub;
                skiClub = doc.getElementsByClass("athlete-profile__team spacer__section").text().trim();



                System.out.println("##################################");
                System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastName);
                System.out.println("day: " + birthdate_day);
                System.out.println("month: " + birthdate_month);
                System.out.println("year: " + birthdate_year);
                System.out.println("country: " + country);
                System.out.println("city:" + city);
                System.out.println("status: " + statusBool);
                System.out.println("skis: " + skis);
                System.out.println("skiClub: " + skiClub);
                System.out.println("###################################");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
