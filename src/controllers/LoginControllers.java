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

public class LoginControllers implements Initializable {
	@FXML
	private Button ScheduleButton;
	
	@FXML
	private Button StaffButton;
	
	@FXML
	private Label errorMessage;
	
	@FXML
	private Button ParticipantsButton;
	
	@FXML
	private Button VerifyButton;
	
	@FXML
	private Label chairOnlyLabel;
	
	@FXML
	private Label optionLabel;
	
	@FXML
	private ImageView imageView;
	
	@FXML
	private Rectangle rectangleFiller;
	
	@FXML
	private Button ChairLoginButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void OpenParticipantsTab(ActionEvent event) {
		if (SetParametersControllers.numberOfDays != 0) {
			application.Main.mainStage = (Stage)ParticipantsButton.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scene2);
		} else {
			errorMessage.setText("Please fill out the parameters first");
		}
	}
	public void OpenScheduleTab(ActionEvent event) {
		if (SetParametersControllers.numberOfDays != 0) {
			application.Main.mainStage = (Stage)ScheduleButton.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scene4);
		} else {
			errorMessage.setText("Please fill out the parameters first");
		}
	}
	public void OpenStaffTab(ActionEvent event) {
		if (SetParametersControllers.numberOfDays != 0) {
			application.Main.mainStage = (Stage)StaffButton.getScene().getWindow();
			application.Main.mainStage.setScene(application.Main.scene3);
		} else {
			errorMessage.setText("Please fill out the parameters first");
		}
	}
	public void OpenVerifyTab(ActionEvent event) {
		application.Main.mainStage = (Stage)VerifyButton.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene5);
		errorMessage.setText("");
	}
	public void OpenChairLogin(ActionEvent event) {
		application.Main.mainStage = (Stage)ChairLoginButton.getScene().getWindow();
		application.Main.mainStage.setScene(application.Main.scene6);
		errorMessage.setText("");
	}

}
