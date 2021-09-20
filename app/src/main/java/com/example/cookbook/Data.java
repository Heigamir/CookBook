package com.example.cookbook;

import java.util.ArrayList;

public class Data {
    public static String name;
    public static ArrayList<String> listCountries = new ArrayList<>();
    public static ArrayList<Recipe> listRecipe = new ArrayList<>();
    static Recipe test= new Recipe();
    static void getListCountries() {
        listCountries.add("Anglia");
        listCountries.add("Afryka");
        listCountries.add("Francja");
        listCountries.add("Hiszpania");
        listCountries.add("Indie");
        listCountries.add("Japonia");
        listCountries.add("Polska");
    }
    static void getListRecipe() {
        test= new Recipe();
        test.name="Dahl";
        test.countrie="Indie";
        test.ingridients = new String[]{"Groch łuskany", "Kasza jaglana"};
        listRecipe.add(test);

        test= new Recipe();
        test.name="Crepe";
        test.countrie="Francja";
        test.ingridients = new String[]{"Mleko", "Mąka", "Jajko"};
        listRecipe.add(test);

        test= new Recipe();
        test.name="Kotlet schabowy";
        test.countrie="Polska";
        test.ingridients = new String[]{"Schab", "Jajko", "Bułka tarta", "Mąka"};
        listRecipe.add(test);

        test= new Recipe();
        test.name="Bigos";
        test.countrie="Polska";
        test.ingridients = new String[]{"Kapusta kiszona", "Kiełbasa"};
        listRecipe.add(test);
    }
}
