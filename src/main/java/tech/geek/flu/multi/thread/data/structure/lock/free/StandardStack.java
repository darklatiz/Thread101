package tech.geek.flu.multi.thread.data.structure.lock.free;

import lombok.Getter;

@Getter
public class StandardStack<T> implements Stackable<T> {

  private Node<T> head;
  private int counter;

  public synchronized void push(T value) {
    Node<T> newHead = new Node<>(value);
    newHead.setNext(head);
    counter++;
  }

  public synchronized T pop() {
    if(head == null) {
      counter++;
      return null;
    }

    Node<T> current = head;
    head = current.getNext();
    return current.getValue();
  }

}
