package cui;

import java.util.Scanner;

import domein.Speler;
import domein.DomeinController;
import domein.Spel;
import domein.SpelerRepository;

public class Applicatie {
	private int aantal = 0;
	private DomeinController dc;

	public Applicatie() {   //2
		dc = new DomeinController();
		startUp();	
	}
	
	public void startUp() {
		beginscherm();
	}
	
	
	private void beginscherm() {
		Scanner input = new Scanner(System.in);
		Speler speler = new Speler("Admin", 2000, 0);
		int run = 0, spelstarten = 0;
		
		System.out.println("Welcome bij Hogent Zatre Application.");
		System.out.println("Om een gebruiker te registeren input 1, om u als gebruiker wenst aan te melden input 2.");
		System.out.println("Om het process te beindigen input 3");
		do {
			int choise = input.nextInt();
		switch(choise) {
		case 1:
			System.out.println("Om u te registeren gelieve uw gebruikersnaam aan te maken en uw geboortejaar in te vullen.");
			System.out.print("Gebruikersnaam: ");
			String gebruikersnaam = input.next();
			System.out.print("Geboortejaar: ");
			int geboortejaar = input.nextInt();
			while(!speler.gebruikersnaamLangGenoeg(gebruikersnaam)) {
				System.out.println("Deze gebruikersnaam is ongeldig gelieve een andere in te vullen.");
				System.out.print("Gebruikersnaam: ");
				gebruikersnaam = input.next();
			}
			dc.registreer(gebruikersnaam, geboortejaar, 3);
			System.out.println("Spelers is succesvol geregistreerd");
			break;
		case 2:
			if(aantal<=3) {
//				System.out.println("Hier is uw lijst van mogelijke accounts.");
				System.out.print("Input uw gebruikersnaam en geboortedatum in om u aan te melden.");
				gebruikersnaam = input.next();
				System.out.println("Geboortedatum:");
				geboortejaar = input.nextInt();
				System.out.println("Hier is een overzicht van de aangemelde Spelers");
				dc.vraagSpelerOp(gebruikersnaam, geboortejaar);
				
				aantal++;
			}
			if(aantal >= 2 && aantal<4) {
				System.out.println("Minimun requirement of spelers aangemeld, wilt u het spel starten?");
				System.out.println("Om het spel te starten input 1, om verder te gaan input random number: ");
				spelstarten = input.nextInt();
				if(spelstarten == 1)
					SpelStarten();
			}
			if(aantal==4) {
				System.out.println("Maximum spelers aanwezig Starting the game.");
				SpelStarten();
				run = 1;
			}
			break;
		case 3:
			run = 1;
			break;
		
		case 4:
			dc.vraagSpelerOp("Speler1", 2000);
			dc.vraagSpelerOp("Speler2", 2001);
			SpelStarten();
		}
		if(run != 1 && spelstarten == 0)
			System.out.print("Wenst u nog een gebruiker te registeren input 1 voor een overzicht input 2, en om het process te beindigen input 3.");
			
		}while(run != 1);
	}

	
	public void SpelStarten() {
		System.out.println("Starting the game please wait.");
		dc.startNieuwSpel();
		
	}

		
	
}