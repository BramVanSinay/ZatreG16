package domein;

public class Steen implements Comparable<Steen> {
	
	private int cijfer;
	
	public Steen(int cijfer) {
		setCijfer(cijfer);
		
	}
	
	public int getCijfer() {
		return cijfer;
	}
	
	private void setCijfer(int cijfer) {
		this.cijfer = cijfer;
	}

	@Override
	public int compareTo(Steen o) {
		int cijferCpm = Integer.compare(cijfer, o.getCijfer());
		return cijferCpm;
	}
	
	@Override
	public String toString() {
		return String.format("%d", cijfer);
	}
}