package tech.geek.flu.lambda.intro;

public class LambdaExample {
  public static void main(String[] args) {
    Thread thread = new Thread(new IntroRunnable());
    Thread thread1 = new Thread(() -> System.out.println("Thread 02"));
    thread.start();
    thread1.start();

    MyFunctionalInterface fun = () -> { System.out.println("From a functional interface"); };
    fun.myFuckingMethod();

    onTheFly(() -> {for(int i = 0; i < 10; i++) {System.out.println("Ahhh perroo on the fly");}});


  }

  public static void onTheFly(MyFunctionalInterface functionalInterface) {
    functionalInterface.myFuckingMethod();
  }
}
