package main.java.sgu.ru;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A3 {
    public static void main(String[] args) {
        A3 a3 = new A3();
        List<Map<String, String>> inputData = a3.parseFile("main\\java\\sgu\\ru\\files\\A3_input.txt");
        
        if (inputData.isEmpty()){
            return;
        }

        System.out.println("\nИсходные данные:");
        a3.printData(inputData);

        a3.sortByAscForStringValue(inputData, "Lastname");
        System.out.println("\nДанные после сортировки по ключу Lastname:");
        a3.printData(inputData);

        a3.sortByAscForStringValue(inputData, "Firstname");
        System.out.println("\nДанные после сортировки по ключу Firstname:");
        a3.printData(inputData);

        a3.sortByAscForStringValue(inputData, "Surname");
        System.out.println("\nДанные после сортировки по ключу Surname:");
        a3.printData(inputData);

        a3.sortByAscForStringValue(inputData, "Company");
        System.out.println("\nДанные после сортировки по ключу Company:");
        a3.printData(inputData);

        a3.sortByAscForIntegerValue(inputData, "Rating");
        System.out.println("\nДанные после сортировки по ключу Rating:");
        a3.printData(inputData);
    }

    private List<Map<String, String>> parseFile(String filename) {
        List<Map<String, String>> inputData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                Map<String, String> input = parseLine(line);
                inputData.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputData;
    }

    private Map<String, String> parseLine(String line) {
        Map<String, String> input = new HashMap<>();
        String[] parts = line.split(" ");
        input.put("Lastname", parts[0]);
        input.put("Firstname", parts[1]);
        input.put("Surname", parts[2]);
        input.put("Company", parts[3]);
        input.put("Rating", parts[4]);
        return input;
    }

    private void sortByAscForStringValue(List<Map<String, String>> data, String key) {
        data.sort(Comparator.comparing(m -> m.get(key)));
    }

    private void sortByAscForIntegerValue(List<Map<String, String>> data, String key) {
        data.sort(Comparator.comparingInt(m -> Integer.parseInt(m.get(key))));
    }

    private void printData(List<Map<String, String>> employeeData) {
        for (Map<String, String> employee : employeeData) {
            String lastname = employee.get("Lastname");
            String firstname = employee.get("Firstname");
            String surname = employee.get("Surname");
            String company = employee.get("Company");
            String rating = employee.get("Rating");

            String output = String.format(
                    "Lastname: %-15s | Firstname: %-15s | Surname: %-15s | Company: %-10s | Rating: %s",
                    lastname, firstname, surname, company, rating);
            System.out.println(output);
        }
    }
}
