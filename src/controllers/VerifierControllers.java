package controllers;

import java.net.URL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerifierControllers implements Initializable {
	@FXML
	private Button returnToMain;

	@FXML
	private TextField textBox;

	@FXML
	private Label errorMessage;

	@FXML
	private Label roleLabel;

	@FXML
	private Button scheduleButton;

	@FXML
	private Button dayOne;

	@FXML
	private Button dayTwo;

	@FXML
	private Button dayThree;

	@FXML
	private Label idLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void returnToMainPressed(ActionEvent event) {
		application.Main.mainStage = (Stage) returnToMain.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene1);
	}

	public void dayOnePressed(ActionEvent event) {
		application.Main.mainStage = (Stage) dayOne.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scheduleOne);
	}

	public void dayTwoPressed(ActionEvent event) {
		if (SetParametersControllers.numberOfDays > 1) {
			application.Main.mainStage = (Stage) dayOne.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scheduleTwo);
		} else {
			errorMessage.setText("Sorry! You have selected a day that is not available");
		}
	}

	public void dayThreePressed(ActionEvent event) {
		if (SetParametersControllers.numberOfDays > 2) {
			application.Main.mainStage = (Stage) dayOne.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scheduleThree);
		} else {
			errorMessage.setText("Sorry! You have selected a day that is not available");
		}
	}

	public void checkSchedulePressed(ActionEvent event) {
		idLabel.setText("Your ID is:");
		roleLabel.setText("Your role is:");
		try {

			BufferedReader csvReader = new BufferedReader(new FileReader("Staff.csv"));
			String userInput = textBox.getText();
			// Loop through each line of the CSV file
			String row;
			while ((row = csvReader.readLine()) != null) {

				// Split the row into columns
				String[] columns = row.split(",");

				// Check if the second column contains the user input
				if (columns.length > 1 && columns[1].equals(userInput)) {

					// If the input is found, print out the first column of the same row
					idLabel.setText("Found: " + columns[0]);
					roleLabel.setText("Found: " + columns[2]);
					csvReader.close();
					return;

				}

			}
			errorMessage.setText("User not found, please retry.");
			csvReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}