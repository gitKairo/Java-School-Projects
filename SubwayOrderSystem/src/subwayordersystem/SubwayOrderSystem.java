/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package subwayordersystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Kai
 */
public class SubwayOrderSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Define labels
        Label sandwichSizeLabel = new Label("Size of Sandwich:");
        Label breadTypeLabel = new Label("Type of Bread:");
        Label meatTypeLabel = new Label("Type of Meat:");
        Label cheeseTypeLabel = new Label("Type of Cheese:");
        Label veggiesLabel = new Label("Select up to three veggies:");
        Label sauceLabel = new Label("Select Sauce(s):");
        Label saltPepperLabel = new Label("Add Salt & Pepper?");

        // Define selection controls
        ComboBox<String> sandwichSizeBox = new ComboBox<>();
        sandwichSizeBox.getItems().addAll("Small", "Medium", "Large");

        ComboBox<String> breadTypeBox = new ComboBox<>();
        breadTypeBox.getItems().addAll("White", "Whole Wheat", "Italian", "Honey Oat");

        ComboBox<String> meatTypeBox = new ComboBox<>();
        meatTypeBox.getItems().addAll("Chicken", "Beef", "Turkey", "Ham");

        ComboBox<String> cheeseTypeBox = new ComboBox<>();
        cheeseTypeBox.getItems().addAll("American", "Cheddar", "Swiss", "Pepper Jack");

        CheckBox lettuceCheckBox = new CheckBox("Lettuce");
        CheckBox tomatoCheckBox = new CheckBox("Tomato");
        CheckBox onionCheckBox = new CheckBox("Onion");
        CheckBox bellPeppersCheckBox = new CheckBox("Bell Peppers");
        CheckBox cucumberCheckBox = new CheckBox("Cucumber");

        ListView<String> sauceListView = new ListView<>();
        sauceListView.getItems().addAll("Mayonnaise", "Mustard", "BBQ", "Ranch");

        RadioButton yesRadioButton = new RadioButton("Yes");
        RadioButton noRadioButton = new RadioButton("No");
        ToggleGroup group = new ToggleGroup();
        yesRadioButton.setToggleGroup(group);
        noRadioButton.setToggleGroup(group);
        noRadioButton.setSelected(true);

        // Define a button for the order summary
        Button orderButton = new Button("Order");

        // Define the layout and add controls
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(sandwichSizeLabel, sandwichSizeBox, breadTypeLabel, breadTypeBox,
                meatTypeLabel, meatTypeBox, cheeseTypeLabel, cheeseTypeBox, veggiesLabel, lettuceCheckBox,
                tomatoCheckBox, onionCheckBox, bellPeppersCheckBox, cucumberCheckBox, sauceLabel, sauceListView,
                saltPepperLabel, yesRadioButton, noRadioButton, orderButton);

        // Event handling for the order button
        orderButton.setOnAction(e -> {
            String orderSummary = "Order Summary:\n\n"
                    + "Size of Sandwich: " + sandwichSizeBox.getValue() + "\n"
                    + "Type of Bread: " + breadTypeBox.getValue() + "\n"
                    + "Type of Meat: " + meatTypeBox.getValue() + "\n"
                    + "Type of Cheese: " + cheeseTypeBox.getValue() + "\n"
                    + "Veggies: " + (lettuceCheckBox.isSelected() ? "Lettuce " : "")
                    + (tomatoCheckBox.isSelected() ? "Tomato " : "")
                    + (onionCheckBox.isSelected() ? "Onion " : "")
                    + (bellPeppersCheckBox.isSelected() ? "Bell Peppers " : "")
                    + (cucumberCheckBox.isSelected() ? "Cucumber" : "") + "\n"
                    + "Sauce(s): " + sauceListView.getSelectionModel().getSelectedItems().toString() + "\n"
                    + "Salt & Pepper: " + (yesRadioButton.isSelected() ? "Yes" : "No");

            Alert orderSummaryAlert = new Alert(Alert.AlertType.INFORMATION);
            orderSummaryAlert.setTitle("Order Summary");
            orderSummaryAlert.setHeaderText(null);
            orderSummaryAlert.setContentText(orderSummary);
            orderSummaryAlert.showAndWait();
        });

        // Define the scene and add the layout
        Scene scene = new Scene(layout, 400, 600);

        // Set the stage and show
        primaryStage.setTitle("Subway Order System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
