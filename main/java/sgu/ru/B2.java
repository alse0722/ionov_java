package main.java.sgu.ru;

import java.util.Scanner;

public class B2 {
    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        public DayOfWeek addDays(int days) {
            int newIndex = (this.ordinal() + days) % 7;
            if (newIndex < 0) {
                newIndex += 7;
            }
            return DayOfWeek.values()[newIndex];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя дня недели и количество дней(Пример: sunday 10): ");
        String inputLine = scanner.nextLine();
        String[] inputParts = inputLine.split("\\s+");
        scanner.close();

        if (inputParts.length != 2) {
            System.out.println("Неправильный формат!");
            return;
        }

        String inputDay = inputParts[0].toUpperCase();
        DayOfWeek currentDay;
        try {
            currentDay = DayOfWeek.valueOf(inputDay);
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильно введен день недели!");
            return;
        }

        int daysToAdd;
        try {
            daysToAdd = Integer.parseInt(inputParts[1]);
            if (daysToAdd < 0) {
                System.out.println("Число должно быть положительным!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Неправильно введено число дней!");
            return;
        }

        DayOfWeek resultDay = currentDay.addDays(daysToAdd);

        System.out.println("Через " + daysToAdd + " дней будет: " + resultDay.toString().toLowerCase());
    }
}
