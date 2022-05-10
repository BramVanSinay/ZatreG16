package cui;

import java.util.Scanner;

import domein.Speler;

public class ZatreApplicatie {

	public static void Applicatie() {
		Scanner input = new Scanner(System.in);
		Speler speler = new Speler();
//		speler.Speler();
		System.out.println("Welcome bij Hogent Zatre. Om een gebruiker te registeren input 1, om u als gebruiker wenst aan te melden input 2.");
		System.out.println("Input 3 om het process te beindigen");
		int choise = input.nextInt();
		int run = 0;
		do {
		switch(choise) {
		case 1:
			System.out.println("Om u te registeren gelieve uw gebruikersnaam aan te maken en uw geboortejaar in te vullen.");
			System.out.print("Gebruikersnaam: ");
			String gebruikersnaam = input.next();
			System.out.print("Geboortejaar: ");
			int geboortejaar = input.nextInt();
			int test = speler.addSpelers(gebruikersnaam,geboortejaar);
			while(test == 1) {
				System.out.print("Gebruikersnaam: ");
				gebruikersnaam = input.next();
				if(speler.addSpelers(gebruikersnaam, geboortejaar)!=1)
					test = 0;
			}
			if (speler.leeftijdOudGenoeg(geboortejaar) && speler.gebruikersnaamLangGenoeg(gebruikersnaam)) {
				System.out.println("Wenst u nog een gebruiker te registreren input 1, om u aan te melden input 2 en voor het process te beindigen input 3");
			}
			break;
		case 2:
			System.out.println("Hier is uw lijst van mogelijke accounts.");
			speler.spelerList();
			break;
		case 3:
			run = 1;
			break;
		case 4:
			System.out.println("Please input het nummer van de speler die wenst mee te spelen.");
			int spelernumber = input.nextInt();
			break;
			
		}					
		choise = input.nextInt();

			
		}while(run != 1);

	}
}