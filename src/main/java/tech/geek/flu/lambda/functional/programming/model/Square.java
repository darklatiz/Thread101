package tech.geek.flu.lambda.functional.programming.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Square {
  private Double sideLength;
  private Double area;

  public Square(Double sideLength) {
    this.sideLength = sideLength;
  }

  public Double getArea() {
    return sideLength * sideLength;
  }
}
