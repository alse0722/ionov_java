package oop.threads;

public class StartedViaThread extends Thread {
  public static void main(String[] args) {
    StartedViaThread thread = new StartedViaThread();
    thread.start();
    System.out.println("This code is outside of the thread");
  }
  public void run() {
    System.out.println("This code is running in a thread");
  }
}
