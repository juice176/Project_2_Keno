import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {
	private List<values> selectNumbers = new ArrayList<>();

	Stage window;
	Scene scene1, scene2, scene3, scene4, scene5, currentScene;
	//public static TextArea t2;
	public static Stage stage;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Win or Go Home");

		window = primaryStage;
		//scene1
		VBox layout = new VBox(10);
		scene1 = new Scene(layout, 800, 640);

		//Menu
		Menu rulesMenu = new Menu("Rules");
		Menu winOddsMenu = new Menu("Odds");
		Menu exit = new Menu("Exit");

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(rulesMenu, winOddsMenu, exit);

		HBox menu = new HBox(20);
		menu.getChildren().add(menuBar);


		Button button1 = new Button("Play");
		button1.setOnAction(e -> window.setScene(scene2));

		Label welcomeText = new Label("Welcome to Keno");
		welcomeText.setAlignment(Pos.BASELINE_RIGHT);
		welcomeText.setStyle("-fx-font: 40px \"Serif\";");

		layout.setStyle("-fx-padding:10px;");
		layout.getChildren().addAll(menu, welcomeText, button1);
		//scene2
		BorderPane borderPane = new BorderPane();

		window.setScene(scene1);
		window.setTitle("KENO");
		window.show();
		exit.setOnAction((ActionEvent event)-> {Platform.exit();});
		button1.setOnAction((ActionEvent event)->{
			Scene scene2 = new Scene(borderPane, 700, 700);
			window.setScene(scene2);
			borderPane.getChildren().addAll(menu);
		});

		// updates:
		// asks user to pick spots
		Label spots = new Label("How many spots?");
		ComboBox<values> spots_txt = new ComboBox<>();
		spots_txt.getItems().addAll(1, 4, 8, 10);

		// then asks users to place bet
		Label bets = new Label("How much do you want to bet?");
		ComboBox<values> bets_txt = new ComboBox<>();
		bets_txt.getItems().addAll("$1", "$2", "$3", "$4", "$5", "$10", "$15", "$20);

		// then asks users to pick number of games
		Label games = new Label("How many games do you want to play?");
		ComboBox<values> games_txt = new ComboBox<>();
		games_txt.getItems().addAll(1, 2, 3, 4, 5, 10, 15, 20);

		Button save = new Button("Next");
		// need a function to save results
		save.setOnAction(event -> results()));

		// next screen displays grid and options
		GridPane grid_screen = new GridPane();
		grid_screen.setAlignment(Pos.CENTER);
		grid_screen.setHgap(10);
		grid_screen.setVgap(10);
		grid_screen.add(spots, 0, 0);
		grid_screen.add(spots_txt, 1, 0);
		grid_screen.add(bets, 0, 1);
		grid_screen.add(bets_txt, 1, 1);
		grid_screen.add(games, 0, 2);
		grid_screen.add(games_txt, 1, 2);
		grid_screen.add(save, 0, 3);

		// user pick numbers from grid
		Label pick_num = new Label("Pick spots:");

		GridPane num = new GridPane();
		num.setAlignment(Pos.CENTER);
		num.setHgap(5);
		num.setVgap(5);
		// need function that checks for numbers that ar ebeing selected
		for (int i = 1; i <= 80; i++) {
			Button num_select = new Button(String.valueOf(i));
			num_select.setPrefSize(50, 50);
			num_select.setOnAction(event -> select_function(num_select));
			num.add(num_select, (i - 1) % 10, (i - 1) / 10);
		}
		// need function that displays for numbers that are selected
		Button next = new Button("Next");
		next.setOnAction(event -> display_numbers(primaryStage));

		VBox pickScreen = new VBox(10);
		pickScreen.setAlignment(Pos.CENTER);
		pickScreen.getChildren().addAll(spots, num, next);

	}
	// things needed still:
	// function for randomizing the numbers
	// adding up total winnings
	// final screen displaying done
	// pause transitions in grid
	// updates grids based on 4 spots choices
	// update background with cool image
	// start drawing grid button
	// next screen will start drawing then display numbers and the total winnings


}
