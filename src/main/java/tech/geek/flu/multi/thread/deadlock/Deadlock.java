package tech.geek.flu.multi.thread.deadlock;

public class Deadlock {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainA = new Thread(new Train(intersection, "A"));
        Thread trainB = new Thread(new Train(intersection, "B"));

        trainA.start();
        trainB.start();

    }
}
