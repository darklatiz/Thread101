package tech.geek.flu.lambda.intro;

public class IntroRunnable implements Runnable{
  @Override
  public void run() {
    System.out.println("Thread executed!");
  }
}
