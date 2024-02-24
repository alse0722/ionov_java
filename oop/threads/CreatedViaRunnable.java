package oop.threads;

public class CreatedViaRunnable implements Runnable {
  public void run() {
    System.out.println("This code is running in a thread");
  }
}
