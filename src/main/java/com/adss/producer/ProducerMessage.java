package com.adss.producer;

import com.adss.model.Field;
import com.adss.model.Message;
import com.adss.processor.MessageProcessor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class ProducerMessage extends Thread{

    private BlockingQueue<Message> blockingQueue;
    private LinkedList<String> messageList;
    private Message message;
    MessageProcessor messageProcessor;

    public ProducerMessage(BlockingQueue<Message> sharedQueue, Queue<String> messageList){
        this.blockingQueue = sharedQueue;
        this.messageList = (LinkedList<String>) messageList;
        this.message = new Message();
        this.messageProcessor = new MessageProcessor();
    }

    @Override
    public void run() {
        try {
             for (int value = 1; value < messageList.size(); value++) {
                    message = messageProcessor.initializeMessage(messageList.get(value));
                    blockingQueue.put(message);
                    System.out.println("Produced " + message);
                    Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
