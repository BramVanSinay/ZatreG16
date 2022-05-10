package persistenties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import domein.SpelerRepository;
import cui.Applicatie;
import domein.Speler;

public class SpelerMapper {   //5
	
	public void geefSpelerIn(String gebruikersnaam, int geboortejaar, int speelkansen) {
    
		
	Connection con = null;
	PreparedStatement stmt = null;
	
    
	try {
		con = DriverManager.getConnection(Connectie.JDBC_URL);
		stmt = con.prepareStatement("INSERT INTO `ID373511_Zatre`.`speler`(spelerID,naam,geboorteJaar,speelkansen) VALUES (?,?,?,?)");
		stmt.setString(1, null);
		stmt.setString(2, gebruikersnaam);
        stmt.setInt(3, geboortejaar);
        stmt.setString(4, "3");
		stmt.executeUpdate();
    //   con.commit();
		System.out.println("f");
	} catch (Exception e) {
        e.printStackTrace();
  
        // zorgen ervoor dat als er errors zijn dat statement en de connection geclosed worden om de resources vrij te houden
	} finally {
        if (stmt != null) {
            try {
               stmt.close();
            } catch (SQLException ex) {
            }
        }
        if (con != null) {
            try {
               con.close();                    
            } catch (SQLException ex) {
            }
        }
    
	}
}

	
	//haal speler uit de db
	
	public Speler geefSpeler(String gebruikersnaam, int geboortejaar) {     // speler vervangen door String geeft werkende return op einde met "return zoekgn"
		Connection con = null;
        Statement stmt2 = null;
        Speler speler = null;
        String gebruikersnaam_db=null;
        int geboortejaar_db;
        int speelkansen_db = 0;
        
//        System.out.println("Geef een te zoeken gebruikersnaam op:");
//
//        Scanner input = new Scanner(System.in);
//        String zoekgn = input.next();
//        
//        System.out.println("Geef een te zoeken geboortejaar op:");
//        
//        Scanner input2 = new Scanner(System.in);
//        String zoekgj = input.next();
	
            try {
            	con = DriverManager.getConnection(Connectie.JDBC_URL);
            	stmt2 = con.createStatement();
            	String output = "SELECT * FROM `ID373511_Zatre`.`speler` WHERE `naam`= '"+gebruikersnaam+"' AND `geboortejaar`= '" +geboortejaar+"'";
            	ResultSet rs = stmt2.executeQuery(output);
            	while (rs.next()) {
//            		System.out.println("gebruikersnaam: " + rs.getString(2));
//            		System.out.println("geboortejaar: " + rs.getInt(3));
//            		System.out.println("speelkansen: " + rs.getInt(4));
            		gebruikersnaam_db = rs.getString(2);
            		geboortejaar_db = rs.getInt(3);
            		speelkansen_db = rs.getInt(4);
            		speler = new Speler(gebruikersnaam_db,geboortejaar_db, speelkansen_db);
            		break;
            	}
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            if(gebruikersnaam_db == null) {
            	throw new IllegalArgumentException("Gebruiker bestaat niet");
            }
            return speler;
            }

    public void spelersInDB(String gebruikersnaam, int geboortejaar) {
    
    	Connection con = null;
        Statement stmt3 = null;
        
        try {
    		con = DriverManager.getConnection(Connectie.JDBC_URL);
    		stmt3 = con.createStatement();
    		String output2 = "SELECT * FROM `ID373511_Zatre`.`speler`";
    		ResultSet rs2 = stmt3.executeQuery(output2);
    		System.out.printf("%10s %10s %10s%n", "Gebruikersnaam", "Geboortejaar", "speelkansen");
    		while (rs2.next()) {
    			
    			System.out.printf("%10s %10s %10s%n", rs2.getString(2), rs2.getInt(3), rs2.getInt(4));
    		}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
}
    
    public void updateTotaleSpeelkansen(String gebruikersnaam, int geboortejaar, int totaleSpelkansen) {
    			
    		totaleSpelkansen = 696969420;
    		gebruikersnaam = "speler2";
    		geboortejaar = 2000;
    		try(Connection con = DriverManager.getConnection(Connectie.JDBC_URL);
    				PreparedStatement query = con.prepareStatement("UPDATE `ID373511_Zatre`.`speler` SET speelkansen = ? WHERE naam = ? AND geboortejaar = ?")) {
    			query.setString(2, gebruikersnaam);
    			query.setInt(3, geboortejaar);
    			query.setInt(1, totaleSpelkansen);
    			query.executeUpdate();
    		} catch (SQLException ex) {
    			throw new RuntimeException(ex);
    }
}
}