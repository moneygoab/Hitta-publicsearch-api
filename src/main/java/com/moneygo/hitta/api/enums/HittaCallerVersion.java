package com.moneygo.hitta.api.enums;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moneygo.hitta.api.objects.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.Instant;

/**
 * Created by ling on 2017-04-04.
 */
public enum HittaCallerVersion {

    V1("https://api.hitta.se/publicsearch/v1/");

    public final static int NO_VALUE = -1;
    private final static String encoding = "UTF-8";
    private final String url;

    HittaCallerVersion(String url) {
        this.url = url;
    }

    public Result personCompanySearch(String callerId, String key, PersonCompanySearch type, String what, String where, String geoSystem, int pageNumber, int pageSize, int rangeFrom, int rangeTo) throws IOException {

        switch (this) {
            case V1:
                StringBuilder parameters = new StringBuilder(type.getUrlPath() + "?");

                if (!what.isEmpty()) {
                    parameters.append("what=" + URLEncoder.encode(what, encoding));
                } else {
                    throw new RuntimeException("What parameter is required for call!");
                }

                if (!where.isEmpty()) {
                    parameters.append("&where=" + URLEncoder.encode(where, encoding));
                }

                if (pageNumber != NO_VALUE) {
                    parameters.append("&page.number=" + pageNumber);
                }

                if (pageSize != NO_VALUE) {
                    parameters.append("&page.size=" + pageSize);
                }

                if (rangeFrom != NO_VALUE) {
                    parameters.append("&range.from=" + rangeFrom);
                }

                if (rangeTo != NO_VALUE) {
                    parameters.append("&range.to=" + rangeTo);
                }

                if (!geoSystem.isEmpty()) {
                    parameters.append("&geo.system=" + geoSystem);
                }

                return authenticatedGetCallV1(callerId, key, parameters.toString());

            default:
                throw new RuntimeException("Not implemented");
        }
    }


    private Result authenticatedGetCallV1(String callerId, String key, String parameters) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url + parameters);

        String randomString = RandomStringUtils.randomAscii(16);
        String timeStamp = Long.toString(Instant.now().getEpochSecond());

        request.addHeader("X-Hitta-CallerId", callerId);
        request.addHeader("X-Hitta-Time", timeStamp);
        request.addHeader("X-Hitta-Random", randomString);
        request.addHeader("X-Hitta-Hash", DigestUtils.sha1Hex(callerId + timeStamp + key + randomString));
        HttpResponse response = client.execute(request);


        String jsonString = IOUtils.toString(response.getEntity().getContent(), encoding);
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();

        return new Result(json);

    }

}
