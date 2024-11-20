package com.conversor;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterUI {

    private final CurrencyConverterController controller;
    private final Map<String, String> currencyMap;

    public CurrencyConverterUI() {
        this.controller = new CurrencyConverterController();
        this.currencyMap = initializeCurrencyMap();
    }

    private Map<String, String> initializeCurrencyMap() {
        Map<String, String> map = new HashMap<>();
        map.put("USD", "Dólar estadounidense");
        map.put("ARS", "Peso argentino");
        map.put("BOB", "Boliviano");
        map.put("BRL", "Real brasileño");
        map.put("CLP", "Peso chileno");
        map.put("COP", "Peso colombiano");
        return map;
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conversor de Monedas");

        Label fromCurrencyLabel = new Label("Moneda de Origen:");
        ComboBox<String> fromCurrencyBox = new ComboBox<>();
        ComboBox<String> toCurrencyBox = new ComboBox<>();

        currencyMap.forEach((code, name) -> {
            fromCurrencyBox.getItems().add(code + " - " + name);
            toCurrencyBox.getItems().add(code + " - " + name);
        });

        fromCurrencyBox.setValue("USD - Dólar estadounidense");
        toCurrencyBox.setValue("ARS - Peso argentino");

        Label amountLabel = new Label("Cantidad:");
        TextField amountField = new TextField();

        Button convertButton = new Button("Convertir");
        Label resultLabel = new Label();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(fromCurrencyLabel, 0, 0);
        grid.add(fromCurrencyBox, 1, 0);
        grid.add(new Label("Moneda de Destino:"), 0, 1);
        grid.add(toCurrencyBox, 1, 1);
        grid.add(amountLabel, 0, 2);
        grid.add(amountField, 1, 2);
        grid.add(convertButton, 1, 3);
        grid.add(resultLabel, 1, 4);

        convertButton.setOnAction(e -> {
            try {
                String fromCurrency = getCurrencyCode(fromCurrencyBox.getValue());
                String toCurrency = getCurrencyCode(toCurrencyBox.getValue());
                double amount = Double.parseDouble(amountField.getText());

                double result = controller.convertCurrency(fromCurrency, toCurrency, amount);
                resultLabel.setText(String.format("%.2f %s = %.2f %s",
                        amount,
                        currencyMap.get(fromCurrency),
                        result,
                        currencyMap.get(toCurrency)
                ));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Por favor, ingrese un número válido.");
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        });

        Scene scene = new Scene(grid, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getCurrencyCode(String selectedValue) {
        return selectedValue.split(" - ")[0];
    }
}
