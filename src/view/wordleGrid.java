package view;
import javax.swing.*;
import java.awt.*;

public class wordleGrid extends JFrame {
    private final JLabel[][] gridLabels;

    public wordleGrid() {
        setTitle("Wordle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 5));

        gridLabels = new JLabel[6][5];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                gridLabels[row][col] = new JLabel(" ", SwingConstants.CENTER);
                gridLabels[row][col].setOpaque(true); // ✅ This is required
                gridLabels[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridLabels[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(gridLabels[row][col]);
            }
        }
        setVisible(true);
    }

    public void updateGrid(int row, int col, char letter, Color color) {
        gridLabels[row][col].setText(String.valueOf(letter));
        gridLabels[row][col].setBackground(color);
    }
}