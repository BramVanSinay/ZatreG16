package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FoutMelding extends Stage {
	
	public FoutMelding() {
		
		GridPane Pane = new GridPane();
		
		GridPane.getHalignment(Pane);
		GridPane.getValignment(Pane);
		
		Pane.setPadding(new Insets(10));
						
		Label lbTitle = new Label("FOUT");
		lbTitle.setFont(Font.font("Tahoma", FontWeight.BOLD,30));
		//this.add(lbTitle,1,1);
		
		Label lbOTitle = new Label("Je moet ouder zijn dan 6 jaar en de gebruikersnaam moet langer zijn dan 5 Characters");
		lbOTitle.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
		//this.add(lbOTitle,0,2);
		
		Button btnCancel = new Button("Back");
		//this.add(btnCancel, 1, 3);
	
		
		Pane.getChildren().addAll(lbTitle,lbOTitle,btnCancel);
		
		btnCancel.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
		
		
		Scene scene = new Scene(Pane);
		this.setScene(scene);
		
		
	}


}
