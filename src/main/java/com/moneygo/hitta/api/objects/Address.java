package com.moneygo.hitta.api.objects;

import com.google.gson.JsonObject;
import com.moneygo.hitta.api.enums.AddressType;

/**
 * Created by ling on 2017-04-05.
 */
public class Address implements HittaObject {
    private final static String KEY_TYPE = "type";
    private final static String KEY_USAGE_CODE = "usageCode";
    private final static String KEY_IS_WORKING_ADDRESS = "isWorkingAddress";
    private final static String KEY_CITY = "city";
    private final static String KEY_CITY_PREPOSITION = "cityPreposition";
    private final static String KEY_ZIPCODE = "zipcode";
    private final static String KEY_STREET = "street";
    private final static String KEY_NUMBER = "number";
    private final static String KEY_ENTRANCE = "entrance";
    private final static String KEY_APARTMENT_NO = "apartmentNo";
    private final static String KEY_COORDINATE = "coordinate";

    private final AddressType type;
    private final String usageCode;
    private final String isWorkingAddress;
    private final String city;
    private final String cityPreposition;
    private final String zipcode;
    private final String street;
    private final String number;
    private final String entrance;
    private final String apartmentNo;
    private final Coordinate coordinate;


    public Address(JsonObject json) {

        type = AddressType.getByJsonKey(getStringValue(json, KEY_TYPE));
        usageCode = getStringValue(json, KEY_USAGE_CODE);
        isWorkingAddress = getStringValue(json, KEY_IS_WORKING_ADDRESS);
        city = getStringValue(json, KEY_CITY);
        cityPreposition = getStringValue(json, KEY_CITY_PREPOSITION);
        zipcode = getStringValue(json, KEY_ZIPCODE);
        street = getStringValue(json, KEY_STREET);
        number = getStringValue(json, KEY_NUMBER);
        entrance = getStringValue(json, KEY_ENTRANCE);
        apartmentNo = getStringValue(json, KEY_APARTMENT_NO);
        if (json.has(KEY_COORDINATE)) {
            coordinate = new Coordinate(json.get(KEY_COORDINATE).getAsJsonObject());
        } else {
            coordinate = null;
        }

    }

    public AddressType getType() {
        return type;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public String getIsWorkingAddress() {
        return isWorkingAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCityPreposition() {
        return cityPreposition;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getEntrance() {
        return entrance;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
