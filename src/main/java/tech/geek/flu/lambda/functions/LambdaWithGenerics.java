package tech.geek.flu.lambda.functions;

public class LambdaWithGenerics {

  public static void main(String[] args) {
    //Input a string a returns a string
    FunctionalGenerics<String, String> functionalGenerics = s -> s.substring(1, 5);
    System.out.println(functionalGenerics.execute("Hola pinches perros de la verta"));

    //Input a string and returns an int
    FunctionalGenerics<String, Integer> functionalGenerics1 = s -> s.length();
    System.out.println(functionalGenerics1.execute("Hi everybody, look this is a loooong text..."));
  }
}
