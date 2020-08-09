package tech.geek.flu.lambda.referece;

import java.util.function.BiFunction;

public class StaticReference {


  public static void main(String[] args) {

    BiFunction<String, String, String> biFunction = (a ,b) -> A_Class.staticMethod(a, b);
    System.out.println(biFunction.apply("Ho", "la!"));

    BiFunction<String, String, String> biFunctionStaticReference = A_Class :: staticMethod;
    System.out.println("Using Static Method Reference: " + biFunctionStaticReference.apply("Ho", "la!"));
  }

}

class A_Class {

  public static String staticMethod(String a, String b) {
    return a + b;
  }

}
