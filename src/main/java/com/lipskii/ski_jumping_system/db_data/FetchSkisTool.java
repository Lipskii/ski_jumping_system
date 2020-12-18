package com.lipskii.ski_jumping_system.db_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A tool to get all skis brand
 */
public class FetchSkisTool {

    protected static final Logger log = Logger.getLogger(FetchSkisTool.class.getName());

    public static void main(String[] args) {

        fetchBiographies("https://www.fis-ski.com/DB/ski-jumping/biographies.html?lastname=&firstname=&" +
                "sectorcode=JP&gendercode=M&birthyear=1995-2000" +
                "&skiclub=&skis=&nationcode=&fiscode=&status=&search=true");
    }


    public static void fetchBiographies(String link){

        List<String> biographiesLinks = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(link).get();
            Elements elements = doc.getElementsByClass("table-row");
            for (Element element : elements) {
                biographiesLinks.add(element.attr("href"));
            }

            fetchSkis(biographiesLinks);

        } catch (Exception e) {
            log.log(Level.WARNING, "Links to fis biographies not loaded properly", e);
        }
    }

    private static void fetchSkis(List<String> biographiesLinks){
        HashSet<String> skisList = new HashSet<>();

        for(String link : biographiesLinks){
            try{
                Document doc = Jsoup.connect(link).get();

                System.out.println(doc.getElementsByClass("athlete-profile__name").text());
                skisList.add(doc.getElementById("Skis").text());

                System.out.println(skisList);

            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
