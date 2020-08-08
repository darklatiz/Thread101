package tech.geek.flu.multi.thread.data.structure.lock.free;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeStack<T> implements Stackable<T>{

  private AtomicReference<Node<T>> head = new AtomicReference<>();
  private AtomicInteger counter = new AtomicInteger(0);

  public static void main(String[] args) {
    LockFreeStack<Integer> stack = new LockFreeStack<>();
    Random random = new Random();
    for (int i = 0; i < 100000; i++) {
      stack.push(random.nextInt());
    }
    List<Thread> threads = new ArrayList<>();
    int pushingThreads = 2;
    int popingThreads = 2;

    for (int i = 0; i < pushingThreads ; i++) {
      Thread thread = new Thread(()  -> {
        while (true) {
          stack.push(random.nextInt());
        }
      });
      thread.setDaemon(true);
      threads.add(thread);
    }

    for (int i = 0; i < popingThreads; i++) {
      Thread thread = new Thread(() -> {
        while (true) {
          stack.pop();
        }
      });
      thread.setDaemon(true);
      threads.add(thread);
    }

    for(Thread th : threads) {
      th.start();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
    System.out.println("Total Number of operations: " + stack.counter);
  }


  @Override
  public void push(T value) {
    Node<T> newHead = new Node<>(value);
    //We have to try some times in order to put the head
    while (true) {
      Node<T> current = head.get();
      newHead.setNext(current);
      if(head.compareAndSet(current, newHead)) {
        break;
      } else {
        LockSupport.parkNanos(1);
      }
    }
  }

  @Override
  public T pop() {
    Node<T> current = head.get();
    Node<T> newHead;

    while (current != null) {
      newHead = current.getNext();
      if(head.compareAndSet(current, newHead)) {
        break;
      }else {
        LockSupport.parkNanos(1);
        current = head.get();
      }
    }
    counter.incrementAndGet();
    return current != null ? current.getValue() : null ;
  }

  public int getCounter() {
    return counter.get();
  }

}
