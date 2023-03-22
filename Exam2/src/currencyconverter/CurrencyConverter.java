/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package currencyconverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Kai
 */
public class CurrencyConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create UI elements
        Label usdLabel = new Label("US Dollars:");
        TextField usdTextField = new TextField();
        Label cadLabel = new Label("Canadian Dollars:");
        TextField cadTextField = new TextField();
        Button convertButton = new Button("Convert");
        
        // set event handler for convert button
        convertButton.setOnAction(event -> {
            try {
                // get input from text field and convert to double
                double usdAmount = Double.parseDouble(usdTextField.getText());
                
                // convert US dollars to Canadian dollars
                double cadAmount = usdAmount * 0.73;
                
                // display result in Canadian dollars text field
                cadTextField.setText(String.format("%.2f", cadAmount));
            } catch (NumberFormatException e) {
                // display error message if input is not a valid number
                cadTextField.setText("Invalid input");
            }
        });
        
        // create layout and add UI elements to it
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10));
        layout.add(usdLabel, 0, 0);
        layout.add(usdTextField, 1, 0);
        layout.add(cadLabel, 0, 1);
        layout.add(cadTextField, 1, 1);
        layout.add(convertButton, 1, 2);
        
        // create and show scene
        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
