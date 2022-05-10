package cui;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class ZatreApplicatieJM {
	
	static String myGebruikersnaam() {
		Scanner input = new Scanner(System.in);
		String gebruikersnaam;
		System.out.print("Geef een gebruikersnaam in: ");
		gebruikersnaam = input.nextLine();
		return gebruikersnaam;
	}
	
    public static int getAge() {
		int year, age;
        Scanner scanner = new Scanner(System.in);  	
		System.out.printf("%nGeef uw geboortejaar in: ");
		int geboortejaar = scanner.nextInt();
        Date d=new Date();  
        year=d.getYear()+1900;  
        age = year - geboortejaar;
        return age;
    
	}
	

	public static void main(String[] args) {
		
		String naam;
		long chart = 0;
		int leeftijd = 0;
		do {
		naam = myGebruikersnaam();
		long totalCharacters = naam.chars().filter(ch -> ch != ' ').count();
		chart = totalCharacters;
		if (chart < 6)
			System.out.printf("De gebruikersnaam is niet lang genoeg.");
		
		else {
			System.out.printf("Gebruikersnaam is %s%n",naam);
			do {
			leeftijd = getAge(); 
			if(leeftijd<6)
				System.out.printf("Leeftijd is te klein, %d jaar oud.", leeftijd);
			}while(leeftijd<6);
		}
		
		} while(chart < 6); 
		
		System.out.printf("U bent succesvol gevalideert met gebruikersnaam %s en een leeftijd van %d.", naam, leeftijd);
		
		// Array
		String Usernames[];
		Usernames = new String[10];
		
	    for (int i = 0; i < Usernames.length; i++) {
	    	System.out.println(Usernames[i] + " ");
	       }
		
     }
 
}