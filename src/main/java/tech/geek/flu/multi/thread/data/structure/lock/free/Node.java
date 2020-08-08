package tech.geek.flu.multi.thread.data.structure.lock.free;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) {
    this.value = value;
  }
}
