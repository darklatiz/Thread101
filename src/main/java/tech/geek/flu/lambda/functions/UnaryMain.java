package tech.geek.flu.lambda.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UnaryMain {

  public static void main(String[] args) {
    List<Integer> integers = List.of(12,34,5,67,89,89,67);
    UnaryOperator<Integer> multiplier = integer -> integer * 100;

    List<Integer> results = integers.stream().map(multiplier).collect(Collectors.toList());
    System.out.println("Multplier result: " + results);
    List<Integer> res = map(integers, multiplier);
    System.out.println("Multplier result: " + res);

  }

  private static <T> List<T> map(List<T> elements, UnaryOperator<T> unaryOperator) {
    List<T> result = new ArrayList<>();
    for(T ele : elements) {
      result.add(unaryOperator.apply(ele));
    }
    return result;
  }


}
