package com.example.numberguessinggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameApp extends Application {
	public static Stage primaryStage;
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;

		Parent root = FXMLLoader.load(Objects.requireNonNull(GameApp.class.getResource("game.fxml")));
		primaryStage.setTitle("Number Guessing Game");
		primaryStage.setMaximized(true);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
