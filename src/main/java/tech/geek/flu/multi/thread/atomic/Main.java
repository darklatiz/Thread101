package tech.geek.flu.multi.thread.atomic;

public class Main {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BusinessLogic businessLogic = new BusinessLogic(metrics);
        BusinessLogic businessLogic1 = new BusinessLogic(metrics);
        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);

        businessLogic.start();
        businessLogic1.start();
        metricsPrinter.start();
    }
}
