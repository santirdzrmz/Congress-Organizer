package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DaySelectorControllers implements Initializable {
	@FXML
	private Button Day2Button;
	
	@FXML
	private Button Day1Button;
	
	@FXML
	private Label errorMessage;
	
	@FXML
	private Button Day3Button;
	
	@FXML
	private Button returnToMainButton;
	
	@FXML
	private Label optionLabel;

	
	@FXML
	private Rectangle rectangleFiller;
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void OpenDay1(ActionEvent event) {

			application.Main.mainStage = (Stage)Day1Button.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scene8);
		
		
		
	}
	public void OpenDay2(ActionEvent event) {
		if (SetParametersControllers.numberOfDays > 1) {
			application.Main.mainStage = (Stage)Day2Button.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scene9);
		} else {
			errorMessage.setText("Please select the correct number of days. "
					+ "There is currently only one day selected.");
		}
	}
	public void OpenDay3(ActionEvent event) {
		if (SetParametersControllers.numberOfDays > 2) {
			application.Main.mainStage = (Stage)Day3Button.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scene10);
		} else {
			errorMessage.setText("Please select the correct number of days. "
					+ "There is currently only two days selected.");
		}
	}
	public void returnToMain(ActionEvent event) {
		application.Main.mainStage = (Stage) returnToMainButton.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene1);
	}

}
