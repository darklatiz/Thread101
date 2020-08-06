package tech.geek.flu.multi.thread.locking;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StockUI extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Crypto Currency Prices");

    GridPane gridPane = createGrid();
    Map<StockLabels, Label> cryptoLabels = createCryptoPriceLabels();

  }

  private Map<StockLabels, Label> createCryptoPriceLabels() {
    Label bitcoinPrice = new Label("0");
    bitcoinPrice.setId(StockLabels.BITCOIN.getId());

    Label etherPrice = new Label("0");
    etherPrice.setId(StockLabels.ETHEREUM.getId());

    Label liteCoinPrice = new Label("0");
    liteCoinPrice.setId(StockLabels.LITE_COIN.getId());

    Label bitcoinCashPrice = new Label("0");
    bitcoinCashPrice.setId(StockLabels.BITCOIN_CASH.getId());

    Label ripplePrice = new Label("0");
    ripplePrice.setId(StockLabels.RIPPLE.getId());

    Map<StockLabels, Label> labelMap = new HashMap<>();
    labelMap.put(StockLabels.BITCOIN, bitcoinPrice);
    labelMap.put(StockLabels.BITCOIN_CASH, bitcoinCashPrice);
    labelMap.put(StockLabels.ETHEREUM, etherPrice);
    labelMap.put(StockLabels.LITE_COIN, liteCoinPrice);
    labelMap.put(StockLabels.RIPPLE, ripplePrice);

    return labelMap;
  }

  private GridPane createGrid() {
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setAlignment(Pos.CENTER);
    return gridPane;
  }


}
