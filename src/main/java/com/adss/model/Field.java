package com.adss.model;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private List<Double> field;

    public Field(){
        field = new ArrayList<Double>();
    }

    public List<Double> getField() {
        return field;
    }

    public void setField(List<Double> field) {
        this.field = field;
    }

}
