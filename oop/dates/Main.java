package oop.dates;

import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
import java.time.LocalDateTime; // import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Main {
  public static void main(String[] args) {
    LocalDate myObj = LocalDate.now(); // Create a date object
    System.out.println(myObj); // Display the current date

    LocalTime myObj1 = LocalTime.now();
    System.out.println(myObj1);

    LocalDateTime myObj2 = LocalDateTime.now();
    System.out.println(myObj2);

    LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myDateObj);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
  }
}

// LocalDate	Represents a date (year, month, day (yyyy-MM-dd))
// LocalTime	Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
// LocalDateTime	Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
// DateTimeFormatter	Formatter for displaying and parsing date-time objects

// yyyy-MM-dd	"1988-09-29"	
// dd/MM/yyyy	"29/09/1988"	
// dd-MMM-yyyy	"29-Sep-1988"	
// E, MMM dd yyyy	"Thu, Sep 29 1988"