package com.spaceadvisor.utilities;

import java.util.Locale;

public class ParseMoney {

    public static double parseUnitPrice(String text) {
        if (text == null) return 0.0;
        String normalized = text.replace(",", "").replaceAll("[^\\d.]", "");
        if (normalized.isEmpty()) return 0.0;
        return Double.parseDouble(normalized);
    }

    public static String formatUSD(double value) {
        return "$" + String.format("%.2f", value);
    }

}
