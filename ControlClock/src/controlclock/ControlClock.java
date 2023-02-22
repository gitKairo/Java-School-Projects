/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controlclock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class ControlClock extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create the clock pane
		ClockPane clock = new ClockPane();

		// Create a hBox and set it porperties
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);

		// Create two buttons
		Button btnStop = new Button("Stop");
		Button btnStart = new Button("Start");

		// Create and register handler
		btnStop.setOnAction(e -> clock.pause());
		btnStart.setOnAction(e -> clock.play());

		// Place buttons in hBox
		hBox.getChildren().addAll(btnStop, btnStart);

		// Create a border pane and place the nodes in to it
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(clock);
		borderPane.setBottom(hBox);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 270, 290);
		primaryStage.setTitle("Clock"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
        
        public static void main(String[] args) {
		launch(args);
	}
}