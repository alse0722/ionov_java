package main.java.sgu.ru;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.function.Consumer;

public class C2 {
    private static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static void manyTimes(Consumer<String> action) {
        String str = "";
        for (int i = 0; i < 100000; i++) {
            action.accept(str);
        }
    }

    public static void manyTimes2(Consumer<StringBuilder> action) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            action.accept(sb);
        }
    }

    public static void manyTimes3(Consumer<StringBuffer> action) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            action.accept(sb);
        }
    }

    private static Long testPlusString() {
        LocalTime startTime = LocalTime.now();

        manyTimes((str) -> str += generateRandomString());

        LocalTime endTime = LocalTime.now();

        return startTime.until(endTime, ChronoUnit.MICROS);
    }

    private static Long testConcatString() {

        LocalTime startTime = LocalTime.now();
        manyTimes((str) -> str.concat(generateRandomString()));
        LocalTime endTime = LocalTime.now();

        return startTime.until(endTime, ChronoUnit.MICROS);
    }

    private static Long testStringBuilder() {

        LocalTime startTime = LocalTime.now();
        manyTimes2((str) -> str.append(generateRandomString()));
        LocalTime endTime = LocalTime.now();

        return startTime.until(endTime, ChronoUnit.MICROS);
    }

    private static Long testStringBuffer() {

        LocalTime startTime = LocalTime.now();
        manyTimes3((str) -> str.append(generateRandomString()));
        LocalTime endTime = LocalTime.now();

        return startTime.until(endTime, ChronoUnit.MICROS);
    }

    public static void main(String[] args) {
        System.out.printf("testPlusString: %s\n", testPlusString());
        System.out.printf("testConcatString: %s\n", testConcatString());
        System.out.printf("testStringBuilder: %s\n", testStringBuilder());
        System.out.printf("testStringBuffer: %s\n", testStringBuffer());
    }
}
