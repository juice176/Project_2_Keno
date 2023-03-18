import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import java.util.ArrayList;


public class JavaFXTemplate extends Application {
	private ArrayList<Integer> selectNumbers = new ArrayList<>();
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
		MenuItem exitconfirm = new MenuItem("Exit Confirm");
		MenuItem ruleConfirm = new MenuItem("Rules Confirm");
		MenuItem winOddsConfirm = new MenuItem("Odds Confirm");

		exit.getItems().add(exitconfirm);
		winOddsMenu.getItems().add(winOddsConfirm);
		rulesMenu.getItems().add(ruleConfirm);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(rulesMenu, winOddsMenu, exit);

		HBox menu = new HBox(20);
		menu.getChildren().add(menuBar);
		exit.setOnAction((ActionEvent event)-> {Platform.exit();});

		Button button1 = new Button("Play");
		button1.setOnAction(e -> window.setScene(scene2));

		Label welcomeText = new Label("Welcome to Keno");
		welcomeText.setAlignment(Pos.BASELINE_RIGHT);
		welcomeText.setStyle("-fx-font: 40px \"Serif\";");

		layout.setStyle("-fx-padding:10px;");
		layout.getChildren().addAll(menu, welcomeText, button1);
		//scene2
		//BorderPane borderPane = new BorderPane();
		//GridPane borderPane = new GridPane();
		VBox borderPane = new VBox(10);
		scene2 = new Scene(borderPane, 800, 640);
		//scene2 = new Scene(borderPane,800,600);
		//borderPane.setStyle("-fx-padding:10px;");
		Menu rulesMenu2 = new Menu("Rules");
		Menu winOddsMenu2 = new Menu("Odds");
		Menu exit2 = new Menu("Exit");

		MenuItem exitconfirm2 = new MenuItem("Exit Confirm");
		MenuItem ruleConfirm2 = new MenuItem("Rules Confirm");
		MenuItem winOddsConfirm2 = new MenuItem("Odds Confirm");

		exit2.getItems().add(exitconfirm2);
		winOddsMenu2.getItems().add(winOddsConfirm2);
		rulesMenu2.getItems().add(ruleConfirm2);

		MenuBar menuBar2 = new MenuBar();
		menuBar2.getMenus().addAll(rulesMenu2, winOddsMenu2, exit2);

		HBox menu2 = new HBox(20);
		menu2.getChildren().add(menuBar2);
//		menu2.setAlignment(Pos.TOP_LEFT);

		// updates:
		// asks user to pick spots
		Label spots = new Label("How many spots?");

//		ComboBox<Integer> spots_txt = new ComboBox<>();
//		spots_txt.getItems().addAll(1, 4, 8, 10);
		//version 2
		Button amount1 = new Button("1");
		Button amount4 = new Button("4");
		Button amount8 = new Button("8");
		Button amount10 = new Button("10");

//		GridPane screen_layout = new GridPane();

		borderPane.setAlignment(Pos.TOP_LEFT);
		GridPane.setHalignment(amount1, HPos.CENTER);
		GridPane.setValignment(amount1, VPos.CENTER);

		amount1.setOnAction(e -> Player.set_Value(1));
		amount4.setOnAction(e -> Player.set_Value(4));
		amount8.setOnAction(e -> Player.set_Value(8));
		amount10.setOnAction(e -> Player.set_Value(10));

		HBox amountBox = new HBox(20, amount1, amount4, amount8,amount10);

		// then asks users to place bet
		Label bets = new Label("How much do you want to bet?");
		Button bet1 = new Button("$1");
		Button bet2 = new Button("$2");
		Button bet3 = new Button("$3");
		Button bet4 = new Button("$4");
		Button bet5 = new Button("$5");
		Button bet10 = new Button("$10");
		Button bet15 = new Button("$15");
		Button bet20 = new Button("$20");

		GridPane.setHalignment(bet1, HPos.CENTER);
		GridPane.setValignment(bet1, VPos.CENTER);

		bet1.setOnAction(e->Player.set_Value(1));
		bet2.setOnAction(e->Player.set_Value(2));
		bet3.setOnAction(e->Player.set_Value(3));
		bet4.setOnAction(e->Player.set_Value(4));
		bet5.setOnAction(e->Player.set_Value(5));
		bet10.setOnAction(e->Player.set_Value(10));
		bet15.setOnAction(e->Player.set_Value(15));
		bet20.setOnAction(e->Player.set_Value(20));
		HBox betBox = new HBox(20, bet1, bet2, bet3,bet4,bet5,bet10,bet15,bet20);






		// then asks users to pick number of games
		Label games = new Label("How many games do you want to play?");
		Button games1 = new Button("1");
		Button games2 = new Button("2");
		Button games3 = new Button("3");
		Button games4 = new Button("4");
		Button games5 = new Button("5");
		Button games10 = new Button("10");
		Button games15 = new Button("15");
		Button games20 = new Button("20");

		GridPane.setHalignment(games1, HPos.CENTER);
		GridPane.setValignment(games1, VPos.CENTER);

		games1.setOnAction(e->Player.set_Value(1));
		games2.setOnAction(e->Player.set_Value(2));
		games3.setOnAction(e->Player.set_Value(3));
		games4.setOnAction(e->Player.set_Value(4));
		games5.setOnAction(e->Player.set_Value(5));
		games10.setOnAction(e->Player.set_Value(10));
		games15.setOnAction(e->Player.set_Value(15));
		games20.setOnAction(e->Player.set_Value(20));
		HBox gamesBox = new HBox(20, games1, games2, games3,games4,games5,games10,games15,games20);

		Button save = new Button("Next");
		save.setOnAction(e -> window.setScene(scene3));
		//layout2.getChildren().addAll(menu2);
		borderPane.getChildren().addAll(menu2,spots,save,amountBox,betBox,gamesBox);
		// need a function to save results


		//save.setOnAction(event -> Player.storecardSelection());

		// next screen displays grid and options
		GridPane grid_screen = new GridPane();
		grid_screen.setDisable(true);
		grid_screen.setAlignment(Pos.CENTER);
		grid_screen.setHgap(10);
		grid_screen.setVgap(10);
		grid_screen.add(spots, 0, 0);
		//grid_screen.add(spots_txt, 1, 0);
		grid_screen.add(bets, 0, 1);
		//grid_screen.add(bets_txt, 1, 1);
		grid_screen.add(games, 0, 2);
		//grid_screen.add(games_txt, 1, 2);
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
			//num_select.setOnAction(event -> select_function(num_select));
			num.add(num_select, (i - 1) % 10, (i - 1) / 10);
		}
		// need function that displays for numbers that are selected
		Button next = new Button("Next");
		//next.setOnAction(event -> display_numbers(primaryStage));
		VBox pickScreen = new VBox(10);
		pickScreen.setAlignment(Pos.CENTER);
		pickScreen.getChildren().addAll(spots, num, next);

		window.setScene(scene1);
		window.setTitle("KENO");
		window.show();
	}
	// things needed still:
	// function for randomizing the numbers
	// adding up total winnings
	// final screen displaying done
	// pause transitions in gridu
	// updates grids based on 4 spots choices
	// update background with cool image
	// start drawing grid button
	// next screen will start drawing then display numbers and the total winnings


}

