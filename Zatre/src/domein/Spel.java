package domein;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Spel {
	
	private Speler speler;
	private int MIN_SPELERS = 2;
	private int MAX_SPELERS = 4;
	private int score;
	private int beginAantal;
	private int beurtAantal = 0;
	private int spelerAanBeurt;
	private List<Steen> stenen;
	private List<Speler> spelers;
	private List<Steen> eigenStenen;
	private Spelbord bord;
	//private Scoreblad scoreblad;

	
	public Spel(List<Speler> spelers) {
		this.spelers= spelers;
		startUp();
	}
	
	private void startUp() {
		bepalenVolgorde();
		stenen = aanmakenStenen();
		stenenUitdelen();
		bord = new Spelbord();
		beurt();

	}
	
	public void beurt() {
		Scanner input = new Scanner(System.in);
		int einde = 0, steen = 0, steenwaarde = 0;
		System.out.printf("Speler %s is aan de beurt.%n", spelers.get(spelerAanBeurt).getGebruikersnaam());
		// show collection of stones available
		System.out.println("Available stenen: " + spelers.get(spelerAanBeurt).getStenen().toString());
		bord.showSpelbord();
		do {
		if(beurtAantal!=0) {
			System.out.println("Input the coordinaten en de steenwaarde voor de plaats waar je de steen wilt leggen.");
			System.out.print("xCoordinaat: ");
			int xCoordinaat = input.nextInt();
			System.out.print("yCoordinaat: ");
			int yCoordinaat = input.nextInt();
			if(steen == 0) {
				System.out.print("Steenwaarde: ");
				steenwaarde = input.nextInt();
				steen = 1;
			}
			if(bord.steenKanLeggen(xCoordinaat, yCoordinaat, steenwaarde)) {
				bord.setSteen(xCoordinaat, yCoordinaat, steenwaarde);
				spelers.get(spelerAanBeurt).removeSteen(steenwaarde);
				einde = 1;
			}
			else if(!bord.steenKanLeggen(xCoordinaat, yCoordinaat, steenwaarde)) {
				System.out.println("De gekozen vak ligt niet naast een steen gelieve een andere vak te kiezen.");
				einde = 0;
			}
		}
	
		else if(beurtAantal == 0) {
			System.out.println("Voor de eerste steen moet het in de center van het bord gelegd worden.");
			System.out.print("Steenwaarde: ");
			steenwaarde = input.nextInt();
			bord.setSteen(7, 7, steenwaarde);
			spelers.get(spelerAanBeurt).removeSteen(steenwaarde);
			einde = 1;
			
			}
		}while(einde == 0);
		neemSteen(spelers.get(spelerAanBeurt));
		beurtAantal++;
		eindeBeurt();
	}
	
	private void eindeBeurt() {
		updateSpelerAanBeurt();
		beurt();
	}

	public List<Steen> aanmakenStenen(){
		List<Steen> stenen = new ArrayList<>();
		for(int i = 0; i<21; i++) {
			stenen.add(new Steen(1));
			stenen.add(new Steen(2));
			stenen.add(new Steen(3));
			stenen.add(new Steen(4));
			stenen.add(new Steen(5));
			stenen.add(new Steen(6));
		}
		stenen.add(new Steen(1));
	
	Collections.shuffle(stenen);
	return stenen;
	}
	
	public void bepalenVolgorde() {
		Collections.shuffle(spelers);
	}
	
	private void updateSpelerAanBeurt() {
		if(spelerAanBeurt+1 >= spelers.size())
			spelerAanBeurt = 0;
		else
			spelerAanBeurt++;
	}
	
	
	private void stenenUitdelen() {
		int pos = 0;
		for(Speler s : spelers) {
			if (pos == 0)
				for(int i = 0; i <3; i++) {
					neemSteen(s);
				}
			if (pos != 0)
				for(int i = 0; i <2; i++) {
					neemSteen(s);
				}
			pos++;
		}
	}
	
	public List<Speler> geefVolgorde(){
		return spelers;
	}
	
	public void neemSteen(Speler speler) {
		SecureRandom sr = new SecureRandom();
		speler.voegSteenToe(stenen.remove(sr.nextInt(stenen.size())));
	}
	
	public List<Steen> getStenen(Speler speler) {
		return eigenStenen = speler.getStenen();
	}
	
	public void updateTotaleSpeelkansen() {
		for(Speler speler : spelers) {
			speler.updateTotaleSpeelkansen();
		}
		
	}
	
	public boolean isEindeSpel() {
		boolean leeg = false;
		for(Speler speler : spelers) {
			if(speler.getStenen().isEmpty())
				leeg = true;
		}
		if(leeg)
			scoreblad.berekenScore();
		return leeg;
	}
	
	public void getBord() {
		bord.showSpelbord();
	}

	public void setSteen(int row, int column, int waarde) {
		bord.setSteen(row, column, waarde);
	}
		
	public void getScore() {
		scoreblad.getScore();
	}

}