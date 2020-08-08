package tech.geek.flu.multi.thread.data.structure.lock.free;

public interface Stackable<T> {
  public void push(T value);
  public T pop();
}
