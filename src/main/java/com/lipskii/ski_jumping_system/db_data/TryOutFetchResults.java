package com.lipskii.ski_jumping_system.db_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TryOutFetchResults {

    public static void main(String[] args) {
        fetchResults("https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5882");
    }

    public static void fetchResults(String link) {
        try {
            Document doc = Jsoup.connect(link).get();
            Elements elements = doc.getElementsByClass("table-row");
            List<FetchedResultsObject> fetchedResultsObjects = new ArrayList<>();

            for (Element element : elements) {
                if (!element.getElementsByClass("g-lg g-md g-sm g-xs justify-left bold").text().equals("")) {

                    FetchedResultsObject fetchedResultsObject = new FetchedResultsObject();
                    if (!element.getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right pr-1 gray bold")
                            .text().equals("")) {
                        fetchedResultsObject.setRank(Integer
                                .parseInt(element
                                        .getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right pr-1 gray bold")
                                        .text()));
                    }
                    if (!element.getElementsByClass("g-lg-2 g-md-2 g-sm-2 hidden-xs justify-right gray pr-1")
                            .text().equals("")) {
                        fetchedResultsObject.setCode(Integer
                                .parseInt(element
                                        .getElementsByClass("g-lg-2 g-md-2 g-sm-2 hidden-xs justify-right gray pr-1")
                                        .text()));
                    }
                    if (!element.getElementsByClass("g-row justify-right bold")
                            .text().equals("")) {
                        String[] distances = element.getElementsByClass("g-row justify-right bold")
                                .text().split(" ");

                        if (distances.length == 1) {
                            fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                        } else {
                            fetchedResultsObject.setFirstRoundDistance(Float.parseFloat(distances[0]));
                            fetchedResultsObject.setSecondRoundDistance(Float.parseFloat(distances[1]));
                        }
                    }
                    if (!element.getElementsByClass("g-lg-24 justify-right bold")
                            .text().equals("")) {
                        String[] points = element.getElementsByClass("g-lg-24 justify-right bold")
                                .text().split(" ");

                        if (points.length == 1) {
                            fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                        } else {
                            fetchedResultsObject.setFirstRoundPoints(Float.parseFloat(points[0]));
                            fetchedResultsObject.setSecondRoundPoints(Float.parseFloat(points[1]));
                        }
                    }
                    if (!element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right blue bold ")
                            .text().equals("")) {
                        fetchedResultsObject.setTotalPoints(Float.parseFloat(element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right blue bold ")
                                .text()));
                    }
                    fetchedResultsObjects.add(fetchedResultsObject);
                }

            }
            System.out.println(Arrays.toString(fetchedResultsObjects.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
