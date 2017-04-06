package com.moneygo.hitta.api.objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.moneygo.hitta.api.enums.AddressType;

import java.util.ArrayList;

/**
 * Created by ling on 2017-04-05.
 */
public class Company implements HittaObject {

    private final static String KEY_ID = "id";
    private final static String KEY_DISPLAY_NAME = "displayName";
    private final static String KEY_ADDRESS = "Address";
    private final static String KEY_PHONE = "phone";
    private final static String KEY_TYPE = "type";

    private final String id;

    private final String displayName;

    private final Phone[] phones;

    private final Address[] addresses;
    private final BoxAddress[] boxAddresses;

    public Company(JsonObject json) {

        id = getStringValue(json, KEY_ID);
        displayName = getStringValue(json, KEY_DISPLAY_NAME);


        //Phone
        if (json.has(KEY_PHONE)) {
            JsonArray phoneJson = json.getAsJsonArray(KEY_PHONE);
            ArrayList<Phone> phoneList = new ArrayList<>();
            phoneJson.forEach(jsonElement ->
                    phoneList.add(new Phone(jsonElement.getAsJsonObject()))
            );

            phones = phoneList.toArray(new Phone[phoneList.size()]);
        } else {
            phones = new Phone[0];
        }


        //Address
        if (json.has(KEY_ADDRESS)) {
            ArrayList<Address> addressList = new ArrayList<>();
            ArrayList<BoxAddress> boxAddressList = new ArrayList<>();
            JsonArray addressJson = json.getAsJsonArray(KEY_ADDRESS);
            addressJson.forEach(jsonElement -> {
                AddressType type = AddressType.getByJsonKey(jsonElement.getAsJsonObject().get(KEY_TYPE).getAsString());

                switch (type) {

                    case BOX_ADDRESS:
                        boxAddressList.add(new BoxAddress(jsonElement.getAsJsonObject()));
                        break;

                    case DELIVERY_ADDRESS:
                    case VISITING_ADDRESS:
                        addressList.add(new Address(jsonElement.getAsJsonObject()));
                        break;

                }

            });

            boxAddresses = boxAddressList.toArray(new BoxAddress[boxAddressList.size()]);
            addresses = addressList.toArray(new Address[addressList.size()]);
        } else {
            boxAddresses = new BoxAddress[0];
            addresses = new Address[0];
        }

    }


    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Phone[] getPhones() {
        return phones;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public BoxAddress[] getBoxAddresses() {
        return boxAddresses;
    }
}
