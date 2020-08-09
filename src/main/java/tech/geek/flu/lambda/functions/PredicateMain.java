package tech.geek.flu.lambda.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateMain {

  public static void main(String[] args) {
    List<String> strings = List.of("Basico", "Revolution", "", "Another string", "Blanck Panther", "", "");

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

  }

  private static List<String> filterList(List<String> strings, Predicate<String> predicate) {
    List<String> arr = new ArrayList<>();
    for(String s : strings) {
      if(predicate.test(s)) {
        arr.add(s);
      }
    }
    return arr;
  }

}
