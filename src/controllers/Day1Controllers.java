package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class Day1Controllers implements Initializable {
	@FXML
	private Button returnToMain;

	@FXML
	private Button updateButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button doneSchedule;
	
	@FXML
	private TextField activityTextField;

	@FXML
	private TextField materialsTextField;

	@FXML
	private TextField rolesTextField;

	@FXML
	private TextField timeTextField;

	@FXML
	private TextField classroomsTextField;
	
	@FXML
	private Label errorMessage;

	@FXML
	private TableView<Day> scheduleTable = new TableView<Day>();

	@FXML
	private TableColumn<Day, String> activityCol = new TableColumn<Day, String>("Activity");

	@FXML
	private TableColumn<Day, Integer> timeCol = new TableColumn<Day, Integer>("Time");

	@FXML
	private TableColumn<Day, String> materialsCol = new TableColumn<Day, String>("Materials");

	@FXML
	private TableColumn<Day, String> classroomsCol = new TableColumn<Day, String>("Classrooms");

	@FXML
	private TableColumn<Day, String> rolesCol = new TableColumn<Day, String>("Roles");

	private ObservableList<Day> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		List<Day> dataList = readDataFromCSV("Day1.csv");
		
		data.addAll(dataList);

		scheduleTable.setItems(data);
		
		activityCol.setCellValueFactory(new PropertyValueFactory<Day, String>("activity"));

		timeCol.setCellValueFactory(new PropertyValueFactory<Day, Integer>("time"));

		materialsCol.setCellValueFactory(new PropertyValueFactory<Day, String>("materials"));

		classroomsCol.setCellValueFactory(new PropertyValueFactory<Day, String>("classrooms"));

		rolesCol.setCellValueFactory(new PropertyValueFactory<Day, String>("roles"));

	}


	
	public void doneButtonPressed(ActionEvent event) {
		try {
            FileWriter writer = new FileWriter("Day1.csv");

            // Write the headers to the CSV file
            writer.write("Activity,Time,Materials,Classrooms,Roles\n");
            
            ObservableList<Day> activities = scheduleTable.getItems();

            // Write each object's data to a new row in the CSV file
            for (int i = 0; i < activities.size(); i++) {
            	Day day = activities.get(i);

                writer.write(day.getActivity() + ",");
                writer.write(day.getTime() + ",");
                writer.write(day.getMaterials() + ",");
                writer.write(day.getClassrooms() + ",");
                writer.write(day.getRoles() + "\n");
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
        	errorMessage.setText("An error has occured while writing the csv.");
            e.printStackTrace();
        }
		application.Main.mainStage = (Stage) returnToMain.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene1);
	}

	public void returnToMainPressed(ActionEvent event) {
		application.Main.mainStage = (Stage) returnToMain.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene4);
	}

	public void deletePressed(ActionEvent event) {
		int selectedID = scheduleTable.getSelectionModel().getSelectedIndex();
		scheduleTable.getItems().remove(selectedID);
	}

	public void updatePressed(ActionEvent event) {
		try {
		Day day = new Day(activityTextField.getText(), Integer.parseInt(timeTextField.getText()),
				materialsTextField.getText(), classroomsTextField.getText(), 
				rolesTextField.getText());
		ObservableList<Day> activities = scheduleTable.getItems();
		activities.add(day);
		scheduleTable.setItems(activities);
		} catch (Exception e) {
			errorMessage.setText("Check your inputs. Time must be set as an integer");
		}
	}
	
	private List<Day> readDataFromCSV(String csvFile) {
		List<Day> dataList = new ArrayList<Day>();
		BufferedReader reader = null;
		String line = "";

		try {
			reader = new BufferedReader(new FileReader(csvFile));
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				Day day = new Day(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4]);
				dataList.add(day);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dataList;
	}

}
