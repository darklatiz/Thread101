package tech.geek.flu.multi.thread.atomic;

public class MetricsPrinter extends Thread{
    private Metrics metrics;

    public MetricsPrinter(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                double metricsAvg = metrics.getAverage();
                System.out.println("Current Average is:" + metricsAvg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
