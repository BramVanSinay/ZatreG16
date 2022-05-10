package domein;
import java.util.ArrayList;
import java.util.Scanner;


public class test_scoreblad{
	
public static void main(String[] args) {

		
		ArrayList<String> listx2 = new ArrayList<>();
		 ArrayList<String> list10 = new ArrayList<>();
		ArrayList<String> list11 = new ArrayList<>();
		 ArrayList<String> list12 = new ArrayList<>();
		 ArrayList<Integer> listbonus = new ArrayList<>();
		ArrayList<Integer> listtotaal = new ArrayList<>();	
		Scanner sc  = new Scanner(System.in);
		 int x = 1;
		 int eindtotaal = 0;
		 String space=" ";
		 String tot="Score";
		 int totaal = 0;
		 //System.out.println("[x2][l0(1pt)][l1(2pt)][l2(4pt)][bonus][totaal]");
		 
		 
			do {			
			int x2=0, l10=0,l11=0,l12=0; 
			int bonus = 1;
			totaal = 0;
			
			System.out.print("x2:");
		    x2=sc.nextInt();
			System.out.print("10pnt:");
			l10=sc.nextInt();
			System.out.print("11pnt:");
			l11=sc.nextInt();
			System.out.print("12pnt:");
			l12=sc.nextInt();
		
			
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
			if (l10==1) {
				list10.add("x");
			 totaal = totaal + 1;}

			 if (l11==1){
			 list11.add("x");
			 totaal = totaal + 2;}

			 if (l12==1)
			 {
			 list12.add("x");
			 totaal = totaal + 4;}

			 // if bij waarde meer dan een keer
			 if (l10==2) {
					list10.add("xx");
				 totaal = totaal + 2;}

				 if (l11==2){
				 list11.add("xx");
				 totaal = totaal + 4;}

				 if (l12==2)
				 {
				 list12.add("xx");
				 totaal = totaal + 8;}

				 // geen waarde
				 if (l10 < 1)
				 {
				 list10.add(" ");
				}
				 if (l11<1)
				 {
					 list11.add(" ");
					 }
				 if (l12<1)
					 {
						 list12.add(" ");
						 }
				 //bonus of niet
				 if(l10==1||l10==2&&l11==1||l11==2&&l12==1||l12==2&&x2==1||x2==2) {
					 totaal = totaal + bonus;
				 }
			
			 // een keer
			 if (x2==1) {
				 listx2.add("x");
				 totaal = totaal * 2;
		}

			 //meerdere keer
			 if (x2==2) {
				 listx2.add("xx");
				 totaal = totaal * 4;
		}

			 if (x2<1)
				{
				listx2.add(" ");
				}
			listtotaal.add(totaal);
			eindtotaal = eindtotaal + totaal;
			

			
			 x++;
			}while(x<=5);
			 System.out.println("[x2][l0(1pt)][l1(2pt)][l2(4pt)][bonus][totaal]");
			 for (int i=0;i<listx2.size();i++) {
				 System.out.printf("%s%s\t%s\t%s\t%s\t%d\t%d",space,listx2.get(i),list10.get(i),list11.get(i),list12.get(i),listbonus.get(i),listtotaal.get(i));
			    	 System.out.println();
				
			 }
		System.out.printf("\t\t\t\t%s\t%d",tot,eindtotaal);
		sc.close();
}
	
		
		 
		 
		
		
	}
