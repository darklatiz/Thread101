package tech.geek.flu.multi.thread.deadlock;

public class Intersection {

    private Object roadA;
    private Object roadB;

    public Intersection() {
        roadA = new Object();
        roadB = new Object();
    }

    public void takeRoadA() {
        synchronized (roadA) {
            System.out.println("Road A is locked " + Thread.currentThread().getName());
            synchronized (roadB) {
                System.out.println("Train is passing through ROAD A ... Choo chooooooo!!!");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void takeRoadB() {
        synchronized (roadA) {
            System.out.println("Road B is locked " + Thread.currentThread().getName());
            synchronized (roadB) {
                System.out.println("Train is passing through ROAD B ... Choo chooooooo!!!");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
