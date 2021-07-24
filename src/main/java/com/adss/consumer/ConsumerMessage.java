package com.adss.consumer;

import com.adss.model.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerMessage extends Thread{

    private BlockingQueue<Message> blockingQueue;

    public ConsumerMessage(BlockingQueue<Message> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (!blockingQueue.isEmpty()) {
                Message value = blockingQueue.take();

                System.out.println("Consume " + value);

                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
