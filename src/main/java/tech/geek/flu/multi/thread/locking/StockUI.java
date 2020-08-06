package tech.geek.flu.multi.thread.locking;

import javafx.animation.AnimationTimer;
import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class StockUI extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Crypto Currency Prices");

    GridPane gridPane = createGrid();
    Map<StockLabels, Label> cryptoLabels = createCryptoPriceLabels();
    addLabelsToGrid(cryptoLabels, gridPane);
    double width = 300;
    double height = 250;

    StackPane root = new StackPane();
    Rectangle back = createBackgroundRectangle(width, height);

    root.getChildren().add(back);
    root.getChildren().add(gridPane);

    stage.setScene(new Scene(root, width, height));

    PricesContainer pricesContainer = new PricesContainer();

    PriceUpdater priceUpdater = new PriceUpdater(pricesContainer);

    AnimationTimer animationTimer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        if (pricesContainer.getLockObject().tryLock()) {
          try {
            Label bitcoinLabel = cryptoLabels.get(StockLabels.BITCOIN);
            bitcoinLabel.setText(String.valueOf(pricesContainer.getBitcoin()));

            Label etherLabel = cryptoLabels.get(StockLabels.ETHEREUM);
            etherLabel.setText(String.valueOf(pricesContainer.getEther()));

            Label litecoinLabel = cryptoLabels.get(StockLabels.LITE_COIN);
            litecoinLabel.setText(String.valueOf(pricesContainer.getLiteCoin()));

            Label bitcoinCashLabel = cryptoLabels.get(StockLabels.BITCOIN_CASH);
            bitcoinCashLabel.setText(String.valueOf(pricesContainer.getBitcoinCash()));

            Label rippleLabel = cryptoLabels.get(StockLabels.RIPPLE);
            rippleLabel.setText(String.valueOf(pricesContainer.getRipple()));
          } finally {
            pricesContainer.getLockObject().unlock();
          }
        }
      }
    };

    addWindowResizeListener(stage, back);
    animationTimer.start();
    priceUpdater.start();
    stage.show();


  }

  private void addWindowResizeListener(Stage stage, Rectangle background) {
    ChangeListener<Number> stageSizeListener = ((observable, oldValue, newValue) -> {
      background.setHeight(stage.getHeight());
      background.setWidth(stage.getWidth());
    });
    stage.widthProperty().addListener(stageSizeListener);
    stage.heightProperty().addListener(stageSizeListener);
  }

  private void addLabelsToGrid(Map<StockLabels, Label> cryptoLabels, GridPane gridPane) {
    int row = 0;
    for(Map.Entry<StockLabels, Label> entry: cryptoLabels.entrySet()) {
      String cryptoName = entry.getKey().getId();
      Label nameLabel = new Label(cryptoName);
      nameLabel.setTextFill(Color.BLUEVIOLET);
      nameLabel.setOnMousePressed(mouseEvent -> nameLabel.setTextFill(Color.RED));
      nameLabel.setOnMouseReleased(mouseEvent -> nameLabel.setTextFill(Color.BLUEVIOLET));


      gridPane.add(nameLabel, 0, row);
      gridPane.add(entry.getValue(), 1, row);
      row++;
    }
  }

  private Rectangle createBackgroundRectangle(double width, double height) {

    Rectangle back = new Rectangle(width, height);
    FillTransition fillTransition = new FillTransition(Duration.millis(1000), back, Color.LIGHTGREEN, Color.LIGHTBLUE);
    fillTransition.setCycleCount(Timeline.INDEFINITE);
    fillTransition.setAutoReverse(true);
    fillTransition.play();
    return back;

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

  public static void main(String[] args) {
    launch(args);
  }

}
