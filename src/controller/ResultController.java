package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.GameStats;

public class ResultController {
	@FXML private Label wpmLabel;
    @FXML private Label accuracyLabel;
    @FXML private Label correctLabel;
    @FXML private Label wrongLabel;

    private GameStats stats;

    public void setResults(GameStats stats) {
        this.stats = stats;
        wpmLabel.setText(String.format("Velocidad: %.1f PPM", stats.getWpm()));
        accuracyLabel.setText(String.format("Precisión: %.1f%%", stats.getAccuracy()));
        correctLabel.setText("Aciertos: " + stats.getCorrectWords());
        wrongLabel.setText("Errores: " + stats.getWrongWords());
    }

    @FXML
    public void onBackToMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_menu.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) wpmLabel.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
