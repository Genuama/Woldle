package controller;
import java.util.List;      // ✅ correct

import model.letterFeedback;
import model.wordleGame;
import view.wordleGrid;

import javax.swing.*;
import java.awt.*;

public class gameController {
    private final wordleGame game;
    private final wordleGrid grid;
    private int currentRow = 0;

    public gameController(wordleGame game, wordleGrid grid) {
        this.game = game;
        this.grid = grid;
    }

    public void runGameLoop() {
        while (!game.isGameOver()) {
            String guess = JOptionPane.showInputDialog("Enter a 5-letter word:");

            if (guess == null || guess.length() != 5) {
                JOptionPane.showMessageDialog(null, "Please enter exactly 5 letters.");
                continue;
            }

            List<letterFeedback> feedback = game.guess(guess);


            for (int col = 0; col < 5; col++) {
                letterFeedback fb = feedback.get(col);
                char letter = fb.letter;
                Color color = fb.color;

                grid.updateGrid(currentRow, col, letter, color);
            }


            currentRow++;

            if (game.isWon()) {
                JOptionPane.showMessageDialog(null, "🎉 You guessed it!");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Game over! The word was: " + game.getSecretWord());
    }
}