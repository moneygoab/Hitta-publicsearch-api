package com.moneygo.hitta.api.objects;

import com.google.gson.JsonObject;

/**
 * Created by ling on 2017-04-05.
 */
public class Phone implements HittaObject {
    private static final String KEY_LABEL = "label";
    private static final String KEY_CALL_TO = "callTo";
    private static final String KEY_DISPLAY_AS = "displayAs";
    private static final String KEY_SHARED_WITH = "sharedWith";

    private final String label;
    private final String callTo;
    private final String display;
    private final String sharedWith;

    public Phone(JsonObject json) {
        label = getStringValue(json, KEY_LABEL);
        callTo = getStringValue(json, KEY_CALL_TO);
        display = getStringValue(json, KEY_DISPLAY_AS);
        sharedWith = getStringValue(json, KEY_SHARED_WITH);
    }

    public String getLabel() {
        return label;
    }

    public String getCallTo() {
        return callTo;
    }

    public String getDisplay() {
        return display;
    }

    public String getSharedWith() {
        return sharedWith;
    }
}
