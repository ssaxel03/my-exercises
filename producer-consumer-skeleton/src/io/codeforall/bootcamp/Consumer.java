package io.codeforall.bootcamp;

import io.codeforall.bootcamp.bqueue.Pizza;
import io.codeforall.bootcamp.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;
    private int counter;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
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

            queue.poll();
            this.counter++;

        }

        System.out.println(Thread.currentThread().getName() + " is finished consuming");

    }

    public int getElementNum() {
        return this.elementNum;
    }

}
