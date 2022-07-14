package de.butting.application;

import de.butting.controller.MainViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Daniel Niebuhr
 *
 */

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			MainViewController mainMenuViewController = new MainViewController();
			Scene mainMenuScene = new Scene(mainMenuViewController.getView(), 1000, 600);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Butting QR Generator");
			primaryStage.getIcons()
					.add(new Image("file:src/main/resources/Butting-Logo.png"));
			primaryStage.setScene(mainMenuScene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		launch(args);
	}
}
