package com.spaceadvisor.utilities;

public class ParseMoney {

    public static double parseMoney(String text) {
        if (text == null) return 0.0;
        String normalized = text.replace(",", "").replaceAll("[^\\d.]", "");
        if (normalized.isEmpty()) return 0.0;
        return Double.parseDouble(normalized);
    }

}
