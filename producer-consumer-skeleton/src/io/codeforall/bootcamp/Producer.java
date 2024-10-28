package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bqueue.BQueue;
import io.codeforall.bootcamp.bqueue.Pizza;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;
    private int counter;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
        this.counter = 0;
    }

    @Override
    public void run() {
        while (counter < elementNum) {

            try {
                Thread.sleep((long) (Math.random() * 3000));
            } catch (InterruptedException e) {
            }

            queue.offer(new Pizza());
            this.counter++;
        }

        System.out.println(Thread.currentThread().getName() + " is finished producing");
    }

    public int getElementNum() {
        return this.elementNum;
    }

}
