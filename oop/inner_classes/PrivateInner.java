package oop.inner_classes;

class OuterClass {
  int x = 10;

  private class InnerClass {
    int y = 5;
  }
}

public class PrivateInner {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    // OuterClass.InnerClass myInner = myOuter.new InnerClass(); //errors
    // System.out.println(myInner.y + myOuter.x); //errors
  }
}