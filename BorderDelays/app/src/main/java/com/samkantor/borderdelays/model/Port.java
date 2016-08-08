package com.samkantor.borderdelays.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SAM on 8/7/2016.
 */
public class Port extends RealmObject implements Serializable {

    @PrimaryKey
    private String code;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
