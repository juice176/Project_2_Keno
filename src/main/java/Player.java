import java.util.ArrayList;

public class Player {
    public static ArrayList<Integer> game; // players user input
    public static int playBet;
    public static int spot;
    public static int drawings;

    public static int counter;
    public static int totalWinnings;
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
    static void storecardSelection(int value, boolean pressButton){
        if(pressButton){
            game.add(value);// store the numbers picked by the user
        }
        else{
            game.remove(value); // remove the numbers not picked by the user
        }
    }
    static boolean spotsSelect(String input, Integer buttons){
        buttons = game.size();
        //|| (input == "4" && buttons == 4)||(input == "8" && buttons == 8)||(input == "10" && buttons == 10)
        if(input == "1" && buttons == 1 ){
            return true;
        }
        else{
            return false;
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
    static String getTotalWinning(){
        return Integer.toString(totalWinnings);
    }
    static String getSpot(){
        return Integer.toString(spot);
    }
    static String getplayBet(){
        return Integer.toString(playBet);
    }
    static String getDraw(int index){
        return Integer.toString(drawing[index]);
    }


}