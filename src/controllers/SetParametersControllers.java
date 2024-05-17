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

public class SetParametersControllers implements Initializable {

	@FXML
	private Button returnToMain;
	@FXML
	private Button doneButton;
	@FXML
	private TextField daysText;
	@FXML
	private TextField numberStaffText;
	@FXML
	private TextField rolesText;
	@FXML
	private TextField numberParticipantsText;
	@FXML
	private Label errorMessage;

	public static int numberOfDays = 0;

	public static int numberOfRoles = 0;

	public static int numberOfStaff = 0;

	public static int numberOfParticipants = 0;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void returnToMainPressed(ActionEvent event) {
		application.Main.mainStage = (Stage)returnToMain.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene1);
	}
	public void doneButtonPressed(ActionEvent event) {
		String days =daysText.getText();
		String roles = rolesText.getText();
		String staff = numberStaffText.getText();
		String participants = numberParticipantsText.getText();
		try {
			if (days.equalsIgnoreCase("")) {
				errorMessage.setText("Please fill days needed");
			}
			else if (roles.equalsIgnoreCase("")){
				errorMessage.setText("Please fill in the maximum number of roles");
				
			}
			else if (staff.equalsIgnoreCase("")) {
				errorMessage.setText("Please fill in maximum number of staff");
				
			}
			else if (participants.equalsIgnoreCase("")) {
				errorMessage.setText("Please fill in maximum number of participants");
				
			} 
			else if (Integer.parseInt(daysText.getText())<1 || 3<Integer.parseInt(daysText.getText())) {
				errorMessage.setText("Please fill in days within the range");
			
			} 
			else if (Integer.parseInt(rolesText.getText())<1 || 4<Integer.parseInt(rolesText.getText())) {
				errorMessage.setText("Please fill in a number of roles within the range");
	
			}
			else if (Integer.parseInt(numberStaffText.getText())<1 || 50<Integer.parseInt(numberStaffText.getText())) {
				errorMessage.setText("Please fill in number of staff within the range");

			}
			else if (Integer.parseInt(numberParticipantsText.getText())<1 || 100<Integer.parseInt(numberParticipantsText.getText())) {
				errorMessage.setText("Please fill in number of participants within the range");
				
			}
			else {
				numberOfDays = Integer.parseInt(daysText.getText());
				numberOfRoles = Integer.parseInt(rolesText.getText());
				numberOfStaff = Integer.parseInt(numberStaffText.getText());
				numberOfParticipants = Integer.parseInt(numberParticipantsText.getText());
				
				application.Main.mainStage = (Stage)returnToMain.getScene().getWindow();
				application.Main.mainStage.setScene(application.Main.scene1);
			}
		}
		 catch (Exception e) {
			errorMessage.setText("An error has occured, please revise your inputs.");
			e.printStackTrace();
		}
		
	}



}
