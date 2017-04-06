package com.moneygo.hitta.api.objects;

import com.google.gson.JsonObject;

/**
 * Created by ling on 2017-04-05.
 */
public class BoxAddress extends Address {

    private final static String KEY_BOX = "box";

    private final String box;

    public BoxAddress(JsonObject json) {
        super(json);
        box = getStringValue(json, KEY_BOX);
    }

    public String getBox() {
        return box;
    }
}
