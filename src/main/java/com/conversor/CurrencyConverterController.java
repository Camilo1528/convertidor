package com.conversor;

public class CurrencyConverterController {

    private final ApiService apiService;

    public CurrencyConverterController() {
        this.apiService = new ApiService();
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        double rate = apiService.getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}
