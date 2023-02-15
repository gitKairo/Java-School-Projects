/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hangmandrawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HangmanDrawing extends Application {

    private final int width = 400;
    private final int height = 400;

    @Override
    public void start(Stage stage) {

        // Create a canvas to draw on
        Canvas canvas = new Canvas(width, height);

        // Get the graphics context for the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Draw the scaffold
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeLine(50, height - 50, width - 50, height - 50);
        gc.strokeLine(100, 50, 100, height - 50);
        gc.strokeLine(100, 50, width / 2, 50);

        // Draw the hangman
        gc.setFill(Color.BLACK);
        gc.setLineWidth(3);
        gc.strokeOval(width / 2 - 25, 75, 50, 50); // head
        gc.strokeLine(width / 2, 125, width / 2, 225); // body
        gc.strokeLine(width / 2, 150, width / 2 - 50, 175); // left arm
        gc.strokeLine(width / 2, 150, width / 2 + 50, 175); // right arm
        gc.strokeLine(width / 2, 225, width / 2 - 25, 275); // left leg
        gc.strokeLine(width / 2, 225, width / 2 + 25, 275); // right leg

        // Create a pane to hold the canvas
        Pane pane = new Pane(canvas);

        // Create a scene with the pane as the root node
        Scene scene = new Scene(pane);

        // Set the stage title and scene, and show the stage
        stage.setTitle("Hangman Drawing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
