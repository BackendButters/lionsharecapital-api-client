package de.butterworks.lionsharecapitalclient;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ApiQuoteResponse {

    private final Map<String, List<Double>> data = new HashMap<String, List<Double>>();

    Map<String, List<Double>> getData() {
        return data;
    }
}
