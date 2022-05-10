package domein;

import java.util.ArrayList;


public class scoreblad{
	
	
	private ArrayList<String> listx2 = new ArrayList<>();
	private ArrayList<String> list10 = new ArrayList<>();
	private ArrayList<String> list11 = new ArrayList<>();
	private ArrayList<String> list12 = new ArrayList<>();
	private ArrayList<Integer> listbonus = new ArrayList<>();
	private ArrayList<Integer> listtotaal = new ArrayList<>();	
	private int x = 1;
	private int eindtotaal = 0;
	private String space=" ";
	private String tot="Score";
	private int totaal = 0;
	int x2=0, l10=0,l11=0,l12=0;  
	private int bonus = 0; 
	
	public void Scoreblad(){	
			int x2=0, l10=0,l11=0,l12=0; 
			
			do {
			// if om bonus om de 4 beurten te verhogen
			if(x<=4){
				bonus= 3;
				listbonus.add(bonus);
			}
			if(x>4&&x<=8){
				bonus = 4;
				listbonus.add(bonus);
			}
			if(x>8&&x<=12){
				bonus= 5;
				listbonus.add(bonus);
				}
			if(x>12&&x<=16){
				bonus= 6;
				listbonus.add(bonus);
				}	
			// if bij waarde 1 keer voorkomend
			if (l10==10) {
				list10.add("x");
			}
			 if (l11==11){
			 list11.add("x");
			 }
			 if (l12==12)
			 {
			 list12.add("x");
			 }
			 if (l10==20) {
					list10.add("xx");
				}
				 if (l11==22){
				 list11.add("xx");
				 }
				 if (l12==24)
				 {
				 list12.add("xx");
				 }
				 // geen waarde
				 if (l10 <10||l10>10)
				 {
				 list10.add(" ");
				}
				 if (l11<11||l11>11)
				 {
					 list11.add(" ");
					 }
				 if (l12<12||l12>12)
					 {
						 list12.add(" ");
						 }
			 // een keer
			 if (x2==1) {
				 listx2.add("x");
		}
			 //meerdere keer
			 if (x2==2) {
				 listx2.add("xx");
		}
			 if (x2<1)
				{
				listx2.add(" ");
				}
			 x++;
			}while(x<=16);
	}

public void  berekenScore() {
	if (list10.contains("x")) {
	 totaal = totaal + 1;
	 }
	 if (list10.contains("xx")){
	 totaal = totaal + 2;
	 }
	 if (list11.contains("x")){
	 totaal = totaal + 2;
	 }
	 if (list11.contains("xx")) {
		 totaal = totaal + 4;
		 }
	 if (list12.contains("x")){
		 totaal = totaal + 4;
		 }
	 if (list12.contains("xx")){
		 totaal = totaal + 8;
		 }
	 if(list10.contains("x")||list10.contains("xx")&&list11.contains("x")||list11.contains("xx")&&list12.contains("x")||list12.contains("xx")&&listx2.contains("x")||listx2.contains("xx")) {
		 totaal = totaal + bonus;
	 }
	 if (x2==1) {
			 totaal = totaal + 1;}
	 

	 if (x2==1){
			 totaal = totaal + 2;}
	 listtotaal.add(totaal);
		eindtotaal = eindtotaal + totaal; 
}

public void getScore (){
	System.out.println("[x2][l0(1pt)][l1(2pt)][l2(4pt)][bonus][totaal]");
 for (int i=0;i<listx2.size();i++) {
	 System.out.printf("%s%s\t%s\t%s\t%s\t%d\t%d",space,listx2.get(i),list10.get(i),list11.get(i),list12.get(i),listbonus.get(i),listtotaal.get(i));
    	 System.out.println();
 }
System.out.printf("\t\t\t\t%s\t%d",tot,eindtotaal);
}

} 

