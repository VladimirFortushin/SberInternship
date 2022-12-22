package ru.fortushin.internship.sorter;

import ru.fortushin.internship.City;

import java.util.Comparator;

public class Sorter {
    public Comparator<City> getMultiSorter() {
        return new SorterByDistrict().thenComparing(new SorterByCity());
    }
    public static class SorterByCityIgnoreCase implements Comparator<City> {

        @Override
        public int compare(City o1, City o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
    public static class SorterByDistrict implements Comparator<City> {

        @Override
        public int compare(City o1, City o2) {
            return o1.getDistrict().compareToIgnoreCase(o2.getDistrict());
        }
    }
    public static class SorterByCity implements Comparator<City> {

        @Override
        public int compare(City o1, City o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class SorterByRegion implements Comparator<City> {

        @Override
        public int compare(City o1, City o2) {
            return o1.getRegion().compareTo(o2.getRegion());
        }
    }

}
