/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package chapter14gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Kai
 */
public class Chapter14GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create image
        Image image = new Image("C:\\Users\\Kai\\Documents\\NetBeansProjects\\CIS171-KaiRuge\\Chapter14GUI\\images\\house.jfif");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        // Create text heading
        Text heading = new Text("123 Main St.");
        heading.setStyle("-fx-font-size: 36;");
        heading.setTextAlignment(TextAlignment.CENTER);

        // Create button
        Button button = new Button("Request More Information");
        button.setPrefWidth(200);

        // Create textbox
        TextArea textArea = new TextArea();
        textArea.setPrefHeight(150);
        textArea.setPrefWidth(300);
        textArea.setWrapText(true);
        textArea.setText(
                "This beautiful 5 bedroom, 3 bath home is located in a quiet neighborhood. " +
                "It features an open floor plan, updated kitchen, and a large backyard. " +
                "Don't miss out on this opportunity to make this house your new home.");

        // Create layout and add nodes
        VBox layout = new VBox();
        layout.setSpacing(20);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(heading, imageView, textArea, button);

        // Set scene and show stage
        Scene scene = new Scene(layout, 350, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
