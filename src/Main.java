import controller.gameController;
import model.wordleGame;
import view.wordleGrid;

public class Main {
    public static void main(String[] args) {
    wordleGame game = new wordleGame("amand");
    wordleGrid grid = new wordleGrid();
    gameController controller = new gameController(game, grid);
    controller.runGameLoop();
    }
}
