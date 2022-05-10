package domein;

import java.util.ArrayList;
import java.util.List;

import persistenties.SpelerMapper;
import domein.Spel;

public class SpelerRepository {
	
	private List<Speler> spelers;
	private SpelerMapper sm;
	private int aantalSpelers;
	
	public SpelerRepository() {    //4a
		spelers = new ArrayList<>();
		sm = new SpelerMapper();
	}
	
	public Speler vraagSpelerOp(String gebruikersnaam, int geboortedatum) {
		Speler s = sm.geefSpeler(gebruikersnaam, geboortedatum);
		if(s.getGeboortejaar() == (geboortedatum)) {
			for(Speler speler: spelers) {
				if(speler.getGebruikersnaam().equals(speler.getGebruikersnaam())) {

				}
				
			break;
			}
			spelers.add(s);
			
			
		}
		return s;		
	}
	
	public List<Speler> geefSpelersList(){
		return spelers;
	}
	
	public void addSpeler(String gebruikersnaam, int geboortejaar, int speelkansen) {
		sm.geefSpelerIn(gebruikersnaam, geboortejaar, speelkansen);
		Speler s = (new Speler(gebruikersnaam, geboortejaar, speelkansen));
		this.spelers.add(s);
		
	}
	
	public void showSpeler() {
		System.out.println("Gebruikersnaam Geboortejaar Speelkansen");

		for(Speler s: spelers) {
			System.out.printf("%14s %12d %11d %n",s.getGebruikersnaam(),s.getGeboortejaar(),s.getTotaleSpelkansen());
			aantalSpelers++;
		}
	}
	
	public List<String> toonOverzichtScores(){
		List<String> overzicht = new ArrayList<>();
		for(Speler speler: spelers)
			overzicht.add(String.format("%20s%20d", speler.getGebruikersnaam(), speler.getTotaleSpelkansen()));
		return overzicht;
	}
	
	public void updateTotaleSpeelkansen() {
		for(Speler speler : spelers) {
			sm.updateTotaleSpeelkansen(speler.getGebruikersnaam(), speler.getGeboortejaar(), speler.getTotaleSpelkansen());
		}
	}
}