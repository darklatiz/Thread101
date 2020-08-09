package tech.geek.flu.lambda.functions;

public class Main {

  public static void main(String[] args) {
    Name name = () -> System.out.println("Luis");
    name.name();

    MathOperation sumOperation = (a, b) -> System.out.println(a + b);
    sumOperation.operation(20, 20);

    MathOperation multiply = (a, b) -> System.out.println(a * b);
    multiply.operation(15, 10);

  }



}
