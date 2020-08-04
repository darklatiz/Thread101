package tech.geek.flu.multi.thread.atomic;

public class Metrics {

    private long counter = 0;
    private volatile double average = 0.0;

    public synchronized void addSample(long sample) {
        double currentSum = average * counter;
        counter++;
        average = (currentSum + sample) / counter;
    }

    public double getAverage() {
        return average;
    }


}
