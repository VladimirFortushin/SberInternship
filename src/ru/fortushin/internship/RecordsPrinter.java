package ru.fortushin.internship;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RecordsPrinter {

    private final City recordsSource = new City();
    private final Set<String> resultSet = new HashSet<>();

    public void printRecords() {
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(recordsSource.getFilePath())) {
            while (sc.hasNextLine()) {
                String record = sc.nextLine();
                sb.append(record + "delimiter");
            }
        } catch (IOException e) {
            System.out.println("Couldn't find the data source for " + recordsSource.getFilePath());
            e.printStackTrace();
        }

        String[] splitRecords = sb.toString().split("delimiter");
        long counter = 0;
        // Получили массив всех городов + название региона по каждой записи
        // Через стрим посчитали количество повторений регионов в списке (кол-во повторений == кол-во городов)

        for (int i = 0; i < splitRecords.length; i++) {
            String[] subRecords = splitRecords[i].split(";");
            counter = Arrays.stream(splitRecords)
                    .filter(x -> x.contains(subRecords[2]))
                    .count();
            resultSet.add(subRecords[2] + " - " + counter);
        }
        resultSet.forEach(System.out::println);
    }
}