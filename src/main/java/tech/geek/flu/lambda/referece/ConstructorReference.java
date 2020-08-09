package tech.geek.flu.lambda.referece;

import java.util.function.Function;

public class ConstructorReference {

  public static void main(String[] args) {
    Function<Runnable, Thread>  threadGenerator = Thread :: new;
    Runnable task1 = () -> System.out.println("Task1 Executed");
    Runnable task2 = () -> System.out.println("Task2 Executed");

    Thread thread  = threadGenerator.apply(task1);
    Thread thread1 = threadGenerator.apply(task2);

    thread.start();
    thread1.start();

    threadGenerator.apply(() -> System.out.println("Task3 Executed")).start();
  }

}
