package main.java.sgu.ru;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("main/java/sgu/ru/files/input.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {

                    Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z]+");
                    Matcher matcher = pattern.matcher(line);
                    boolean valid = true;
                    while (matcher.find()) {
                        if (!matcher.group().equals(matcher.group().trim())) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) {
                        System.out.println("Строка содержит недопустимые символы.");
                        continue;
                    }

                    String[] parts = line.split("\\s+");
                    if (parts.length < 3 || !isName(parts[1]) || !isName(parts[2])) {
                        System.out.println("Не хватает фамилии, имени или отчества, либо содержит недопустимые символы.");
                        continue;
                    }
                    
                    String firstName = parts[1];
                    String lastName = parts[0];
                    String patronymic = parts[2];

                    String initials = lastName.substring(0, 1) + ".";
                    if (!patronymic.isEmpty()) {
                        initials += patronymic.substring(0, 1) + ".";
                    }
                    System.out.println(firstName + " " + initials);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isName(String str) {
        return str.matches("[а-яА-Яa-zA-Z]+");
    }
}








