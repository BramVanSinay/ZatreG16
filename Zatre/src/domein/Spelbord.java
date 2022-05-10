package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import domein.Vak;

public class Spelbord {

	private int vakwaarde;
	private int AANTAL_VAKKEN = 193;
	private int AANTAL_STENEN = 121;
	private int AANTAL_STENEN_WAARDE_1 = 21;
	private int AANTAL_STENEN_WAARDE_2_TEM_6 = 20;
	private List<Vak> bord;
	public boolean steenKanLeggen;
	
	public Spelbord() {
		StartUp();
	}
	
	public void StartUp() {
		setUpBoard();
		showSpelbord();
	}
	
	public boolean isVakPlaceable(int row, int column) {
		return true;
	}
	
	public boolean isSteenwaardeCorrect(int steenwaarde) {
		return (0<steenwaarde<<7);
	}

	/** @param gameboard*/
	public List<Vak> setUpBoard() {  
		List<Vak> bord = new ArrayList<>();
		int column = 1, column2 = 13;
		for (int row=0; row<13; row++) {
			if(row<13) {
				bord.add(new Vak("G", row+1, column, 0));
				bord.add(new Vak("G", row+1, column2, 0));
			column++;
			column2--;
			}
			if(row<4) {
				bord.add(new Vak("X", row, 0, 0));
				bord.add(new Vak("X", 14-row, 0, 0));
				bord.add(new Vak("X", row, 14,0));
				bord.add(new Vak("X", 14-row, 14,0));
				bord.add(new Vak("X", 0, row,0));
				bord.add(new Vak("X", 0, 14-row,0));
				bord.add(new Vak("X", 14, 14-row,0));
			}
			if(row<3)
				bord.add(new Vak("X", 14, row,0));
		}
		bord.add(new Vak("G", 0, 6, 0));
		bord.add(new Vak("G", 0, 8, 0));
		bord.add(new Vak("G", 6, 0, 0));
		bord.add(new Vak("G", 6, 14, 0));
		bord.add(new Vak("G", 8, 0, 0));
		bord.add(new Vak("G", 8, 14, 0));
		bord.add(new Vak("G", 14, 5, 0));
		bord.add(new Vak("G", 14, 8, 0));
		
		bord.add(new Vak("X", 0, 7, 0));
		bord.add(new Vak("X", 7, 0, 0));
		bord.add(new Vak("X", 7, 14, 0));
		bord.add(new Vak("X", 14, 6, 0));
		bord.add(new Vak("X", 14, 7, 0));
		
//		for(int i = 0; i <15; i++) {
//			for(int e = 0; e<15; e++) {
//				bord.add(new Vak("W", i, e, 0));
//			}
//		}
		
		return this.bord = bord;
	
	}
	
	public void showSpelbord() {
		int space = 0;
		for(int i = 0; i <15; i++) {
			System.out.println();
			for(int e = 0; e<15; e++) {
				for(Vak v : bord) {
					if(v.getXCoordinaat()==i && v.getYCoordinaat()==e) {
						System.out.print(v.getWaarde());
						space = 0;
						break;
					}
//					else if(v.getXCoordinaat()==i && v.getYCoordinaat()==e && v.getKleur()=="G") {
//						System.out.print(v.getWaarde());
//						space = 0;
//						break;
//					}
//					else if (v.getXCoordinaat()==i && v.getYCoordinaat()==e && v.getWaarde()==0) {
//						System.out.print(v.getKleur());
//						space = 0;
//						break;	
//					}
					
					else
						space =1;
				}
				if (space == 1)
					System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	public boolean steenKanLeggen(int xCoordinaat, int yCoordinaat, int waarde) {
		for(Vak v : bord) {
			if(v.getWaarde()!=0 && ((xCoordinaat == v.getXCoordinaat()-1|| xCoordinaat == v.getXCoordinaat()+1 && yCoordinaat == v.getYCoordinaat()) ||
					(yCoordinaat == v.getYCoordinaat()-1 || yCoordinaat == v.getYCoordinaat()+1 && xCoordinaat == v.getXCoordinaat()))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean twelve(int xCoordinaat, int yCoordinaat, int waarde) {
		int value, total;
		for(int i = 0; i <15; i++) {
			total = 0;
			for(int e = 0; e<15; e++) {
				for(Vak v : bord) {
					if(v.getXCoordinaat() == i && v.getYCoordinaat() == e) {
						value = v.getWaarde();
						total = total + value;
					}
					if(total == 12 && xCoordinaat == v.getXCoordinaat()+1 && yCoordinaat == e)
						return false;
					else if(total == 12 && xCoordinaat != v.getXCoordinaat()+1)
						total = 0;
					else if (total <= 12 && total >=0)
						return true;
					
				}
			}
		}
		return false;
	}
	
	
	
	public void setBoard(String kleur, int xCoordinaat, int yCoordinaat, int waarde) {
		System.out.print("add");
		Vak v = (new Vak(kleur, xCoordinaat, yCoordinaat, waarde));
		bord.add(v);
	}

	/** @param kleur * @param xCoordinaat * @param yCoordinaat * @param steenwaarde*/
	public void setSteen( int xCoordinaat, int yCoordinaat, int waarde) {
		System.out.println("1");
		int i = 0, test = 0;
		for(Vak v : bord) {
			if(waarde>6 || waarde<1) {
				throw new IllegalArgumentException("De steenwaarde zit niet in het spel.");
			}
			else if (v.getXCoordinaat() == xCoordinaat && v.getYCoordinaat() == yCoordinaat && v.getKleur() == "X") {
				System.out.println("You can't change the value of this box.");
				test = 1;
				
			}
			else if (v.getXCoordinaat() == xCoordinaat && v.getYCoordinaat() == yCoordinaat && v.getKleur() == "G" && v.getWaarde()==0) {
				Vak b = (new Vak("G", yCoordinaat, xCoordinaat, waarde));
				System.out.println("2");
				bord.set(i, b);
				test = 1;
				break;
			}
			else if( v.getXCoordinaat() == xCoordinaat && v.getYCoordinaat() == yCoordinaat && v.getKleur() == "W"){
				System.out.println("Already a stone on it.");
			}
			i++;

		}
		if(test == 0) {
			System.out.println("4");
			Vak b = (new Vak("W", yCoordinaat, xCoordinaat, waarde));
			bord.add(b);
		}
	}
}