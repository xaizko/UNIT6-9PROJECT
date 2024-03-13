import java.util.Scanner;

public class Grid {
    private Space[][] board;
    private Player player;
    private Scanner scanner;

    public Grid() {
        scanner = new Scanner(System.in);
        createPlayer();
        setupBoard();
        play();
    }

    private void createPlayer() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        player = new Player(name);
    }

    private void setupBoard() {
        board = new Space[21][21];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Space("_", new Monster("Space", 0, 0));
            }
        }
        board[10][10] = player;
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    private void play() {
        printBoard();
    }
}
