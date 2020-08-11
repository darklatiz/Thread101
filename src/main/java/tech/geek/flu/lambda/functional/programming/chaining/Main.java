package tech.geek.flu.lambda.functional.programming.chaining;

import tech.geek.flu.lambda.functional.programming.interfaces.Consumer;

import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    Consumer<String> sysoutString = System.out::println;
    Consumer<String> sysoutString1 = System.out::println;
    Consumer<String> c = sysoutString.thenAccept(sysoutString1);
    c.accept("Consuming chaining");

    Function<Integer, Integer> f1 = number -> number + 2;
    Function<Integer, Integer> f2 = number -> number * 2;
    Function<Integer, Integer> f3 = f1.andThen(f2);
    System.out.println(f3.apply(5));
  }



}
