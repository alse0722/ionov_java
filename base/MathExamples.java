package base;
public class MathExamples {
  public static void main(String[] args) {
    Math.max(5, 10);
    Math.min(5, 10);
    Math.sqrt(64);
    Math.abs(-4.7);
    Math.random();

    int randomNum = (int)(Math.random() * 101);  // 0 to 100
    System.out.println(randomNum);

    // more: https://www.w3schools.com/java/java_ref_math.asp
  }
}
