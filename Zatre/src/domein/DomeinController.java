package domein;

import java.util.ArrayList;
import java.util.List;
import domein.Spel;

public class DomeinController {
	
	private List<Speler> spelers;
	private SpelerRepository spelerRepo;
	private Spel spel;
	private int aantal;
//	private Scoreblad scoreblad;
	
	
	
	public DomeinController() {   //3
		spelerRepo = new SpelerRepository();
	}
	

	public void startNieuwSpel() {
//		System.out.println("startnieuwSpel");
		spel = new Spel(spelerRepo.geefSpelersList());	
	}
	
	public void registreer(String gebruikersnaam, int geboortejaar, int speelkansen) {
		spelerRepo.addSpeler(gebruikersnaam, geboortejaar, speelkansen);
	}
	
//	public void geefScore() {
//		scoreblad.getScore();
//	}
	
	public boolean EindeSpel() {
		boolean eindeSpel = spel.isEindeSpel();
		if(eindeSpel) {
			spel.updateTotaleSpeelkansen();
			spelerRepo.updateTotaleSpeelkansen();
		}
		return true;
	}
	
	public void setSteen(int row, int column, int waarde) {
		spel.setSteen(row, column, waarde);
	}
	
//	public List<String> geefSpeler(){
//		List<String> gebruikersnaam = new ArrayList<>();
//		for(Speler speler : spelers) {
//			gebruikersnaam.add(speler.toString());
//		}
//		return gebruikersnaam;
//	}
	
	public void vraagSpelerOp(String gebruikersnaam, int geboortejaar) {
		spelerRepo.vraagSpelerOp(gebruikersnaam, geboortejaar);
		spelerRepo.showSpeler();
	}
	
}