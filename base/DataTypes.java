package base;
public class DataTypes {
  public static void main(String[] args) {

    // byte is from -128 to 127
    byte myByte = 100;
    System.out.println(myByte);

    // The short data type can store whole numbers from -32768 to 32767
    short myShort = 5000;
    System.out.println(myShort);

    // The int data type can store whole numbers from -2147483648 to 2147483647.
    int myInt = 13371337;
    System.out.println(myInt);

    // The long data type can store whole numbers from -9223372036854775808 to
    // 9223372036854775807
    long myLong = 15000000000L;
    System.out.println(myLong);

    // The precision of float is only six or seven decimal digits, while double
    // variables have a precision of about 15 digits.
    float myFloat = 5.75f;
    System.out.println(myFloat);

    double myDouble = 19.99d;
    System.out.println(myDouble);

    // A floating point number can also be a scientific number with an "e" to
    // indicate the power of 10
    float f1 = 35e3f;
    double d1 = 12E4d;
    System.out.println(f1);
    System.out.println(d1);

    boolean isJavaFun = true;
    boolean isFishTasty = false;
    System.out.println(isJavaFun); // Outputs true
    System.out.println(isFishTasty); // Outputs false

    char myGrade = 'B';
    System.out.println(myGrade);

    char myVar1 = 65, myVar2 = 66, myVar3 = 67;
    System.out.println(myVar1);
    System.out.println(myVar2);
    System.out.println(myVar3);

    String greeting = "Hello World";
    System.out.println(greeting);
  }
}
