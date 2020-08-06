package tech.geek.flu.multi.thread.locking;

import java.util.Random;

public class PriceUpdater extends Thread {

  private PricesContainer priceContainer;
  private Random randomPrice =  new Random();

  public PriceUpdater(PricesContainer priceContainer) {
    this.priceContainer = priceContainer;
  }

  @Override
  public void run() {
    priceContainer.getLockObject().lock();
    try {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      priceContainer.setBitcoin(randomPrice.nextInt(20000));
      priceContainer.setBitcoinCash(randomPrice.nextInt(5000));
      priceContainer.setEther(randomPrice.nextInt(334554));
      priceContainer.setLiteCoin(randomPrice.nextInt(45322));
      priceContainer.setRipple(randomPrice.nextInt(98742));

    }finally {
      priceContainer.getLockObject().unlock();
    }
  }
}
