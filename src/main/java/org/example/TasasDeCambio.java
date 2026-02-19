package org.example;

import java.util.Map;

public record TasasDeCambio(String result, String base_code, Map<String, Double> conversion_rates) {
}
