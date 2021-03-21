package com.lipskii.ski_jumping_system;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class TryOut {
    public static void main(String[] args) {

        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Bartek\\IdeaProjects\\ski_jumping_system\\src\\main\\resources\\files\\results\\wyniki.csv"))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
