import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.event.EventHandler;
import java.util.ArrayList;


public class JavaFXTemplate extends Application {
	private static ArrayList<ToggleButton> selectNumbers = new ArrayList<ToggleButton>();
	private final int TOTAL_DRAWINGS = 20;
	private int i = 0,j = 0, k = 0;
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
		DropShadow shadow = new DropShadow();
		window = primaryStage;
		//scene1
		VBox layout = new VBox(10);
		Scene scene1 = new Scene(layout, 800, 640);
		BackgroundFill background_fill = new BackgroundFill(Color.DARKSLATEBLUE,
				CornerRadii.EMPTY, Insets.EMPTY);

		// create Background
		Background background = new Background(background_fill);

		// set background


		//Menu
		Menu exit = new Menu("Exit");
		MenuItem exitconfirm = new MenuItem("Exit Confirm");

		exit.getItems().add(exitconfirm);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(exit);

		HBox menu = new HBox(20);
		menu.getChildren().add(menuBar);
		exit.setOnAction((ActionEvent event)-> {Platform.exit();});

		Button button1 = new Button("Play");
		button1.setOnAction(e -> window.setScene(scene2));

		Label welcomeText = new Label("Welcome to Keno");
		welcomeText.setAlignment(Pos.BASELINE_RIGHT);
		welcomeText.setStyle("-fx-text-fill:lightblue;-fx-font: 40px \"Serif\";");

		Text Odds = new Text();
		Odds.setText("Keno Odds of Winning\n" +
				"\n" +
				"Game Type            Odds\n" +
				"10 Spot Game        1 in 9.05\n" +
				"8 Spot Game          1 in 9.77\n" +
				"4 Spot Game          1 in 3.86\n" +
				"1 Spot Game          1 in 4.00\n" +
				"\n" +
				"Approximate overall odds to win a prize range from 1 in 3.86 to 9.77.\n" +
				"Approximate odds to win the top prize on the 10 Spot game are 1 in 8.91 million.");
		Odds.setFont(Font.font("Verdana", 15));
		Odds.setFill(Color.LIGHTBLUE);
		Text rules = new Text();
		rules.setText("\n" +
				"1. Select how many numbers (spots) you want to play and your numbers\n" +
				"\n" +
				"Select from one to ten numbers (spots) to play, and then select your numbers from 1-80 that correspond with how many numbers (spots) you want to \nplay. You can select the numbers manually or choose random for the Lottery computer to randomly select your numbers. \n" +
				"\n" +
				"2. Select wager amount\n" +
				"\n" +
				"Select how much you want to wager on each drawing from $1 to $20.\n" +
				"\n" +
				"3. Select number of drawings\n" +
				"\n" +
				"To play the same numbers for multiple drawings, mark the number of drawings you want. \nYou can select up to 20 consecutive drawings with the same numbers.");
		rules.setFont(Font.font("Verdana", 10));
		rules.setFill(Color.LIGHTBLUE);


		layout.setStyle("-fx-padding:10px;");
		layout.setBackground(background);
		layout.getChildren().addAll(menu, welcomeText,Odds,rules, button1);
		//scene2
		VBox borderPane = new VBox(10);
		scene2 = new Scene(borderPane, 800, 640);
		BackgroundFill background_fill2 = new BackgroundFill(Color.LIGHTPINK,
				CornerRadii.EMPTY, Insets.EMPTY);

		// create Background
		Background background2 = new Background(background_fill2);

		Menu rulesMenu2 = new Menu("Rules");
		Menu winOddsMenu2 = new Menu("Odds");
		Menu exit2 = new Menu("Exit");
		Menu newlook = new Menu("NewLook");

		MenuItem exitconfirm2 = new MenuItem("Exit Confirm");
		MenuItem ruleConfirm2 = new MenuItem("Rules Confirm");
		MenuItem winOddsConfirm2 = new MenuItem("Odds Confirm");
		MenuItem dark = new MenuItem("Dark Mode");
		MenuItem light = new MenuItem("Light Mode");


		exit2.getItems().add(exitconfirm2);
		newlook.getItems().addAll(dark,light);
		winOddsMenu2.getItems().add(winOddsConfirm2);
		rulesMenu2.getItems().add(ruleConfirm2);

		exit2.setOnAction(e -> window.close());

		rulesMenu2.setOnAction((ActionEvent)->{
			currentScene = scene2;
			window.setScene(scene1);
		});
		winOddsMenu2.setOnAction((ActionEvent)->{
			currentScene = scene2;
			window.setScene(scene1);
		});
		MenuBar menuBar2 = new MenuBar();
		menuBar2.getMenus().addAll(rulesMenu2, winOddsMenu2,newlook, exit2);
		dark.setOnAction((ActionEvent)->{
			borderPane.setStyle("-fx-padding:5; -fx-background-color:Gray");
			menuBar2.setStyle("-fx-background-color: DarkGrey");
		});
		HBox menu2 = new HBox(20);
		menu2.getChildren().add(menuBar2);


		// updates:
		// asks user to pick spots
		//version 2
		Button amount1 = new Button("1");
		Button amount4 = new Button("4");
		Button amount8 = new Button("8");
		Button amount10 = new Button("10");

//		GridPane screen_layout = new GridPane();

		borderPane.setAlignment(Pos.TOP_LEFT);

		amount1.setOnAction(e -> Player.set_Value(1));
		amount4.setOnAction(e -> Player.set_Value(4));
		amount8.setOnAction(e -> Player.set_Value(8));
		amount10.setOnAction(e -> Player.set_Value(10));

		HBox amountBox = new HBox(20,amount1, amount4, amount8,amount10);
		Label spots = new Label("How many spots?");
		spots.setFont(Font.font("Verdana", 10));
		spots.setAlignment(Pos.BASELINE_RIGHT);
		spots.setStyle("-fx-text-fill:lightblue;-fx-font: 40px \"Serif\";");
		// then asks users to place bet
		Label bets = new Label("How much do you want to bet?");
		bets.setFont(Font.font("Verdana", 10));
		bets.setAlignment(Pos.BASELINE_RIGHT);
		bets.setStyle("-fx-text-fill:lightblue;-fx-font: 40px \"Serif\";");
		Button bet1 = new Button("$1");
		Button bet2 = new Button("$2");
		Button bet3 = new Button("$3");
		Button bet4 = new Button("$4");
		Button bet5 = new Button("$5");
		Button bet10 = new Button("$10");
		Button bet15 = new Button("$15");
		Button bet20 = new Button("$20");


		bet1.setOnAction(e->Player.set_Bet(1));
		bet2.setOnAction(e->Player.set_Bet(2));
		bet3.setOnAction(e->Player.set_Bet(3));
		bet4.setOnAction(e->Player.set_Bet(4));
		bet5.setOnAction(e->Player.set_Bet(5));
		bet10.setOnAction(e->Player.set_Bet(10));
		bet15.setOnAction(e->Player.set_Bet(15));
		bet20.setOnAction(e->Player.set_Bet(20));
		HBox betBox = new HBox(20, bet1, bet2, bet3,bet4,bet5,bet10,bet15,bet20);






		// then asks users to pick number of games
		Label games = new Label("How many games do you want to play?");
		games.setFont(Font.font("Verdana", 10));
		games.setAlignment(Pos.BASELINE_RIGHT);
		games.setStyle("-fx-text-fill:lightblue;-fx-font: 40px \"Serif\";");
		Button games1 = new Button("1");
		Button games2 = new Button("2");
		Button games3 = new Button("3");
		Button games4 = new Button("4");
		Button games5 = new Button("5");
		Button games10 = new Button("10");
		Button games15 = new Button("15");
		Button games20 = new Button("20");


		games1.setOnAction(e->Player.set_Draws(1));
		games2.setOnAction(e->Player.set_Draws(2));
		games3.setOnAction(e->Player.set_Draws(3));
		games4.setOnAction(e->Player.set_Draws(4));
		games5.setOnAction(e->Player.set_Draws(5));
		games10.setOnAction(e->Player.set_Draws(10));
		games15.setOnAction(e->Player.set_Draws(15));
		games20.setOnAction(e->Player.set_Draws(20));
		HBox gamesBox = new HBox(20, games1, games2, games3,games4,games5,games10,games15,games20);

		Button button = new Button("NEXT");
		button.setOnAction(e -> window.setScene(scene3));
		HBox button2 = new HBox(20,button);
		button.setDisable(true);
		bet1.setDisable(true);
		bet2.setDisable(true);
		bet3.setDisable(true);
		bet4.setDisable(true);
		bet5.setDisable(true);
		bet10.setDisable(true);
		bet15.setDisable(true);
		bet20.setDisable(true);
		games1.setDisable(true);
		games2.setDisable(true);
		games3.setDisable(true);
		games4.setDisable(true);
		games5.setDisable(true);
		games10.setDisable(true);
		games15.setDisable(true);
		games20.setDisable(true);

		amount1.setOnAction((ActionEvent) -> {
			amount1.setEffect(shadow);
			bet1.setDisable(false);
			bet2.setDisable(false);
			bet3.setDisable(false);
			bet4.setDisable(false);
			bet5.setDisable(false);
			bet10.setDisable(false);
			bet15.setDisable(false);
			bet20.setDisable(false);

		});
		amount4.setOnAction((ActionEvent) -> {
			amount4.setEffect(shadow);
			bet1.setDisable(false);
			bet2.setDisable(false);
			bet3.setDisable(false);
			bet4.setDisable(false);
			bet5.setDisable(false);
			bet10.setDisable(false);
			bet15.setDisable(false);
			bet20.setDisable(false);
		});
		amount8.setOnAction((ActionEvent) -> {
			amount8.setEffect(shadow);
			bet1.setDisable(false);
			bet2.setDisable(false);
			bet3.setDisable(false);
			bet4.setDisable(false);
			bet5.setDisable(false);
			bet10.setDisable(false);
			bet15.setDisable(false);
			bet20.setDisable(false);
		});
		amount10.setOnAction((ActionEvent) -> {
			amount10.setEffect(shadow);
			bet1.setDisable(false);
			bet2.setDisable(false);
			bet3.setDisable(false);
			bet4.setDisable(false);
			bet5.setDisable(false);
			bet10.setDisable(false);
			bet15.setDisable(false);
			bet20.setDisable(false);
		});
		bet1.setOnAction((ActionEvent) ->{
			bet1.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		bet2.setOnAction((ActionEvent) ->{
			bet2.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		bet3.setOnAction((ActionEvent) ->{
			bet3.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		bet4.setOnAction((ActionEvent) ->{
			bet4.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		bet5.setOnAction((ActionEvent) ->{
			bet5.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		bet10.setOnAction((ActionEvent) ->{
			bet10.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		bet15.setOnAction((ActionEvent) ->{
			bet15.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		bet20.setOnAction((ActionEvent) ->{
			bet20.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
			games5.setDisable(false);
			games10.setDisable(false);
			games15.setDisable(false);
			games20.setDisable(false);
		});
		games1.setOnAction((ActionEvent)->{
			games1.setEffect(shadow);
			button.setDisable(false);
		});
		games2.setOnAction((ActionEvent)->{
			games2.setEffect(shadow);
			button.setDisable(false);
		});
		games3.setOnAction((ActionEvent)->{
			button.setDisable(false);
			games3.setEffect(shadow);
		});
		games4.setOnAction((ActionEvent)->{
			button.setDisable(false);
			games4.setEffect(shadow);
		});
		games5.setOnAction((ActionEvent)->{
			button.setDisable(false);
			games5.setEffect(shadow);
		});
		games10.setOnAction((ActionEvent)->{
			button.setDisable(false);
			games10.setEffect(shadow);
		});
		games15.setOnAction((ActionEvent)->{
			button.setDisable(false);
			games15.setEffect(shadow);
		});
		games20.setOnAction((ActionEvent)->{
			button.setDisable(false);
			games20.setEffect(shadow);
		});
		//layout2.getChildren().addAll(menu2);
		borderPane.setBackground(background2);
		borderPane.getChildren().addAll(menu2,spots,amountBox,bets,betBox,games,gamesBox,button);


		//scene 3 with gridpane
		VBox border2 = new VBox(10);
		scene3 = new Scene(border2, 800, 640);

		Button next = new Button("Start Drawing");
		HBox menu3 = new HBox(20);
		menu3.getChildren().add(menuBar2);
		// user pick numbers from grid
		Label pick_num = new Label("Pick spots:");
		pick_num.setFont(Font.font("Verdana", 10));
		pick_num.setAlignment(Pos.BASELINE_RIGHT);
		pick_num.setStyle("-fx-text-fill:lightblue;-fx-font: 40px \"Serif\";");
		GridPane num = new GridPane();
		num.setAlignment(Pos.CENTER);

		// need function that checks for numbers that ar ebeing selected
		for (int i = 1; i <= 80; i++) {
			ToggleButton num_select = new ToggleButton(String.valueOf(i));
			num_select.setPrefSize(50, 50);
			num_select.setOnAction((ActionEvent) -> {
				Player.storecardSelection(Integer.valueOf(num_select.getText()), num_select.isPressed());
			});
			selectNumbers.add(num_select);
			num.add(num_select, (i - 1) % 10, (i - 1) / 10);
		}
		Text selectedChoice = new Text();
		Text numSelected = new Text();
		Text help = new Text();
		Label drawNotice = new Label("Draw Result:");
		Label drawOutput = new Label("NILL");
		Label amountWonNotice = new Label("Amount Won:");
		Label amountWonOutput = new Label("NILL");
		Label selectedChoiceText = new Label("Choices Provided:");
		//Label selectedChoice = new Label("NILL");
		Label selectedBetText = new Label("Bet");
		Label selectedBet = new Label("NILL");
		Label totalBetText = new Label("Total Bet");
		Label totalBet = new Label("NILL");
		Label noOfMatchedText = new Label("No. of Matched Items");
		Label itemsMatchedText = new Label("Matched Items");
		Label wonText = new Label("Won");
		Label drawNoText = new Label("Draw");
		Label draw1 = new Label("1");
		Label draw2 = new Label("2");
		Label draw3 = new Label("3");
		Label draw4 = new Label("4");
		Label oneNoOfMatched = new Label("NILL");
		Label oneItemsMatched = new Label("NILL");
		Label oneWon = new Label("NILL");
		Label twoNoOfMatched = new Label("NILL");
		Label twoItemsMatched = new Label("NILL");
		Label twoWon = new Label("NILL");
		Label threeNoOfMatched = new Label("NILL");
		Label threeItemsMatched = new Label("NILL");
		Label threeWon = new Label("NILL");
		Label fourNoOfMatched = new Label("NILL");
		Label fourItemsMatched = new Label("NILL");
		Label fourWon = new Label("NILL");
		// need function that displays for numbers that are selected

		next.setOnAction((ActionEvent) -> {
			selectedChoice.setText(String.valueOf(Player.spotsSelect(Player.getSpot())));
			if ((Player.spotsSelect(Player.getSpot()))) {
				Player.nextDraw();

				numSelected.setText(String.valueOf(Player.getTotalSelectedSpots()));
				help.setText("Drawing!");



				Player.draw();
//				Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
//
//					@Override
//					public void handle(ActionEvent event) {
//						drawOutput.setText(String.valueOf(Player.getDraw(k)));
//
//						// Looping until all draws are complete
//						Player.decrementNoOfDraws();
//						k++;
//
//						// A Draw completes i.e 20 sub draws
//						if (k == 20) {
//							String tempAmount;
//
//							help.setText("Continue to Next Draw");
//							String nstr = String.valueOf(Player.getDraws());
//							if (Integer.parseInt(nstr) == Player.getCurrentDraw()) {
//								help.setText("Game Over");
//								next.setDisable(true);
//
//							} else {
//								next.setDisable(false);
//							}
//
//							// Show results
//							tempAmount = Player.getAmountResult();
//							amountWonOutput.setText("$" + Player.getTotalWinning());
//
//							if (Player.getCurrentDraw() == 1) {
//								oneNoOfMatched.setText(Player.getMatchedSize());
//								oneItemsMatched.setText(Player.getMatchedList());
//								oneWon.setText("$" + tempAmount);
//							} else if (Player.getCurrentDraw() == 2) {
//								twoNoOfMatched.setText(Player.getMatchedSize());
//								twoItemsMatched.setText(Player.getMatchedList());
//								twoWon.setText("$" + tempAmount);
//							} else if (Player.getCurrentDraw() == 3) {
//								threeNoOfMatched.setText(Player.getMatchedSize());
//								threeItemsMatched.setText(Player.getMatchedList());
//								threeWon.setText("$" + tempAmount);
//							} else if (Player.getCurrentDraw() == 4) {
//								fourNoOfMatched.setText(Player.getMatchedSize());
//								fourItemsMatched.setText(Player.getMatchedList());
//								fourWon.setText("$" + tempAmount);
//							} else {
//								throw new RuntimeException("Illegal Draw");
//							}
//
//							// Reset
//							Player.resetDraw();
//						}
//					}
//				}));
//
//				// Reset printing draws position to zero
//				k = 0;
//
//				// 20 Draws
//				timeline.setCycleCount(TOTAL_DRAWINGS - k);
//				timeline.play();

			}
			else {
				// do Warn User
				help.setText("Check Your Spots");
			}
		});
		//next.setOnAction(e -> window.setScene(scene4));
		border2.getChildren().addAll(menu3,pick_num, num,next,help,selectedChoice,numSelected,amountWonOutput);
		//scene 4
		//scene 3 with grid pane
		VBox border4 = new VBox(10);
		scene4 = new Scene(border4, 800, 640);
		Label draw = new Label("Draw Results:");
		Label winning = new Label("Total Winnings:");
		HBox resultsbox = new HBox(10);
		resultsbox.getChildren().addAll(draw,winning);
		//border4.getChildren().addAll(resultsbox,selectedChoice,numSelected);

		window.setScene(scene1);
		window.setTitle("KENO");
		window.show();
		//String image = JavaFXApplication19.class.getResource("https://amymhaddad.s3.amazonaws.com/morocco-blue.png").toExternalForm();

	}
	// things needed still:
	// function for randomizing the numbers
	// adding up total winnings
	// final screen displaying done
	// pause transitions in gridu
	// updates grids based on 4 spots choices
	// update background with cool image
	// start drawing grid button // done
	// next screen will start drawing then display numbers and the total winnings


}

