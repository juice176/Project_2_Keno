import java.util.ArrayList;
import java.util.Random;

public class Player {
    static ArrayList<Integer> game = new ArrayList<Integer>(); // players user input

    private static ArrayList<String> list = new ArrayList<String>();//matched outcome
    public static int playBet = 1;
    public static int spot = 1;
    public static int drawings = 20;

    public static int counter = 0;
    public static int totalWinnings = 0;
    private static int[] drawing = new int[20];
    //boolean gameRun = true;


    // set player
    Player(){
        super();
        this.game = new ArrayList<Integer>();
        this.playBet = 0;
        this.spot = 0;
        this.drawings = 20;
        this.totalWinnings = 0;
    }
    //setting the card by userinput
    static void storecardSelection(Integer value, boolean pressButton){
        if(pressButton == true){
            game.add(value);// store the numbers picked by the user
        }
        else{
            game.remove(value); // remove the numbers not picked by the user
        }
    }
    static String getSelectedList() {
        StringBuilder listString = new StringBuilder();

        for (Integer s : game)
            listString.append(s + ", ");

        return listString.toString();
    }

    // updates game arraylist when spot is selected
//    static boolean addArray(Button num_select){
//        if(num_select.fire() == spot) {
//            System.out.println("Reached Max spots");
//            return false;
//        }
//        num_select.add(game);
//        return true;
//    }

    static boolean spotsSelect(Integer input){
        Integer buttons = game.size();
        //
        if((input == 1 && buttons == 1)||(input == 4 && buttons == 4 )|| (input == 8 && buttons == 8 )|| (input == 10 && buttons == 10)){
            return true;
        }
        else{
            return false;
        }
    }
    static void draw() {

        int[] num = new int[80];

        for (int i = 0; i < 80; i++) {
            num[i] = i + 1;
        }

        Random rand = new Random();

        // Randomly swap array values
        for (int i = 0; i < num.length; i++) {
            int index = rand.nextInt(num.length);
            int temp = num[index];
            num[index] = num[i];
            num[i] = temp;
        }

        for (int i = 0; i < 20; i++) {
            drawing[i] = num[i];
        }

    }

    static void reset(){
        game.clear();
        playBet = 0;
        spot = 0;
        totalWinnings = 0;
    }

    private int value;
    static int getTotalSelectedSpots() {
        return game.size();
    }

    // 20 sub-draw = 1 draw, 40 sub-draw = 2 draw, ...
    static void setNoOfDraws(int value) {
        drawings = value;
    }

    // Decrement sub-draws by 1, 1 drawing completes
    static void decrementNoOfDraws() {
        drawings--;
    }

    // total sub-draws remaining
    static int getNoOfDraws() {
        return drawings;
    }

    // Returns which Draw is executing
    static int getCurrentDraw() {
        return counter;
    }

    // increments drawCounter when 1 draw completes a.k.a 20 sub-draws
    static void nextDraw() {
        counter++;
    }

//set number of spots
    public static void set_Value(int value) {
        spot = value;
    }
    //set number of bets
    static void set_Bet(int value){
        playBet = value;
    }
    //set number of draws
    static void set_Draws(int value){
        drawings = value;
    }
    static Integer getTotalWinning(){
        return totalWinnings;
    }
    static Integer getSpot(){
        return spot;
    }
    static Integer getplayBet(){
        return playBet;
    }
    static Integer getDraws(){
        return drawings;
    }
    static int getDraw(int index){
        return drawing[index];
    }

    static String getMatchedSize() {
        return Integer.toString(list.size());
    }
    static String getMatchedList() {

        if (list.size() == 0) {
            return "NILL";
        }
        StringBuilder listString = new StringBuilder();

        for (String s : list)
            listString.append(s + ", ");

        return listString.toString();
    }
    static void resetDraw() {
        list.clear();
    }

    static String getAmountResult() {
        String out;

        for (int i = 0; i < 20; i++) {
            list.add(i, Integer.toString(drawing[i]));
        }
        list.retainAll(game);

        out = Odds.gameChart(game.size(), list.size(), spot);
        spot += Integer.parseInt(out);
        return out;
    }
}