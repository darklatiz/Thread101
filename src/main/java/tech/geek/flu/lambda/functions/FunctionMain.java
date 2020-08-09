package tech.geek.flu.lambda.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionMain {

  //This functional interface is used for transformation
  public static void main(String[] args) {
    List<String> strings = List.of("Hola a todos", "Como esta", "Whats going on", "A su mare", "", "05", "this", "ulala");
    Function<String, Integer> stringIntegerFunction = str -> str.length();

    Function<String, Integer> stringIntegerInstanceMethodReference = String :: length;


    List<Integer> lensOfStrings = map(strings, stringIntegerFunction);
    List<Integer> lensOfStrings1 = map(strings, stringIntegerInstanceMethodReference);
    System.out.println(strings);
    System.out.println("Regular lambda:            " + lensOfStrings);
    System.out.println("Instance Method Reference: " + lensOfStrings1);
    List<Integer> lens = strings.stream().map(stringIntegerFunction).collect(Collectors.toList());
    System.out.println("Using stream API:          " + lens);
  }

  private static <T, R> List<R> map(List<T> elemetns, Function<T, R> stringIntegerFunction) {
    List<R> result = new ArrayList<>();
    for (T element : elemetns) {
      result.add(stringIntegerFunction.apply(element));
    }
    return result;
  }

}
