package gui;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class loginScherm extends GridPane{

	public loginScherm() {
		
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
	    Date date = new Date();  
		
		DemoHbox1 hbox1 = new DemoHbox1();
		FoutMelding FM = new FoutMelding();
				
		this.setAlignment(Pos.CENTER);
		this.setHgap(16);
		this.setVgap(16);
		
		Label lbTitle = new Label("Zatre");
		lbTitle.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
		this.add(lbTitle, 0, 0, 2, 1);
		
		Label lbUsername = new Label("Gebruikersnaam");
		this.add(lbUsername, 0, 1);

		
		TextField txtUsername = new TextField();
		this.add(txtUsername, 1, 1);

		Label lbPassword = new Label("Geboortejaar");
		this.add(lbPassword, 0, 2);
		
		TextField txtPassword = new TextField();
		this.add(txtPassword, 1, 2);
		
		Button btnHBox1 = new Button("Inloggen");
		this.add(btnHBox1, 0, 3);
		
		btnHBox1.setOnAction(evt -> {
			if (Integer.parseInt(txtPassword.getText()) > 2016) {
				FM.setTitle("Fout");
				FM.show();
			}
			else {
				hbox1.setTitle("Zatre");
				hbox1.show();
			}
			
		});
	
		
		Button btnCancel = new Button("Quit");
		this.add(btnCancel, 1, 3);
		
		btnCancel.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
		
		setHalignment(btnCancel, HPos.RIGHT);
		
		
		
		
	}
	
	private void cancelBtnPusched(ActionEvent event) {
		System.out.println("Cancel button geklikt");
	}
	
	
}


