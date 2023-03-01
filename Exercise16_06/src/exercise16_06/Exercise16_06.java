/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package exercise16_06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
Name:Kai Ruge
Date:2/27/2023
*/

public class Exercise16_06 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create a GridPane
        GridPane pane = new GridPane();

        // create a TextField with default text and a Label to display it
        TextField tfTextField = new TextField("JavaFX");
        Label lblTextField = new Label("Text Field:", tfTextField);
        lblTextField.setContentDisplay(ContentDisplay.RIGHT);

        // create an HBox to hold the Label and set its properties
        HBox hBoxTop = new HBox(lblTextField);
        hBoxTop.setPadding(new Insets(2));
        hBoxTop.setAlignment(Pos.CENTER);

        // add the HBox to the GridPane at row 0, column 0
        pane.add(hBoxTop, 0, 0);

        // create a ToggleGroup to hold the RadioButtons
        ToggleGroup group = new ToggleGroup();

        // create a RadioButton with a Label for left alignment
        RadioButton rbLeft = new RadioButton();
        Label lblLeft = new Label("Left", rbLeft);
        rbLeft.setToggleGroup(group);
        rbLeft.setOnAction(e -> tfTextField.setAlignment(Pos.CENTER_LEFT));
        rbLeft.setSelected(true);

        // create a RadioButton with a Label for right alignment
        RadioButton rbRight = new RadioButton();
        Label lblRight = new Label("Right", rbRight);
        rbRight.setOnAction(e -> tfTextField.setAlignment(Pos.CENTER_RIGHT));
        rbRight.setToggleGroup(group);

        // create a RadioButton with a Label for center alignment
        RadioButton rbCenter = new RadioButton();
        Label lblCenter = new Label("Center", rbCenter);
        rbCenter.setOnAction(e -> tfTextField.setAlignment(Pos.CENTER));
        rbCenter.setToggleGroup(group);

        // create a TextField to hold the column size and set its properties
        TextField tfColumnSize = new TextField();
        tfColumnSize.setPrefColumnCount(3);
        tfColumnSize.setText("12");

        // add an event handler to the TextField to update the column size
        tfColumnSize.setOnAction(e
                -> tfTextField.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText())));

        // create a Label for the TextField to display the column size and set its properties
        Label lblColumnSize = new Label("Column Size", tfColumnSize);
        lblColumnSize.setContentDisplay(ContentDisplay.RIGHT);

        // create an HBox to hold the RadioButtons and the TextField for column size and set its properties
        HBox hBox = new HBox(lblLeft, lblCenter, lblRight, lblColumnSize);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(5, 5, 5, 5));

        // add the HBox to the GridPane at row 1, column 0
        pane.add(hBox, 0, 1);

        // set the Scene with the GridPane and display the Stage
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("TextField");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
