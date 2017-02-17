package de.butterworks.lionsharecapitalclient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Quotes {

    private final ApiQuoteResponse apiQuotes;
    private final Period period;

    public Period getPeriod() {
        return period;
    }

    Quotes(final ApiQuoteResponse apiQuotes, final Period period) {

        this.apiQuotes = apiQuotes;
        this.period = period;
    }

    public Optional<List<Double>> getQuotesForSymbol(final String symbol) {

        if(symbol == null || symbol.length() != 3) {
            throw new RuntimeException(String.format("Invalid symbol %s", symbol));
        }

        if(apiQuotes.getData().get(symbol.toUpperCase()) == null) {
            return Optional.empty();
        }
        return Optional.of(apiQuotes.getData().get(symbol.toUpperCase()));
    }

    public Map<String, List<Double>> getQuotesForSymbols() {
        return apiQuotes.getData();
    }
}
