package ru.fortushin.internship;

import java.nio.file.Path;
import java.nio.file.Paths;

public class City {
    private String name;
    private String region;
    private String district;
    //String population, тк учитывается, что могут быть строковые символы
    private String population;
    private String foundation;

    public City() {
    }

    public City(String name, String region, String district, String population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public Path getFilePath() {
        String dataSourceFilePath = "resources/directory.txt";
        return Paths.get(dataSourceFilePath);
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "ru.fortushin.internship.City{name='" + name
                + "', region='" + region
                + "', district='" + district
                + "', population=" + population
                + ", foundation='" + foundation
                + "'}";
    }
}