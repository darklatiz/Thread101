package tech.geek.flu.lambda.functions;

import java.util.function.BiFunction;

public class BiFunctionMain {

  public static void main(String[] args) {
    BiFunction<String, String, String> stringStringStringBiFunction = (a, b) -> a + " " + b;
    System.out.println(stringStringStringBiFunction.apply("Hola", "amikos!"));

    BiFunction<String, String, Integer> stringStringIntegerBiFunction = (str1, str2) -> {
      String n = str1 + str2;
      return n.length();
    };
    System.out.println("Len: " + stringStringIntegerBiFunction.apply("Mas te vale", "hacerlo!"));

  }

}
