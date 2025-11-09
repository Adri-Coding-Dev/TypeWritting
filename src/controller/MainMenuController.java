
package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class MainMenuController {
	@FXML
	private ComboBox<String> durationBox;
	
	@FXML
	public void initialize() {
		durationBox.getItems().addAll("30 segundos","1 minuto", "2 minutos", "3 minutos");
		durationBox.getSelectionModel().selectFirst();
	}
	
	@FXML
	public void onStartGame(ActionEvent event) {
		try {
			int seconds = switch (durationBox.getValue()) {
			case "1 minuto" -> 60;
			case "2 minutos" -> 120;
			case "3 minutos" -> 180;
 			default -> 30;
			};
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/game.fxml"));
			Scene scene = new Scene(loader.load());
			GameController controller = loader.getController();
			controller.setGameTime(seconds);
			
			Stage stage = (Stage) durationBox.getScene().getWindow();
			stage.setScene(scene);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void onExit(ActionEvent event) {
		Stage stage = (Stage) durationBox.getScene().getWindow();
		stage.close();
	}
}
