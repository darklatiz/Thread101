package tech.geek.flu.lambda.functional.programming;

public class HigherOrderFunctions {

  public static void main(String[] args) {

    IFactory<Integer> integerIFactory = createFactory(() -> Math.random() * 100, r -> r.intValue());
    for (int i  = 0; i < 100 ; i++) {
      System.out.println(integerIFactory.create());
    }

  }

  public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
    return () -> {
      T product = producer.produce();
      return configurator.configure(product);
    };
  }

}
