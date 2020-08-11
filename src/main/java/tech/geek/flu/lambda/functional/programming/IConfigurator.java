package tech.geek.flu.lambda.functional.programming;

public interface IConfigurator<T, R> {

  R configure(T t);

}
