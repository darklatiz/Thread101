package tech.geek.flu.lambda.Optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {
    Optional<String> stringOptional = Optional.of("Value en los textos");
    Optional<String> emptyOptional = Optional.empty();

    Function<String, String> stringStringFunction = str -> "new Value in Uppercas".toUpperCase();
    //map
    Optional<String> map = stringOptional.map(stringStringFunction);
    System.out.println("Map: " + map.get());

    String orElse = emptyOptional.map(stringStringFunction).orElse("Empty");
    System.out.println("In case of Empty: " + orElse);

    //filter
    Predicate<String> stringPredicate = s -> s.contains("Value");
    Predicate<String> notContains = s -> !s.contains("Value");

    stringOptional.filter(stringPredicate).ifPresent(s -> System.out.println(s.concat(" MMMM ")));

    //ifPresent
    Consumer<String> consumer = System.out::println;
    Runnable runnableEmpty = () -> System.out.println("Empty Value");
    Optional<String> empty = Optional.empty();
    Optional<String> newOptional = Optional.of("hi");
    newOptional.ifPresent(consumer);
    empty.ifPresent(consumer);

    //ifpresentElse
    newOptional.ifPresentOrElse(consumer, runnableEmpty);
    empty.ifPresentOrElse(consumer, runnableEmpty);



  }

}
