package com.test.arif.Enum;

/**
 * Created by arifacar on 1/13/16.
 */
public enum Currency {
    TRY (1),
    EUR (2),
    USD (3);

    private final int currencyCode;

    Currency(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }
}
