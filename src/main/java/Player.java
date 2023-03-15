import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
public class Player {
    public static ArrayList<Integer> game;
    public static int playBet;
    public static int spot;
    public static int totalWinnings;
    //boolean gameRun = true;


    // set player
    Player(){
        super();
        this.game = new ArrayList<Integer>();
        this.playBet = 0;
        this.spot = 0;
        this.totalWinnings = 0;
    }
    //setting the card by userinput
    void storecardSelection(int value, boolean pressButton){
        if(pressButton){
            game.add(value);// store the numbers picked by the user
        }
        else{
            game.remove(value); // remove the numbers not picked by the user
        }
    }
    static boolean spotsSelect(String input){
        int buttons = game.size();
        if((input == "1" && buttons == 1) || (input == "4" && buttons == 4)||(input == "8" && buttons == 8)||(input == "10" && buttons == 10)){
            return true;
        }
        return false;
    }

    static String getTotalWinning(){
        return Integer.toString(totalWinnings);
    }
    static String getplayBet(){
        return Integer.toString(playBet);
    }
    static void reset(){
        game.clear();
        playBet = 0;
        spot = 0;
        totalWinnings = 0;
    }

    private int value;

    public Card(int value) {
        this.value = value;
    }


    public void set_Value(int value) {
        this.value = value;
    }

    public int get_value( )  {
        return this.value;
    }

}