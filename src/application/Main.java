package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Parent root;
	public static Parent second;
	public static Parent third;
	public static Parent fourth;
	public static Parent fifth;
	public static Parent sixth;
	public static Parent seventh;
	public static Parent eighth;
	public static Parent ninth;
	public static Parent tenth;
	public static Scene scene1;
	public static Scene scene2;
	public static Scene scene3;
	public static Scene scene4;
	public static Scene scene5;
	public static Scene scene6;
	public static Scene scene7;
	public static Scene scene8;
	public static Scene scene9;
	public static Scene scene10;
	public static Stage mainStage;
	public static Parent popupOne;
	public static Parent popupTwo;
	public static Parent popupThree;
	public static Scene scheduleOne;
	public static Scene scheduleTwo;
	public static Scene scheduleThree;
	public void start(Stage primaryStage) {
		try {
			root= FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			second= FXMLLoader.load(getClass().getResource("/application/Participants.fxml"));
			third= FXMLLoader.load(getClass().getResource("/application/Staff.fxml"));
			fourth= FXMLLoader.load(getClass().getResource("/application/DaySelector.fxml"));
			fifth= FXMLLoader.load(getClass().getResource("/application/Verifier.fxml"));
			sixth= FXMLLoader.load(getClass().getResource("/application/ChairLogin.fxml"));
			seventh= FXMLLoader.load(getClass().getResource("/application/SetParameters.fxml"));
			eighth= FXMLLoader.load(getClass().getResource("/application/Day1.fxml"));
			ninth= FXMLLoader.load(getClass().getResource("/application/Day2.fxml"));
			tenth= FXMLLoader.load(getClass().getResource("/application/Day3.fxml"));
			popupOne= FXMLLoader.load(getClass().getResource("/application/PopopOne.fxml"));
			popupTwo= FXMLLoader.load(getClass().getResource("/application/PopupTwo.fxml"));
			popupThree= FXMLLoader.load(getClass().getResource("/application/PopupThree.fxml"));
			scene1 = new Scene(root);
			scene2 = new Scene(second);
			scene3  = new Scene (third);
			scene4  = new Scene (fourth);
			scene5 = new Scene (fifth);
			scene6 = new Scene (sixth);
			scene7 = new Scene (seventh);
			scene8 = new Scene (eighth);
			scene9 = new Scene (ninth);
			scene10 = new Scene (tenth);
			scheduleOne = new Scene (popupOne);
			scheduleTwo = new Scene (popupTwo);
			scheduleThree = new Scene (popupThree);

			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
