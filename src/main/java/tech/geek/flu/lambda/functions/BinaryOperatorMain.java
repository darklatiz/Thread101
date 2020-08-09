package tech.geek.flu.lambda.functions;

import java.util.function.BinaryOperator;

public class BinaryOperatorMain {

  public static void main(String[] args) {
    BinaryOperator<String> stringBinaryOperator = (str1, str2) -> {
      return str1 + "." + str2;
    };
    System.out.println(stringBinaryOperator.apply("Hola", "Separados por un punto"));
  }

}
