package tech.geek.flu.lambda.functions;

@FunctionalInterface
public interface FunctionalGenerics<T, R> {

  R execute(T t);

}
