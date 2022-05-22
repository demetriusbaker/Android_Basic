package com.hfad.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<String> getBrands(String color){
        List<String> brands = new ArrayList<>();

        switch (color){
            case "светлое": {
                brands.add("Heineken");
                brands.add("Амстел");
                brands.add("Бавария");
                brands.add("Три медведя");
                break;
            }
            case "янтарное": {
                brands.add("Жигулевское");
                brands.add("AmberWeiss");
                brands.add("Ghost Ship");
                brands.add("Таркос Червонный Валет");
                break;
            }
            case "коричневое": {
                brands.add("Viaemilia");
                brands.add("Samiec Alfa");
                brands.add("Julius");
                brands.add("Orval");
                break;
            }
            case "темное": {
                brands.add("Guinness");
                brands.add("Krusovice Cerne");
                brands.add("Taler");
                brands.add("Светлячок");
                break;
            }
        }

        return brands;
    }
}
