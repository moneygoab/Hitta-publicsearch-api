package com.moneygo.hitta.api.objects;

import com.google.gson.JsonObject;

/**
 * Created by ling on 2017-04-05.
 */
public class Location implements HittaObject {
    private final JsonObject jsonObject;

    public Location(JsonObject json) {
        jsonObject = json;
    }

    public JsonObject getRawJsonObject() {
        return jsonObject;
    }
}
