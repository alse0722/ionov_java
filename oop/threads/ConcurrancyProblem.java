package oop.threads;

public class ConcurrancyProblem extends Thread {
  public static int amount = 0;

  public static void main(String[] args) {
    ConcurrancyProblem thread = new ConcurrancyProblem();
    thread.start();
    System.out.println(amount);
    amount++;
    System.out.println(amount);
  }

  public void run() {
    amount++;
  }
}