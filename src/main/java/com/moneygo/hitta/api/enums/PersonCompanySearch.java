package com.moneygo.hitta.api.enums;

/**
 * Created by ling on 2017-04-04.
 */
public enum PersonCompanySearch {
    COMBINED("combined"), PERSONS("persons"), COMPANIES("companies");


    private final String urlPath;

    PersonCompanySearch(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getUrlPath() {
        return urlPath;
    }
}
