import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.event.EventHandler;
import java.util.ArrayList;


public class JavaFXTemplate extends Application {
	private static ArrayList<ToggleButton> selectNumbers = new ArrayList<ToggleButton>();
	private final int TOTAL_DRAWINGS = 20;
	private int i = 0,j = 0, k = 0;
	Stage window;
	Scene scene1, scene2, scene3, scene4, scene5, cuMrrentScene,currentScene;
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

		HBox menu2 = new HBox(20);
		menu2.getChildren().add(menuBar2);


		// updates:
		// asks user to pick spots
		//version 2
		ToggleGroup amountRadioGroup = new ToggleGroup();
		RadioButton amount1 = new RadioButton("1");
		RadioButton amount4 = new RadioButton("4");
		RadioButton amount8 = new RadioButton("8");
		RadioButton amount10 = new RadioButton("10");
		amount1.setToggleGroup(amountRadioGroup);
		amount4.setToggleGroup(amountRadioGroup);
		amount8.setToggleGroup(amountRadioGroup);
		amount10.setToggleGroup(amountRadioGroup);
		amountRadioGroup.selectToggle(amount1);

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
		RadioButton bet1 = new RadioButton("$1");
		ToggleGroup betRadioGroup = new ToggleGroup();
		bet1.setToggleGroup(betRadioGroup);

		bet1.setOnAction(e->Player.set_Bet(1));
		HBox betBox = new HBox(20, bet1);





		// then asks users to pick number of games
		Label games = new Label("How many games do you want to play?");
		games.setFont(Font.font("Verdana", 10));
		games.setAlignment(Pos.BASELINE_RIGHT);
		games.setStyle("-fx-text-fill:lightblue;-fx-font: 40px \"Serif\";");
		RadioButton games1 = new RadioButton("1");
		RadioButton games2 = new RadioButton("2");
		RadioButton games3 = new RadioButton("3");
		RadioButton games4 = new RadioButton("4");
		ToggleGroup gamesRadioGroup = new ToggleGroup();
		games1.setToggleGroup(gamesRadioGroup);
		games2.setToggleGroup(gamesRadioGroup);
		games3.setToggleGroup(gamesRadioGroup);
		games4.setToggleGroup(gamesRadioGroup);


		games1.setOnAction(e->Player.set_Draws(1));
		games2.setOnAction(e->Player.set_Draws(2));
		games3.setOnAction(e->Player.set_Draws(3));
		games4.setOnAction(e->Player.set_Draws(4));
		HBox gamesBox = new HBox(20, games1, games2, games3,games4);

		Button button = new Button("NEXT");
		button.setOnAction(e -> window.setScene(scene3));
		button.setDisable(true);
		bet1.setDisable(true);
		games1.setDisable(true);
		games2.setDisable(true);
		games3.setDisable(true);
		games4.setDisable(true);

		amount1.setOnAction((ActionEvent) -> {
			amount1.setEffect(shadow);
			bet1.setDisable(false);

		});
		amount4.setOnAction((ActionEvent) -> {
			amount4.setEffect(shadow);
			bet1.setDisable(false);
		});
		amount8.setOnAction((ActionEvent) -> {
			amount8.setEffect(shadow);
			bet1.setDisable(false);
		});
		amount10.setOnAction((ActionEvent) -> {
			amount10.setEffect(shadow);
			bet1.setDisable(false);
		});
		bet1.setOnAction((ActionEvent) ->{
			bet1.setEffect(shadow);
			games1.setDisable(false);
			games2.setDisable(false);
			games3.setDisable(false);
			games4.setDisable(false);
		});
//
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

		borderPane.setBackground(background2);
		borderPane.getChildren().addAll(menu2,spots,amountBox,bets,betBox,games,gamesBox,button);


		//scene 3 with gridpane
		VBox border2 = new VBox(10);
		scene3 = new Scene(border2, 800, 640);

		Button next = new Button("Start Drawing");
		Label RandomText = new Label("Random Input");
		ToggleButton RandomBox = new ToggleButton();
		HBox checkBoxBox = new HBox(20);
		checkBoxBox.getChildren().addAll(RandomText, RandomBox);
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
				Player.storecardSelection(num_select.getText(), num_select.isSelected());
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
		Label selectedBetText = new Label("Bet");
		Label selectedBet = new Label("NILL");
		Label totalBetText = new Label("Total Bet");
		Label totalBet = new Label("NILL");
		Label drawsMatched = new Label("No. of Matched Items");
		Label drawsMatchedList = new Label("Matched Items");
		Label drawText = new Label("Draw");
		Label drawWins = new Label("Won");
		Label draw1 = new Label("1");
		Label draw2 = new Label("2");
		Label draw3 = new Label("3");
		Label draw4 = new Label("4");
		Label draw1Matched = new Label("NILL");
		Label draw1MatchedList = new Label("NILL");
		Label draw1Won = new Label("NILL");
		Label draw2Matched = new Label("NILL");
		Label draw2MatchedList = new Label("NILL");
		Label draw2Won = new Label("NILL");
		Label draw3Matched = new Label("NILL");
		Label draw3MatchedList = new Label("NILL");
		Label draw3Won = new Label("NILL");
		Label draw4Matched = new Label("NILL");
		Label draw4MatchedList = new Label("NILL");
		Label draw4Won = new Label("NILL");
		// need function that displays for numbers that are selected
		HBox drawBox = new HBox(10);
		drawBox.getChildren().addAll(drawNotice, drawOutput, amountWonNotice, amountWonOutput);
		next.setOnAction((ActionEvent) -> {

			RadioButton sRB = (RadioButton) amountRadioGroup.getSelectedToggle();
			String str = sRB.getText();
			selectedChoice.setText("Amount" + str);
			if (Player.spotsSelect(Integer.valueOf(str)) == true && Player.getDraws() > 0) {
				//&& Player.getDraws() > 0
				Player.nextDraw();
				RadioButton drawrb = (RadioButton) gamesRadioGroup.getSelectedToggle();
				String drawstr = drawrb.getText();
				numSelected.setText(String.valueOf("Selected spots"+Player.getTotalSelectedSpots()));
				selectedChoice.setText(Player.userList());
				selectedBet.setText("$" + Player.getplayBet());
				totalBet.setText("$" + Player.getplayBet() * Integer.parseInt(drawstr));
				help.setText("Drawing!");
				Player.draw();
				Player.decreaseDraws();
				Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						drawOutput.setText(String.valueOf(Player.getDraw(k)));

						// Looping until all draws are complete

						k++;

						// A Draw completes i.e 20 sub draws
						if (k == 20) {
							String tempAmount;

							help.setText("Continue to Next Draw");
							if (Integer.parseInt(drawstr) == Player.curDraw()) {
								help.setText("Game Over");
								next.setDisable(true);

							} else {
								next.setDisable(false);
							}

							// Show results
							tempAmount = Player.lotteryWinning();
							amountWonOutput.setText("$" + Player.getTotalWinning());

							if (Player.curDraw() == 1) {
								draw1Matched.setText(Player.userSize());
								draw1MatchedList.setText(Player.gameList());
								draw1Won.setText("$" + tempAmount);
							} else if (Player.curDraw() == 2) {
								draw2Matched.setText(Player.userSize());
								draw2MatchedList.setText(Player.gameList());
								draw2Won.setText("$" + tempAmount);
							} else if (Player.curDraw() == 3) {
								draw3Matched.setText(Player.userSize());
								draw3MatchedList.setText(Player.gameList());
								draw3Won.setText("$" + tempAmount);
							} else if (Player.curDraw() == 4) {
								draw4Matched.setText(Player.userSize());
								draw4MatchedList.setText(Player.gameList());
								draw4Won.setText("$" + tempAmount);
							} else {
								throw new RuntimeException("Nope Can't Do That");
							}

							// Reset
							Player.resetDraw();
						}
					}
				}));

				// Reset printing draws position to zero
				k = 0;

				// 20 Draws
				timeline.setCycleCount(TOTAL_DRAWINGS - k);
				timeline.play();

			}
			else {
				// do Warn User
				help.setText("Wrong Input");
			}
		});
		RandomBox.setOnAction((ActionEvent) -> {

			if (RandomBox.isSelected() == true) {
				RadioButton sRB = (RadioButton) amountRadioGroup.getSelectedToggle();
				String str = sRB.getText();
				Player.setRandom(str);

				// Prevent manual input
				num.setDisable(false);
				// Reset all nodes
				for (i = 1; i <= 80; i++) {
					ToggleButton checkbox = new ToggleButton();
					checkbox = selectNumbers.get(i - 1);
					if (checkbox.isSelected())
						checkbox.fire();
				}
				num.setDisable(true);

			} else {
				num.setDisable(false);
			}

		});
		VBox vbox1 = new VBox(10);
		VBox vbox21 = new VBox(10);
		GridPane slotResults = new GridPane();
		slotResults.setHgap(30);
		slotResults.setVgap(10);

		slotResults.add(drawText, 0, 0, 1, 1);
		slotResults.add(drawsMatched, 1, 0, 1, 1);
		slotResults.add(drawsMatchedList, 2, 0, 1, 1);
		slotResults.add(drawWins, 3, 0, 1, 1);

		slotResults.add(draw1, 0, 1, 1, 1);
		slotResults.add(draw1Matched, 1, 1, 1, 1);
		slotResults.add(draw1MatchedList, 2, 1, 1, 1);
		slotResults.add(draw1Won, 3, 1, 1, 1);

		slotResults.add(draw2, 0, 2, 1, 1);
		slotResults.add(draw2Matched, 1, 2, 1, 1);
		slotResults.add(draw2MatchedList, 2, 2, 1, 1);
		slotResults.add(draw2Won, 3, 2, 1, 1);

		slotResults.add(draw3, 0, 3, 1, 1);
		slotResults.add(draw3Matched, 1, 3, 1, 1);
		slotResults.add(draw3MatchedList, 2, 3, 1, 1);
		slotResults.add(draw3Won, 3, 3, 1, 1);

		slotResults.add(draw4, 0, 4, 1, 1);
		slotResults.add(draw4Matched, 1, 4, 1, 1);
		slotResults.add(draw4MatchedList, 2, 4, 1, 1);
		slotResults.add(draw4Won, 3, 4, 1, 1);
		vbox1.getChildren().addAll(selectedBetText, selectedBet, totalBetText, totalBet);
		vbox21.getChildren().addAll(selectedChoiceText, selectedChoice);
		HBox hbox12 = new HBox(30);
		hbox12.getChildren().addAll(vbox1, vbox21,slotResults);
		VBox border3 = new VBox(10);
		scene5 = new Scene(border3, 800, 640);
		Button new_game = new Button("New Game");
		new_game.setOnAction(event -> window.setScene(scene5));
		new_game.setAlignment(Pos.CENTER);
		new_game.setStyle("-fx-text-fill:lightblue;-fx-font: 10px \"Serif\";");

		Text end_message = new Text();
		end_message.setText("Thanks for playing!\n" +
				"\n" +
				"Get Help:" +
				"Hotline #: 1-800-522-4700");
		end_message.setTextAlignment(TextAlignment.CENTER);
		border3.getChildren().addAll(end_message);
		border2.getChildren().addAll(menu3,checkBoxBox,pick_num, num,next,new_game,help,selectedChoice,numSelected,amountWonOutput,drawBox,hbox12);
		dark.setOnAction((ActionEvent)->{
			borderPane.setStyle("-fx-padding:5; -fx-background-color:Gray");
			border2.setStyle("-fx-background-color: Gray");
			menuBar2.setStyle("-fx-background-color: DarkGrey");
			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = selectNumbers.get(i - 1);
				btn.setStyle("-fx-text-fill: Grey; -fx-font: 16 \"Serif\"; -fx-border-color: Black;");
			}

		});
		light.setOnAction((ActionEvent)-> {
			borderPane.setStyle("-fx-padding:5; -fx-background-color: #F5F5DC ");
			border2.setStyle("-fx-background-color: #D3B69C");
			menuBar2.setStyle("-fx-background-color: White");
			for (i = 1; i <= 80; i++) {
				ToggleButton btn = new ToggleButton();
				btn = selectNumbers.get(i - 1);
				btn.setStyle("-fx-text-fill: #af804f; -fx-font: 18 \"Serif\"; -fx-border-color: #F0D2C1;");
			}
		});

		// last scene of game





		window.setScene(scene1);
		window.setTitle("KENO");
		window.show();

	}


}

