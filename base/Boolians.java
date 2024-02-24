package base;
public class Boolians {
  public static void main(String[] args) {
    System.out.println(10 == 15);

    int x = 10;
    System.out.println(x == 10);

    int myAge = 25;
    int votingAge = 18;

    if (myAge >= votingAge) {
      System.out.println("Old enough to vote!");
    } else {
      System.out.println("Not old enough to vote.");
    }
  }
}
