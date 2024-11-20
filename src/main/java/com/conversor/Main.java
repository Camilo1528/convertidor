package com.conversor;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Llama a la interfaz gráfica
        new CurrencyConverterUI().start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
