package base;
public class Strings {
  public static void main(String[] args) {
    String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    System.out.println("The length of the txt string is: " + txt.length());

    txt = "Hello World";
    System.out.println(txt.toUpperCase()); // Outputs "HELLO WORLD"
    System.out.println(txt.toLowerCase()); // Outputs "hello world"

    txt = "Please locate where 'locate' occurs!";
    System.out.println(txt.indexOf("locate")); // Outputs 7
    // more methods: https://www.w3schools.com/java/java_ref_string.asp

    String firstName = "John";
    String lastName = "Doe";
    System.out.println(firstName + " " + lastName);
    System.out.println(firstName.concat(lastName));

    String x = "10";
    int y = 20;
    String z = x + y; // z will be 1020 (a String)
    System.out.println(z);

    /*
    \'	'	Single quote
    \"	"	Double quote
    \\	\	Backslash
    \n	New Line	
    \r	Carriage Return	
    \t	Tab	
    \b	Backspace	
    \f	Form Feed
    */
  }
}
