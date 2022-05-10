package domein;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.List;

public class Speler {

	private String gebruikersnaam;
	private int geboortejaar;
	private int totaleSpeelkansen;
	private int speelkansen;
	private List<Steen> stenen;
	
	public Speler(String gebruikersnaam, int geboortejaar, int totaleSpeelkansen) {
		stenen = new ArrayList<>();
		setGebruikersnaam(gebruikersnaam);
		setGeboortejaar(geboortejaar);
		setTotaleSpeelkansen(totaleSpeelkansen);
	}
	
	/** @param gebruikersnaam*/
	public void setGebruikersnaam(String gebruikersnaam) {
		if (gebruikersnaam == null || gebruikersnaam.trim().isEmpty())
			throw new IllegalArgumentException("Gebruikersnaam is niet ingevuld");
		else if (gebruikersnaam.length()<5)
			throw new IllegalArgumentException("Gebruikersnaam is te klein");		
		this.gebruikersnaam = gebruikersnaam;
	}
	
	public String getGebruikersnaam() {
		return this.gebruikersnaam;
	}
	
	/**  @param geboortejaar*/
	public void setGeboortejaar(int geboortejaar) {
		if(geboortejaar == 0)
			throw new IllegalArgumentException("Geboortejaar niet opgegeven of 0 ingegeven.");
		this.geboortejaar = geboortejaar;
	}
	
	public int getGeboortejaar() {
		return this.geboortejaar;
	}

	private void setTotaleSpeelkansen(int totaleSpeelkansen) {
		this.totaleSpeelkansen = totaleSpeelkansen;
	}
	

	public int getTotaleSpelkansen() {
		return this.totaleSpeelkansen;
	}
	

	public boolean gebruikersnaamLangGenoeg(String gebruikersnaam) {
		return gebruikersnaam.length() >= 5;
	}
	
	@SuppressWarnings("deprecation")
	public boolean leeftijdOudGenoeg(int geboortejaar) {
		int year, age;
        Date d=new Date();  
        year=d.getYear()+1900;  
        age = year - geboortejaar;
		return age >= 6;
	}
	
	public void updateTotaleSpeelkansen() {
		setTotaleSpeelkansen(totaleSpeelkansen + speelkansen);
	}
	

	public void voegSteenToe(Steen steen) {
		stenen.add(steen);
	}
	
//	public void removeSteen(int steenwaarde) {
//		stenen.remove(stenen.stream().filter(x->x.steenwaarde == steenwaarde).findFirst().get());
//	}
	
    public void removeSteen(int steenwaarde) {
        stenen.remove(stenen.stream().filter(x->x.getCijfer()==steenwaarde).findFirst().get());//.orElse(throw new Exception()));
    }
    
	public void verwijderSteen(Steen steen) {
		stenen.remove(steen);
	}
	
	
	public List<Steen> getStenen(){
		return stenen;
	}
	
}