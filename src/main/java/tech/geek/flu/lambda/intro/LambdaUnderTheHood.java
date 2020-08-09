package tech.geek.flu.lambda.intro;

import java.util.stream.IntStream;

public class LambdaUnderTheHood {

  public static void main(String[] args) {

    int sum = IntStream.range(0, 101)
        .filter(i -> i % 2 == 0)
        .reduce((x, y) -> x + y)
        .getAsInt();

    int sum2 = IntStream.range(0, 101)
        .filter(i -> i % 2 == 0)
        .sum();

    System.out.println(sum);
    System.out.println(sum2);

  }



}
