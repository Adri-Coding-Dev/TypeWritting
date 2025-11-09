package model;

public class GameStats {
	private int correctWords;
	private int wrongWords;
	private double wpm;
	private double accuracy;
	
	public void calculate(double totalSeconds) {
		this.wpm = (correctWords / totalSeconds) * 60;
		int total = correctWords + wrongWords;
		this.accuracy = total == 0 ? 0 : (correctWords * 100.0) / total;
	}
	
	
	public int getCorrectWords() {
		return correctWords;
	}
	public int getWrongWords() {
		return wrongWords;
	}
	public double getWpm() {
		return wpm;
	}
	public double getAccuracy() {
		return accuracy;
	}
	
	public void addCorrectWord() {
		correctWords++;
	}
	public void addWrongWord() {
		wrongWords++;
	}
}
