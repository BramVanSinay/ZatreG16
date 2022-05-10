package testen;
import domein.Spelbord;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Speler;

class SpelbordTesten {
	
	private Spelbord gameboard;
	@BeforeEach
	public void before() {
		gameboard = new Spelbord();
	}

	@Test
	public void kan_opVak_Plaatsen_retoruneertFalse() {
		int row = 0, column = 0;
		boolean result = gameboard.isVakPlaceable(row, column);
		assertFalse(result);
	}
	
//	@ParameterizedTest
//	@NullAndEmptySource
//	@ValueSource(strings = {"     ", "a", "A"})
//	public void steenWaarde_ongeldigeWaarden_gooitException(int steenwaarde) {
//		Assertions.assertThrows(IllegalArgumentException.class,() -> {gameboard.;} );		
//	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(ints = {-1, 0, 7, 8})
	public void Steen_ongeldigeWaarden_gooitException(int steenwaarde) {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {gameboard.setSteen(4, 5, steenwaarde);} );
		
	}

}