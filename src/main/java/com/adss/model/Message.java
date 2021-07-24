package com.adss.model;

import java.util.List;

public class Message {
    private String messageType;
    private String uniqueId;
    private Field fields;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Field getFields() {
        return fields;
    }

    public void setFields(Field fields) {
        this.fields = fields;
    }

    public String toString(){
        return "uniqueId:"+uniqueId +" "+"fields:"+fields.getField();
    }
}
