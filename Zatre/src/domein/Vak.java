package domein;

import domein.Spelbord;


public class Vak {
	
	private String kleur;
	private int xCoordinaat;
	private int yCoordinaat;
	private int waarde;
	
	public Vak(String kleur, int xCoordinaat, int yCoordinaat, int waarde) {
		setKleur(kleur);
		setXCoordinaat(xCoordinaat);
		setYCoordinaat(yCoordinaat);
		setWaarde(waarde);
	}

	private void setKleur(String kleur) {
		this.kleur = kleur;
	}
	
	public String getKleur(){
		return this.kleur;
	}


	private void setXCoordinaat(int xCoordinaat) {
		this.xCoordinaat = xCoordinaat;
	}
	
	public int getXCoordinaat() {
		return this.xCoordinaat;
	}


	private void setYCoordinaat(int yCoordinaat) {
		this.yCoordinaat = yCoordinaat;
	}
	
	public int getYCoordinaat() {
		return this.yCoordinaat;
	}
	
	private void setWaarde(int waarde) {
		this.waarde = waarde;
	}
	
	public int getWaarde() {
		return this.waarde;
	}
}