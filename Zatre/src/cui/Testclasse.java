package cui;
import domein.Spel;
import java.util.Scanner;
import cui.ZatreApplicatie;
import domein.Spelbord;
import domein.DomeinController;

import domein.Speler;

import domein.SpelerRepository;
import gui.Scoreblad;
import gui.loginScherm;
import persistenties.SpelerMapper;
public class Testclasse {

	public static void main(String[] args) {
		
//<<<<<<< HEAD
//		Applicatie app = new Applicatie();
//		app.main(args);
		
		
//=======

//		Applicatie app = new Applicatie();
//		app.main(args);
//		
//		SpelerRepository sr = new SpelerRepository();
//		sr.addSpeler(null, 0, 0);
//		
//		
//		SpelerMapper sm = new SpelerMapper();
//		//sm.geefSpeler(null, 0);
//		sm.geefSpelerIn(null, 0, 0);
//>>>>>>> refs/remotes/origin/main
		
		
//		SpelerMapper sm = new SpelerMapper();
//		sm.geefSpeler(null, 0);
//		sm.updateTotaleSpeelkansen(null, 0, 0);
		
		Scoreblad ls = new Scoreblad();
		ls.;
		
	

		Applicatie app = new Applicatie();
		SpelerRepository spelerRepo = new SpelerRepository();
		spelerRepo.vraagSpelerOp("Speler1", 2000);
		spelerRepo.vraagSpelerOp("Speler2", 2001);
		spelerRepo.vraagSpelerOp("Speler3", 2003);
		spelerRepo.vraagSpelerOp("Speler4", 2000);
		spelerRepo.showSpeler();
		app.SpelStarten();
		

		
//		Applicatie app = new Applicatie();
//		app.main(args);
//
//		SpelerRepository sr = new SpelerRepository();
//		sr.addSpeler(null, 0, 0);
//		
//		SpelerMapper sm = new SpelerMapper();
//		//sm.geefSpeler(null, 0);
//		sm.geefSpelerIn(null, 0, 0);
	

	}
}