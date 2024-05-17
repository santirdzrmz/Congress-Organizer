package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChairLoginControllers implements Initializable {
	@FXML
	private Button returnToMain;
	
	@FXML
	private Button loginChairButton;
	
	@FXML
	private TextField congressPasswordBox;
	
	@FXML
	private TextField congressNameBox;
	
	@FXML
	private Label errorMessage;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void returnToMainPressed(ActionEvent event) {
		application.Main.mainStage = (Stage)returnToMain.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene1);
		congressNameBox.setText("");
		congressPasswordBox.setText("");
		errorMessage.setText("");
	}
	
	public void loginChairButtonPressed(ActionEvent event) {
		errorMessage.setText("");
		if (congressNameBox.getText().equals("ORDEM") && congressPasswordBox.getText().equals("ORDEM20222023")) {
			application.Main.mainStage = (Stage)loginChairButton.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scene7);
			errorMessage.setText("");
		}
		else if(congressNameBox.getText().equals("ORDEM")) {
			errorMessage.setText("Password Incorrect. Try again. Hint: Congress name and school year");
		}
		
		else if(congressPasswordBox.getText().equals("ORDEM20222023")) {
			errorMessage.setText("Username Incorrect. Try again. Hint: Congress name");
		} 
		else {
			errorMessage.setText("Password and Username both incorrect.");
		}
		
	}

}
