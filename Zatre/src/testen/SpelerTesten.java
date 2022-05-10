package testen;
import domein.Speler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class SpelerTesten {

	@Test
	public void gebruikersnaam_langGenoeg_retoruneertTrue() {
		Speler regristratie = new Speler(null, 0, 0);
		String gebruikersnaam = "Mystic";
		boolean result = regristratie.gebruikersnaamLangGenoeg(gebruikersnaam);
		assertTrue(result);
	}
	
	@Test
	public void gebruikersnaam_teKort_retoruneertFalse() {
		Speler regristratie = new Speler();
		String gebruikersnaam = "Jorn", message ="Gebruikersnaam is te kort";
		boolean result = regristratie.gebruikersnaamLangGenoeg(gebruikersnaam);
		assertFalse(result, message);
	}
	
	@Test
	public void leeftijd_oudGenoeg_retourneertTrue() {
		Speler regristratie = new Speler();
		int geboortejaar = 2001;
		boolean result = regristratie.leeftijdOudGenoeg(geboortejaar);
		assertTrue(result);
	}
	
	@Test
	public void leeftijd_teJong_retourneertFalse() {
		Speler regristratie = new Speler();
		int geboortejaar = 2018;
		boolean result = regristratie.leeftijdOudGenoeg(geboortejaar);
		assertFalse(result);
				
	}
	private Speler speler;
	@BeforeEach
	public void before() {
		speler = new Speler();
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"     ", "a", "A"})
	public void setGebruikersnaam_ongeldigeWaarden_gooitException(String gebruikersnaam) {
		Assertions.assertThrows(IllegalArgumentException.class,() -> {speler.setGebruikersnaam(gebruikersnaam);} );
		
	}
