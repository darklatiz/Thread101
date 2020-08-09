package tech.geek.flu.lambda.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateMain {

  public static void main(String[] args) {
    List<String> strings = List.of("Basico", "Revolution", "", "Another string10", "Blanck Panther", "", "");

    Predicate<String> isEmptyPredicate = s -> !s.isEmpty();
    System.out.println("Before Predicate:        " + strings);
    List<String> nList = strings.stream().filter(isEmptyPredicate).collect(Collectors.toList());
    System.out.println("After isEmptyPredicate applied: " + nList);

    Predicate<String> containsLetter = s -> s.contains("h");
    List<String> nListWIthoutStream = filterList(strings, containsLetter);
    System.out.println(nListWIthoutStream);
    System.out.println("Without Streams : "  + nListWIthoutStream);

    List<String> nListWIthStream = strings.stream().filter(containsLetter).collect(Collectors.toList());
    System.out.println("UsingStreams : "  + nListWIthStream);

    Predicate<String> lenGreaterThan10 = s -> s.length() > 15;
    List<String> nn = filterList(strings, lenGreaterThan10);
    List<String> nn1 = strings.stream().filter(lenGreaterThan10).collect(Collectors.toList());
    System.out.println("List with elements which size > 10: " + nn);
    System.out.println("List with elements which size > 10: " + nn1);

  }

  private static <T> List<T> filterList(List<T> strings, Predicate<T> predicate) {
    List<T> arr = new ArrayList<>();
    for(T s : strings) {
      if(predicate.test(s)) {
        arr.add(s);
      }
    }
    return arr;
  }

}
