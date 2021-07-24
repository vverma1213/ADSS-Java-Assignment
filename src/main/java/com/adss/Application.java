package com.adss;

import com.adss.consumer.ConsumerMessage;
import com.adss.model.Message;
import com.adss.processor.MessageProcessor;
import com.adss.producer.ProducerMessage;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {

    public static void main(String arg[]) throws Exception {
        MessageProcessor messageProcessor = new MessageProcessor();
        messageProcessor.readInputAndSaveInMemoryObject();
        String DEFAULT_MESSAGE = messageProcessor.getMessage();
        Queue<String> messageList = messageProcessor.getAVals();

        BlockingQueue<Message> blockingQueue = new LinkedBlockingQueue<Message>();

        blockingQueue.put(messageProcessor.initializeMessage(DEFAULT_MESSAGE));
        System.out.println("Produced " + blockingQueue);
        ProducerMessage producerThread = new ProducerMessage(blockingQueue, messageList);
        ConsumerMessage consumerThread = new ConsumerMessage(blockingQueue);

        producerThread.start();
        consumerThread.start();

    }
}
