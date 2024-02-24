package base;

public class Arrays {
  public static void main(String[] args) {
    String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
    int[] myNum = { 10, 20, 30, 40 };

    System.out.println(cars[0]);
    System.out.println(myNum);
    System.out.println(myNum[1]);

    cars[0] = "Opel";
    System.out.println(cars[0]);

    System.out.println(cars.length);

    // String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    for (int i = 0; i < cars.length; i++) {
      System.out.println(cars[i]);
    }

    for (String i : cars) {
      System.out.println(i);
    }

    int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
    System.out.println(myNumbers[1][2]);

    myNumbers[1][2] = 9;
    System.out.println(myNumbers[1][2]);

    int[][] myNumbers1 = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
    for (int i = 0; i < myNumbers1.length; ++i) {
      for (int j = 0; j < myNumbers1[i].length; ++j) {
        System.out.println(myNumbers1[i][j]);
      }
    }
  }
}
