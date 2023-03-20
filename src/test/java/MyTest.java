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
		assertEquals(4, Player.playBet);
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
		Player.storecardSelection("1",true);
		assertEquals("1, ", Player.userList());

	}
	@Test
	public void checkusersize(){
		ArrayList game = new ArrayList<>();
		game.add("1");
		game.add("2");
		assertEquals(2,game.size());
	}
	@Test
	public void checkspotsselect(){
		ArrayList game2 = new ArrayList<>();
		game2.add("1");
		game2.add("2");
		assertFalse(Player.spotsSelect(2));

	}
	@Test
	public void checknextdraw(){
		Player.set_Draws(1);
		Player.decreaseDraws();
		assertEquals(0,Player.getDraws());
	}
	@Test
	public void checkcurdraw(){
		Player.nextDraw();
		Player.nextDraw();
		Player.nextDraw();
		assertEquals(3,Player.curDraw());
	}
	@Test
	public void checkdecreasedraw(){
		Player.set_Draws(70);
		Player.decreaseDraws();
		assertEquals(69,Player.getDraws());
	}

	@Test
	public void checkgetplaybet(){
		Player.set_Bet(4);
		assertEquals(4,Player.getplayBet());

	}
	@Test
	public void checkgetSpot(){
		Player.set_Value(6);
		assertEquals(6,Player.getSpot());

	}



}
