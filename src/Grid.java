import java.util.Scanner;

public class Grid {
    private Space[][] board;
    private Player player;
    private Scanner scanner;
    boolean testGameFinish;

    public Grid() {
        scanner = new Scanner(System.in);
        createPlayer();
        setupBoard();
        testGameFinish = false; // BOOLEAN TO SATISFY WHILE LOOP SO WE CAN DECIDE ON THE GAME'S GOAL
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
                board[i][j] = new Space("_");
            }
        }
        board[10][10] = player;
        board[0][10] = new Monster("E","Ethiron", 3000, 25);
        board[10][0] = new Monster("C","Chaser", 2000, 20);
        board[10][20] = new Monster("M","Maestro", 1500, 30);
        board[20][10] = new Monster("D","Davy Jones", 1000, 10);


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

        int currentRow = 10;
        int currentCol = 10;

        while (!testGameFinish) {
            int newRow = currentRow;
            int newCol = currentCol;
            printBoard();
            System.out.print("Enter a direction (W, A, S, D): ");
            String direction = scanner.nextLine().toUpperCase();

            boolean isValidMove = true;

            if (direction.equals("W") && currentRow > 0) {
                newRow = currentRow - 1;
            } else if (direction.equals("A") && currentCol > 0) {
                newCol = currentCol - 1;
            } else if (direction.equals("S") && currentRow < board.length - 1) {
                newRow = currentRow + 1;
            } else if (direction.equals("D") && currentCol < board[0].length - 1) {
                newCol = currentCol + 1;
            } else {
                System.out.println("Invalid move. Try again.");
                isValidMove = false;
            }

            if (isValidMove) {
                Space temp = board[newRow][newCol];
                board[newRow][newCol] = board[currentRow][currentCol];
                board[currentRow][currentCol] = temp;

                currentRow = newRow;
                currentCol = newCol;

            } else {
                System.out.println("Out of bounds. Try again.");
            }
        }
    }
}
