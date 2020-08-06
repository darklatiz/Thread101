package tech.geek.flu.multi.thread.locking;

import lombok.Getter;

@Getter
public enum StockLabels {
  BITCOIN("BTC"),
  BITCOIN_CASH("BCH"),
  ETHEREUM("ETH"),
  LITE_COIN("LTC"),
  RIPPLE("XRP");

  private String id;

  StockLabels(String id) {
    this.id = id;
  }


}
