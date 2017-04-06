package com.moneygo.hitta.api.objects;

import com.google.gson.JsonObject;

/**
 * Created by ling on 2017-04-06.
 */
public class Coordinate implements HittaObject {

    private final static String KEY_NORTH = "north";
    private final static String KEY_EAST = "east";
    private final static String KEY_SYSTEM = "system";

    private final String north;
    private final String east;
    private final String system;

    public Coordinate(JsonObject json) {
        north = getStringValue(json, KEY_NORTH);
        east = getStringValue(json, KEY_EAST);
        system = getStringValue(json, KEY_SYSTEM);

    }

    public String getNorth() {
        return north;
    }

    public String getEast() {
        return east;
    }

    public String getSystem() {
        return system;
    }
}
