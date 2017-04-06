package com.moneygo.hitta.api.objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by ling on 2017-04-05.
 */
public class Result {

    private final static String KEY_RESULT = "result";

    private final static String KEY_TOTAL = "total";

    private final static String KEY_COMPANIES = "companies";
    private final static String KEY_PERSONS = "persons";
    private final static String KEY_LOCATIONS = "locations";

    private final static String KEY_COMPANY_ARRAY = "company";
    private final static String KEY_PERSON_ARRAY = "person";
    private final static String KEY_LOCATION_ARRAY = "location";

    private final Location[] locations;
    private final int totalLocations;

    private final Person[] people;
    private final int totalPeople;

    private final Company[] companies;
    private final int totalcompanies;

    private final JsonObject jsonData;

    public Result(JsonObject object) {
        jsonData = object;
        object = object.getAsJsonObject(KEY_RESULT);
        //Generate Company
        JsonObject jsonCompany = object.getAsJsonObject(KEY_COMPANIES);
        totalcompanies = jsonCompany.get(KEY_TOTAL).getAsInt();
        companies = generateCompanylist(jsonCompany);

        //Generate people
        JsonObject jsonPeople = object.getAsJsonObject(KEY_PERSONS);
        totalPeople = jsonPeople.get(KEY_TOTAL).getAsInt();
        people = generatePeopleList(jsonPeople);


        //Generate location
        JsonObject jsonLocation = object.getAsJsonObject(KEY_LOCATIONS);
        totalLocations = jsonLocation.get(KEY_TOTAL).getAsInt();
        locations = generateLocationList(jsonLocation);

    }

    private Company[] generateCompanylist(JsonObject company) {
        if (company.has(KEY_COMPANY_ARRAY)) {
            ArrayList<Company> companyList = new ArrayList<>();
            JsonArray jsonCompanies = company.getAsJsonArray(KEY_COMPANY_ARRAY);

            jsonCompanies.forEach((jsonElement ->
                    companyList.add(new Company(jsonElement.getAsJsonObject()))
            ));

            return companyList.toArray(new Company[companyList.size()]);
        }

        return new Company[0];

    }

    private Person[] generatePeopleList(JsonObject person) {
        if (person.has(KEY_PERSON_ARRAY)) {

            ArrayList<Person> peopleList = new ArrayList<>();
            JsonArray jsonCompanies = person.getAsJsonArray(KEY_PERSON_ARRAY);

            jsonCompanies.forEach((jsonElement ->
                    peopleList.add(new Person(jsonElement.getAsJsonObject()))
            ));

            return peopleList.toArray(new Person[peopleList.size()]);
        }
        return new Person[0];
    }

    private Location[] generateLocationList(JsonObject location) {
        if (location.has(KEY_LOCATION_ARRAY)) {
            ArrayList<Location> peopleList = new ArrayList<>();
            JsonArray jsonCompanies = location.getAsJsonArray(KEY_LOCATION_ARRAY);

            jsonCompanies.forEach((jsonElement ->
                    peopleList.add(new Location(jsonElement.getAsJsonObject()))
            ));

            return peopleList.toArray(new Location[peopleList.size()]);
        }
        return new Location[0];
    }

    public JsonObject getJsonRawData() {
        return jsonData;
    }

    public Location[] getLocations() {
        return locations;
    }

    public Person[] getPeople() {
        return people;
    }

    public Company[] getCompanies() {
        return companies;
    }

    public int getTotalLocations() {
        return totalLocations;
    }

    public int getTotalPeople() {
        return totalPeople;
    }

    public int getTotalcompanies() {
        return totalcompanies;
    }
}
