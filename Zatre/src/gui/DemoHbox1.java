package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DemoHbox1 extends Stage {
	
	public DemoHbox1() { 
		
		HBox box = new HBox();
		
		//Label lblTitle = new Label("Speel Kansen : ");
		
		//box.getChildren().addAll(lblTitle);
		
		Scene scene = new Scene(box);
		this.setScene(scene);
		
		
	}

}
