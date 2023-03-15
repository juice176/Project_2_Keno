import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {
	Stage window;
	Scene scene1,scene2,scene3,currentScene;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Keno");

		window = primaryStage;
		//scene1
		VBox layout = new VBox(10);
		scene1 = new Scene(layout,800,640);

		//Menu
		Menu rulesMenu = new Menu("Rules");
		Menu winOddsMenu = new Menu("Odds");
		Menu exit = new Menu("Exit");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(rulesMenu,winOddsMenu,exit);

		HBox menu = new HBox(20);
		menu.getChildren().add(menuBar);


		Button button1 = new Button("Play");
		button1.setOnAction(e -> window.setScene(scene2));

		Label welcomeText = new Label("Welcome to Keno");
		welcomeText.setAlignment(Pos.BASELINE_RIGHT);
		welcomeText.setStyle("-fx-font: 40px \"Serif\";");

		layout.setStyle("-fx-padding:10px;");
		layout.getChildren().addAll(menu, welcomeText, button1);


		window.setScene(scene1);
		window.setTitle("KENO");
		window.show();



		
				
		
	}

}
