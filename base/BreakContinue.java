package base;

public class BreakContinue {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      if (i == 4) {
        break;
      }
      System.out.println(i);
    }
    System.out.println();

    for (int i = 0; i < 10; i++) {
      if (i == 4) {
        continue;
      }
      System.out.println(i);
    }
    System.out.println();

    int i = 0;
    while (i < 10) {
      System.out.println(i);
      i++;
      if (i == 4) {
        break;
      }
    }
    System.out.println();

    i = 0;
    while (i < 10) {
      if (i == 4) {
        i++;
        continue;
      }
      System.out.println(i);
      i++;
    }
  }
}
