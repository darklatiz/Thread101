package tech.geek.flu.lambda.functions;

import java.util.function.Supplier;

public class SupplierMain {

  public static void main(String[] args) {

    Supplier<String> stringSupplier = () -> new String("String suppiler, use get to get the string supplied");
    System.out.println(stringSupplier.get());

    Supplier<Double> randomInte = () -> Math.random();
    for(int i = 0 ; i < 10; i++) {
      System.out.println(randomInte.get());
    }
  }

}
