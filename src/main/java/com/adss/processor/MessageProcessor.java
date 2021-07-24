package com.adss.processor;

import com.adss.model.Field;
import com.adss.model.Message;

import java.io.*;
import java.util.*;

public class MessageProcessor {

    private static Message message = new Message();
    private static Field field = new Field();
    private static Queue<String> msgs = new LinkedList<>();

    public void readInputAndSaveInMemoryObject() throws IOException {
        String fileName = "config/input.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String st;
            while ((st = br.readLine()) != null) {
                msgs.add(st);
            }
        }
    }

    public Message initializeMessage(String inputMsg) {
        String[] msg = inputMsg.split(",");
        message.setMessageType(msg[0]);
        message.setUniqueId(msg[1]);
        List<Double> fieldList=new ArrayList<>();
        for(int fieldVal =2;fieldVal<msg.length;fieldVal++){
            fieldList.add(Double.valueOf(msg[fieldVal]));
        }
        field.setField(fieldList);
        message.setFields(field);
        return message;
    }

    public String getMessage(){
        return msgs.peek();
    }

    public Queue<String> getAVals(){
        return msgs;
    }

    public void clearAVals(){
        msgs.removeAll(msgs);
    }

}
