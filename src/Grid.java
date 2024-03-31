import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Grid {
    private Space[][] board;
    private Player player;
    private Scanner scanner;
    boolean testGameFinish;
    private ArrayList<Item> inventory;
    private Boss ethiron = new Boss("\uD83D\uDC7B","Ethiron - The Eye of Calamity", 3000, 50,1);
    private Boss cthyllus = new Boss("\uD83E\uDD9C","Cthyllus - The Veiled Devourer", 2000, 65,2);
    private Boss daveyJones = new Boss("\uD83D\uDC19","Davey Jones - The Swashbuckling Tempest", 1500, 80,3);
    private Boss matPat =  new Boss("☠\uFE0F","Mathew Patrick - The Game Theorist ", 1000, 105,4);
    private GUI frame;
    public Grid() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
                board[i][j] = new Space("\uD83D\uDFE6");
            }
        }

        //random encounters

        //boss spawns
        board[10][10] = player;
        board[0][10]  = ethiron;
        board[10][0] = cthyllus;
        board[10][20] = daveyJones;
        board[20][10] = matPat;
        board[10][11] = new Shop();

    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    private void play() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int currentRow = 10;
        int currentCol = 10;
        AudioPlayer mainTheme = new AudioPlayer("Main Theme Pirates of the Caribbean.wav");
        mainTheme.playSound();
        // PLACE HOLDER CONDITION (maybe, we can just set it to true when goal is met)
        while (!testGameFinish) {
            int newRow = currentRow;
            int newCol = currentCol;
            printBoard();
            System.out.print("Enter a direction (W, A, S, D): ");
            String direction = scanner.nextLine().toUpperCase();
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");

            boolean isValidMove = true;

            if (direction.equals("W") && currentRow > 0) {
                newRow = currentRow - 1;
                ethiron.playMusic();
            } else if (direction.equals("A") && currentCol > 0) {
                newCol = currentCol - 1;
                cthyllus.playMusic();
            } else if (direction.equals("S") && currentRow < board.length - 1) {
                newRow = currentRow + 1;
                daveyJones.playMusic();
            } else if (direction.equals("D") && currentCol < board[0].length - 1) {
                newCol = currentCol + 1;
                matPat.playMusic();
            } else {
                System.out.println("Invalid move. Try again.");
                isValidMove = false;
            }

            if (isValidMove) {

                //shop encounter
                if (board[newRow][newCol] instanceof Shop) {
                    player.accessShop();
                }

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
