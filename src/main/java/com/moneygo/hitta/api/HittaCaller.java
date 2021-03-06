package com.moneygo.hitta.api;

import com.moneygo.hitta.api.enums.HittaCallerVersion;
import com.moneygo.hitta.api.enums.PersonCompanySearch;
import com.moneygo.hitta.api.objects.Result;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by ling on 2017-04-04.
 */


public class HittaCaller {

    private final String callerId;
    private final String key;
    private final HittaCallerVersion version;
    private final Logger logger;


    public HittaCaller(String callerId, String key, HittaCallerVersion version) {
        this.callerId = callerId;
        this.version = version;
        this.key = key;
        this.logger = null;
    }

    public HittaCaller(String callerId, String key, HittaCallerVersion version,Logger logger) {
        this.callerId = callerId;
        this.version = version;
        this.key = key;
        this.logger = logger;
    }


    public Result personCompanySearch(PersonCompanySearch type, String what, String where, String geoSystem) throws IOException {
        return version.personCompanySearch(callerId, key, type, what, where, geoSystem, 1, 1000, HittaCallerVersion.NO_VALUE, HittaCallerVersion.NO_VALUE,logger);
    }

}




