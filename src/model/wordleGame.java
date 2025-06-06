package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class wordleGame {
    private String secretWord;
    private final int maxTries = 6;
    private int currentTries = 0;
    private boolean won = false;

    public wordleGame(String secretWord) {
        this.secretWord = secretWord.toLowerCase(); // Normalize for comparison
        System.out.println("Hello");
    }

    public List<letterFeedback> guess(String guess) {
        guess = guess.toLowerCase();
        List<letterFeedback> feedback = new ArrayList<>();

        for (int i = 0; i < secretWord.length(); i++) {
            char guessedChar = guess.charAt(i);
            char correctChar = secretWord.charAt(i);

            if (guessedChar == correctChar) {
                feedback.add(new letterFeedback(guessedChar, Color.GREEN));
            } else if (secretWord.contains(Character.toString(guessedChar))) {
                feedback.add(new letterFeedback(guessedChar, Color.YELLOW));
            } else {
                feedback.add(new letterFeedback(guessedChar, Color.GRAY));
            }
        }

        if (guess.equals(secretWord)) {
            won = true;
        }

        currentTries++;
        return feedback;
    }

    public boolean isGameOver() {
        return won || currentTries >= maxTries;
    }

    public boolean isWon() {
        return won;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
