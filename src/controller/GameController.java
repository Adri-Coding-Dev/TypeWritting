package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class GameController {

    @FXML private Label timerLabel;
    @FXML private TextArea textToType;
    @FXML private TextField inputField;
    @FXML private ProgressBar progressBar;
    @FXML private Button startButton;
    @FXML private Button backButton;

    private Timeline timeline;
    private int totalTime = 60;  // Segundos, puedes cambiar según modo
    private int timeLeft;
    private String originalText;
    private int charsTyped;
    private boolean gameRunning = false;

    @FXML
    private void initialize() {
        // Configuración inicial
        originalText = textToType.getText();
        resetGame();
    }

    private void resetGame() {
        if (timeline != null) {
            timeline.stop();
        }
        inputField.clear();
        progressBar.setProgress(0.0);
        timeLeft = totalTime;
        timerLabel.setText("Tiempo restante: " + timeLeft + "s");
        charsTyped = 0;
        gameRunning = false;
    }

    @FXML
    private void onRestart(ActionEvent event) {
        resetGame();
        beginGame();

    }

    @FXML
    private void onBackToMenu(ActionEvent event) {
        // Aquí iría la lógica para volver al menú principal
        System.out.println("Volver al menú pulsado");
    }

    private void beginGame() {
        gameRunning = true;
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        timeline.setCycleCount(timeLeft);
        timeline.play();
    }
    
    public void setGameTime(int seconds) {
        this.totalTime = seconds;
    }


    private void updateTimer() {
        timeLeft--;
        timerLabel.setText("Tiempo restante: " + timeLeft + "s");

        if (timeLeft <= 0) {
            timeline.stop();
            gameRunning = false;
            showResults();
        }
    }

    @FXML
    private void onTextTyped(KeyEvent event) {
        if (!gameRunning) {
        	beginGame();

        }

        String typed = inputField.getText();
        int correctChars = countCorrectChars(typed, originalText);

        charsTyped = typed.length();
        double progress = (double) correctChars / originalText.length();
        progressBar.setProgress(Math.min(progress, 1.0));

        if (correctChars == originalText.length()) {
            // Usuario terminó antes del tiempo
            timeline.stop();
            gameRunning = false;
            showResults();
        }
    }

    private int countCorrectChars(String typed, String target) {
        int correct = 0;
        int len = Math.min(typed.length(), target.length());
        for (int i = 0; i < len; i++) {
            if (typed.charAt(i) == target.charAt(i)) {
                correct++;
            } else {
                break; // Contador de supervivencia, se detiene en primer error
            }
        }
        return correct;
    }

    private void showResults() {
        int correctChars = countCorrectChars(inputField.getText(), originalText);
        int totalChars = inputField.getText().length();
        double accuracy = totalChars == 0 ? 0 : (double) correctChars / totalChars * 100;
        double wpm = (double) correctChars / 5 / ((totalTime - timeLeft) / 60.0);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultados");
        alert.setHeaderText("¡Juego terminado!");
        alert.setContentText(String.format("Caracteres correctos: %d\nTotal caracteres: %d\nPrecisión: %.2f%%\nVelocidad: %.2f WPM",
                correctChars, totalChars, accuracy, wpm));
        alert.showAndWait();

        resetGame();
    }
}
