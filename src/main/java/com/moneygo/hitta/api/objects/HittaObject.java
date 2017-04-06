package com.moneygo.hitta.api.objects;

import com.google.gson.JsonObject;

/**
 * Created by ling on 2017-04-05.
 */
public interface HittaObject {

    default String getStringValue(JsonObject json, String key) {

        if (json != null && json.has(key)) {
            return json.get(key).getAsString();
        }
        return "";
    }

}
