package com.moneygo.hitta.api.enums;

/**
 * Created by ling on 2017-04-05.
 */
public enum AddressType {
    BOX_ADDRESS("BoxAddress"), VISITING_ADDRESS("visitingAddress"), DELIVERY_ADDRESS("deliveryAddress");

    private final String jsonKey;

    AddressType(String jsonKey) {
        this.jsonKey = jsonKey;
    }

    public static AddressType getByJsonKey(String key) {

        for (AddressType type : values()) {
            if (type.getJsonKey().equalsIgnoreCase(key)) {
                return type;
            }
        }

        throw new RuntimeException("No matching key - " + key);
    }

    public String getJsonKey() {
        return jsonKey;
    }
}
