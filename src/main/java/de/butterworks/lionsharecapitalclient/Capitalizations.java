package de.butterworks.lionsharecapitalclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Capitalizations {

    private final Map<String, Long> data = new HashMap<String, Long>();

    private Capitalizations() {
    }

    public Optional<Long> getCapitalizationForSymbol(final String symbol) {

        if(symbol == null || symbol.length() != 3) {
            throw new RuntimeException(String.format("Invalid symbol %s", symbol));
        }

        if(data.get(symbol.toUpperCase()) == null) {
            return Optional.empty();
        }
        return Optional.of(data.get(symbol.toUpperCase()));
    }

    public Map<String, Long> getCapitalizationsForSymbols() {
        return data;
    }
}
