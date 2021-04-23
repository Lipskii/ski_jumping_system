package com.lipskii.ski_jumping_system;

import com.lipskii.ski_jumping_system.db_data.FetchedResultsObject;
import com.lipskii.ski_jumping_system.db_data.FetchedTeamResultObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TryOut {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5799").get();
         //   System.out.println(doc);
            Elements countryElements = doc.getElementsByClass("table-row table-row_theme_main m-0");
            Elements athletesElements = doc.getElementsByClass("table-row table-row_theme_additional");
        //    System.out.println(athletesElements.get(0));
            List<FetchedTeamResultObject> fetchedTeamResultObjects = new ArrayList<>();
            for (Element element : countryElements) {

                FetchedTeamResultObject fetchedTeamResultObject = new FetchedTeamResultObject();
               // rank
                int rank = Integer.parseInt(element.getElementsByClass("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right bold pr-1").text());
                fetchedTeamResultObject.setRank(rank);

                //country code
                fetchedTeamResultObject.setCountryCode(element.getElementsByClass("country__name-short").text());

                //total rank
                fetchedTeamResultObject.setTotalPoints(Float.parseFloat(element.getElementsByClass("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right").text()));

                fetchedTeamResultObject.setSkiJumper1Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                fetchedTeamResultObject.setSkiJumper2Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4+1)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                fetchedTeamResultObject.setSkiJumper3Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4+2)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                fetchedTeamResultObject.setSkiJumper4Code(Integer.parseInt(athletesElements
                        .get((rank-1)*4+3)
                        .getElementsByClass("g-lg-2 g-md-2 g-sm-3 hidden-xs justify-right gray pr-1").text()));

                System.out.println(fetchedTeamResultObject);
            }
//
//            List<String[]> stringArray = new ArrayList<>();
//            for (FetchedResultsObject fetchedResultsObject : fetchedResultsObjects) {
//                String[] row = new String[7];
//                row[0] = String.valueOf(fetchedResultsObject.getRank());
//                row[1] = String.valueOf(fetchedResultsObject.getCode());
//                row[2] = String.valueOf(fetchedResultsObject.getFirstRoundDistance());
//                row[3] = String.valueOf(fetchedResultsObject.getFirstRoundPoints());
//                row[4] = String.valueOf(fetchedResultsObject.getSecondRoundDistance());
//                row[5] = String.valueOf(fetchedResultsObject.getSecondRoundPoints());
//                row[6] = String.valueOf(fetchedResultsObject.getTotalPoints());
//                stringArray.add(row);
//
//            }

          // return stringArray;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
