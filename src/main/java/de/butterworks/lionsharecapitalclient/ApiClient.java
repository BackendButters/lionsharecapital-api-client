package de.butterworks.lionsharecapitalclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class ApiClient {

    private static final Gson gson = new GsonBuilder().create();
    private final String apiUrl;

    public String getApiUrl() {
        return apiUrl;
    }

    public ApiClient(final String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public ApiClient() {
        this.apiUrl = "https://api.lionshare.capital/api";
    }

    public Quotes getQuotes(final Period period) {

        final ClientResponse response = Client.create()
                .resource(apiUrl + String.format("/prices?period=", period.toString().toLowerCase()))
                .accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException(String.format("Request failed with HTTP code %s", response.getStatus()));
        }
        return new Quotes(gson.fromJson(response.getEntity(String.class), ApiQuoteResponse.class), period);
    }

    public Capitalizations getCapitalizations() {

        final ClientResponse response = Client.create()
                .resource(apiUrl + "/markets")
                .accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException(String.format("Request failed with HTTP code %s", response.getStatus()));
        }
        return gson.fromJson(response.getEntity(String.class), Capitalizations.class);
    }
}
