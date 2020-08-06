package tech.geek.flu.multi.thread.locking;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class PriceContainer {
  private Lock lockObject = new ReentrantLock();

  private double bitcoin;
  private double ether;
  private double liteCoin;
  private double bitcoinCash;
  private double ripple;




}
