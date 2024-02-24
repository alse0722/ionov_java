package base;
public class Variables {
  public static void main(String[] args) {
    String name = "alex";
    System.out.println(name);

    int myNum = 15;
    System.out.println(myNum);

    final int num = 20;
    System.out.println(num);

    myNum = 5;
    float myFloatNum = 5.99f;
    char myLetter = 'D';
    boolean myBool = true;
    String myText = "Hello";

    System.out.println(myFloatNum);
    System.out.println(myLetter);
    System.out.println(myBool);
    System.out.println(myText);

    String firstName = "John ";
    String lastName = "Doe";
    String fullName = firstName + lastName;
    System.out.println(fullName);

    int x = 5, y = 6, z = 50;
    System.out.println(x + y + z);

    x = y = z = 50;
    System.out.println(x + y + z);
  }
}
