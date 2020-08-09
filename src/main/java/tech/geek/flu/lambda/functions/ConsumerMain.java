package tech.geek.flu.lambda.functions;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {

  public static void main(String[] args) {
    List<Integer> integers = List.of(1,2,3,6,7,23434,78789,2123,879789,23, -12, -345);
    Consumer<Integer> consumer = System.out::println;
    consumer.accept(56);
    printList(consumer, integers);
  }

  private static <T> void printList(Consumer<T> consumer, List<T> elements) {
    for(T element : elements ) {
      consumer.accept(element);
    }
  }


}
