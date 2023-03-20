import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {
	@Test
	public void calculatorInitialValueZero() {
		Player calculator = new Player();
		assertEquals(0, calculator.getTotalWinning());
	}
	@Test
	public void calculatorInitialValueZero1(){
		Player calc = new Player();
		assertEquals(0, Player.getplayBet());
	}
	@Test
	public void calculatorInitialSpots(){
		Player.set_Value(1);
		assertEquals(1,Player.getSpot());
	}
	@Test
	public void calculatorInitialcheckspots(){
		Player.set_Value(1);
		int jello = Player.getSpot();
		int hello = Player.game.size();
		assertEquals(1,Player.getSpot());
	}
	@Test
	public void checkPlayerdraw(){
		//Player draws = new Player();
		Player.set_Draws(4);
		assertEquals(4,Player.getDraws());
	}
	@Test
	public void check


}
