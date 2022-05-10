package domein;

public class ScoreLijn {
	
	private int aantalLijnen;
	private int x2;
	private int p10;
	private int p11;
	private int p12;
	private int bonus;
	private int totaal;
	
	public ScoreLijn(int x2, int p10, int p11, int p12, int bonus, int totaal) {
		setX2(x2);
		setP10(p10);
		setP11(p11);
		setP12(p12);
		setBonus(bonus);
		setTotaal(totaal);
	}
	
	private void setX2(int x2) {
		this.x2 = x2;
	}
	
	public int getX2() {
		return this.x2;
	}
	
	private void setP10(int p10){
		this.p10 = p10;
	}
	
	public int getP10() {
		return this.p10;
	}
	
	private void setP11(int p11) {
		this.p11 = p11;
	}
	
	public int getP11() {
		return this.p11;
	}

	private void setP12(int p12) {
		this.p12 = p12;
	}
	
	public int getP12() {
		return this.p12;
	}

	private void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return this.bonus;
	}

	private void setTotaal(int totaal) {
		this.totaal = totaal;
	}
	
	public int getTotaal() {
		return this.totaal;
	}

}