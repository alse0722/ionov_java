package main.java.sgu.ru;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class A2 {

    public void main(String[] args) {
        try {
            LocalDate[] minMaxDates = findMinMaxDatesFromFile("main\\java\\sgu\\ru\\files\\input_a1.txt");
            LocalDate minDate = minMaxDates[0];
            LocalDate maxDate = minMaxDates[1];
            System.out.println("Старшая дата: " + minDate);
            System.out.println("Младшая дата: " + maxDate);
            System.out.println("Дней между ними: " + minDate.until(maxDate, ChronoUnit.DAYS));
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public LocalDate[] findMinMaxDatesFromFile(String fileName) throws IOException {
        LocalDate minDate = null;
        LocalDate maxDate = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);

                LocalDate currentDate = LocalDate.of(year, month, day);

                if (minDate == null || currentDate.isBefore(minDate)) {
                    minDate = currentDate;
                }

                if (maxDate == null || currentDate.isAfter(maxDate)) {
                    maxDate = currentDate;
                }
            }
        }

        LocalDate[] minMaxDates = {minDate, maxDate};
        return minMaxDates;
    }
}
