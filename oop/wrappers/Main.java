package oop.wrappers;

public class Main {
  public static void main(String[] args) {
    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println(myInt);
    System.out.println(myDouble);
    System.out.println(myChar);

    // ArrayList<int> myNumbers = new ArrayList<int>(); // Invalid
    // ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Valid

    System.out.println(myInt.intValue());
    System.out.println(myDouble.doubleValue());
    System.out.println(myChar.charValue());

    myInt = 100;
    String myString = myInt.toString();
    System.out.println(myString.length());
  }
}
// methods are used to get the value associated 
// with the corresponding wrapper object: 
// intValue(), byteValue(), shortValue(), longValue(), 
// floatValue(), doubleValue(), charValue(), booleanValue().

// byte	Byte
// short	Short
// int	Integer
// long	Long
// float	Float
// double	Double
// boolean	Boolean
// char	Character