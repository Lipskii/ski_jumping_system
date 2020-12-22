package com.lipskii.ski_jumping_system.db_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class FetchSkiClubs {

    protected final Logger log = Logger.getLogger(FetchSkisTool.class.getName());

    private final String link;

    public FetchSkiClubs(String link) {
        this.link = link;
    }

    public Set<String> getSkiClubs(){

        Set<String> skiClubs = new TreeSet<>();

        try{
            Document doc = Jsoup.connect(link).get();

            Elements elements = doc.getElementsByClass("clip-sm");

            for (Element element : elements){
                skiClubs.add(element.text());
            }

            skiClubs.remove("");

        } catch (Exception e){
            e.printStackTrace();
        }

        return skiClubs;
    }
}
