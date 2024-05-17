package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StaffControllers implements Initializable {
	@FXML
	private Button mainMenuButton;

	@FXML
	private TextField roleTextBox;

	@FXML
	private Label errorMessage;

	@FXML
	private Button setID;

	@FXML
	private Button searchID;

	@FXML
	private TextField textBox;

	@FXML
	private Label staffIdentificationLabel;

	@FXML
	private CheckBox randomRoleButton;

	private boolean randomActivation = false;

	private int staffRoleInstance = 1;

	private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	private static final SecureRandom random = new SecureRandom();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setTheID(ActionEvent event) {
		boolean noRole = false;
		randomActivation = false;
		staffIdentificationLabel.setText(null);
		errorMessage.setText(null);
		String staffNumber = "null";

		try (BufferedReader reader = new BufferedReader(new FileReader("Staff.csv"))) {
			String line = reader.readLine();
			while ((line != null)) {
				String[] cells = line.split(",");
				if (cells.length < 3) {
					break;
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			errorMessage.setText("An error has occurred while reading the csv. Please contact a supervisor.");
			e.printStackTrace();
		}
		if (SetParametersControllers.numberOfStaff < StaffControllers.CsvRowCount()) {
			staffIdentificationLabel.setText("Staff Limit Reached");
		} else if (roleTextBox.getText() == null) {
			errorMessage.setText("Please fill in the role text or select a random role.");
		} else if (textBox.getText() == null) {
			errorMessage.setText("Please input your name.");
		} else if (staffRoleInstance < 1 || staffRoleInstance > SetParametersControllers.numberOfRoles) {
			errorMessage.setText("Staff Role input is not in line with the parameters.  Between 1 and"
					+ SetParametersControllers.numberOfRoles);
		} else {
			try {
				staffRoleInstance = Integer.parseInt(roleTextBox.getText());
			} catch (Exception e) {
				errorMessage.setText("Input an integer. Revise your role number.");
				e.printStackTrace();
				noRole = true;
			}
			BufferedWriter bufferedWriter;
			staffNumber = StaffControllers.generate();
			if (!noRole || randomRoleButton.isSelected()) {
			errorMessage.setText(null);
			try {
				bufferedWriter = new BufferedWriter(new FileWriter("Staff.csv", true));
				bufferedWriter.write(staffNumber);
				bufferedWriter.write(",");
				bufferedWriter.write(textBox.getText());
				bufferedWriter.write(",");
				if (randomRoleButton.isSelected()) {
					staffRoleInstance++;
					if (staffRoleInstance > SetParametersControllers.numberOfRoles) {
						staffRoleInstance = 1;
					}
					bufferedWriter.write(Integer.toString(staffRoleInstance));
				} else {
						bufferedWriter.write(roleTextBox.getText());
				}
				bufferedWriter.write("\n");

				bufferedWriter.close();
			} catch (IOException e) {
				errorMessage.setText("An error has occurred. Please retry the program.");
				e.printStackTrace();
			}
			staffIdentificationLabel.setText("Your ID is: " + staffNumber);
			textBox.setText(null);
			}
		}
	}

	public void searchTheID(ActionEvent event) {
		staffIdentificationLabel.setText(null);
		try {

			BufferedReader reader = new BufferedReader(new FileReader("Staff.csv"));

			String line = reader.readLine();
			boolean nameFound = false;
			while (line != null) {
				String[] data = line.split(",");
				for (int i = 0; i < data.length; i++) {
					if (data[i].equals(textBox.getText())) {
						staffIdentificationLabel.setText("Your ID is: " + data[0]);
						nameFound = true;
						break;
					}
				}
				line = reader.readLine();

			}
			reader.close();
			if (!nameFound) {
				errorMessage.setText("Name not found.");
			}
		} catch (Exception e) {
			errorMessage.setText("An error has occured. Please retry the program.");
		}

	}

	public static int CsvRowCount() {

		int rowCount = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader("Staff.csv"))) {
			while (reader.readLine() != null) {
				rowCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	public void returnToMain(ActionEvent event) {
		application.Main.mainStage = (Stage) mainMenuButton.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene1);
	}

	public static String generate() {
		StringBuilder stringBuilder = new StringBuilder(6);
		for (int i = 0; i < 6; i++) {
			stringBuilder.append(ALPHANUMERIC_CHARACTERS.charAt(random.nextInt(ALPHANUMERIC_CHARACTERS.length())));
		}
		return stringBuilder.toString();
	}

}
