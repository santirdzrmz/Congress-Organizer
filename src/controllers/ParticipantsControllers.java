package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ParticipantsControllers implements Initializable {
	@FXML
	private Button mainMenuButton;

	@FXML
	private Button setID;

	@FXML
	private Button searchID;

	@FXML
	private TextField textBox;

	@FXML
	private Label errorMessage;

	@FXML
	private Label participantIdentificationLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setTheID(ActionEvent event) {
		participantIdentificationLabel.setText(null);
		errorMessage.setText(null);
		String participantNumber = "null";
		try (BufferedReader reader = new BufferedReader(new FileReader("Participantes.csv"))) {
			String line = reader.readLine();
			while ((line != null)) {
				String[] cells = line.split(",");
				if (cells.length < 2) {
					break;
				} 
				line = reader.readLine(); 
			}
		} catch (IOException e) {
			errorMessage.setText("An error has occurred while reading the csv. Please contact a supervisor");
			e.printStackTrace();
		}
	

		if (SetParametersControllers.numberOfParticipants < ParticipantsControllers.CsvRowCount()) {
			participantIdentificationLabel.setText("Participant Limit Reached");
		}else if (textBox.getText() == null) {
			errorMessage.setText("Please input your name.");
		}
		else {
			BufferedWriter bufferedWriter;
			participantNumber = StaffControllers.generate();
			try {
				bufferedWriter = new BufferedWriter(new FileWriter("Participantes.csv", true));
				bufferedWriter.write(participantNumber);
				bufferedWriter.write(",");
				bufferedWriter.write(textBox.getText());
				bufferedWriter.write("\n");

				bufferedWriter.close();
			} catch (IOException e) {
				errorMessage.setText("An error has occurred. Please retry the program.");
				e.printStackTrace();
			}
			participantIdentificationLabel.setText("Your ID is: " + participantNumber);
			textBox.setText(null);
		}
	}

	public void searchTheID(ActionEvent event) {
		participantIdentificationLabel.setText(null);

		try {

			BufferedReader reader = new BufferedReader(new FileReader("Participantes.csv"));

			String line = reader.readLine();
			boolean nameFound = false;

			while (line != null) {
				String[] data = line.split(",");
				for (int i = 0; i < data.length; i++) {
					if (data[i].equals(textBox.getText())) {
						participantIdentificationLabel.setText("Your ID is: " + data[0]);
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
	public static int CsvRowCount(){

		int rowCount = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader("Participantes.csv"))) {
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
}
