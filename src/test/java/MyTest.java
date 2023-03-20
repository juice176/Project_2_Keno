import static org.junit.jupiter.api.Assertions.*;

//import jdk.internal.icu.text.UnicodeSet;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class MyTest {
	@Test
	public void calculatorInitialValueZero() {
		Player calculator = new Player();
		assertEquals(0, calculator.getTotalWinning());
	}
	@Test
	public void calculatorInitialValueZero1(){
		assertEquals(1, Player.getplayBet());
	}
	@Test
	public void calculatorInitialSpots(){
		Player.set_Value(1);
		assertEquals(1,Player.getSpot());
	}
	@Test
	public void calculatorInitialcheckspots(){
		Player.set_Value(1);
		assertEquals(1,Player.getSpot());
	}
	@Test
	public void checkPlayerdraw(){
		Player.set_Draws(4);
		assertEquals(4,Player.getDraws());
	}
	@Test
	public void checklistsize(){
		ArrayList list = new ArrayList<>();
		list.add("hello");
		assertEquals(1,list.size());
	}
	@Test
	public void checkselectedspots(){

	}
	@Test
	public void checkspotsselect(){

	}
	@Test
	public void checknextdraw(){

		assertEquals(0,Player.curDraw());
	}
	@Test
	public void checkcurdraw(){
		Player card = new Player();
		card.nextDraw();
		card.nextDraw();
		card.nextDraw();
		assertEquals(3,card.curDraw());
	}
	@Test
	public void checkdecreasedraw(){

	}
	@Test
	public void checkgetdraws(){

	}
	@Test
	public void checkgetplaybet(){

	}
	@Test
	public void checkgetSpot(){

	}
	@Test
	public void checkgetTotalWin(){

	}
	@Test
	public void checksetdraws(){

	}
	@Test
	public void checksetbets(){

	}
	@Test
	public void checkspots(){

	}



}
