package methods;

public class Parametres {
  static void myMethod(String fname) {
    System.out.println(fname + " Refsnes");
  }

  static void myMethod2(String fname, int age) {
    System.out.println(fname + " is " + age);
  }

  static int myMethod3(int x) {
    return 5 + x;
  }

  static int myMethod4(int x, int y) {
    return x + y;
  }

  static void checkAge(int age) {

    if (age < 18) {
      System.out.println("Access denied - You are not old enough!");

    } else {
      System.out.println("Access granted - You are old enough!");
    }

  }

  public static void main(String[] args) {
    myMethod("Liam");
    myMethod("Jenny");
    myMethod("Anja");

    myMethod2("Liam", 5);
    myMethod2("Jenny", 8);
    myMethod2("Anja", 31);

    System.out.println(myMethod3(3));

    System.out.println(myMethod4(5, 3));

    int z = myMethod4(5, 3);
    System.out.println(z);

    checkAge(20);
  }
}
