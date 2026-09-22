import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// A simple tic-tac-toe game inspired by a geeks for geeks tutorial
// Added a simple "AI-player" (Totally random picks) to give company to lonely players.


// Teachers game framework template
abstract class Game {

    public final void play(int numberOfPlayers) {
        // a template method specifying a generic game
        initializeGame(numberOfPlayers);
        int playerInTurn = 0;

        while (!endOfGame()) {
            playSingleTurn(playerInTurn);
            playerInTurn = ++playerInTurn % numberOfPlayers;
        }
        displayWinner();
    }

    public abstract void initializeGame(int numberOfPlayers);
    public abstract boolean endOfGame();
    public abstract void playSingleTurn(int player);
    public abstract void displayWinner();
}

class ticTacToe extends Game {
    private String[] board;
    private String turn;
    private String winner;
    private Scanner in;
    private boolean useAIPlayer; 

    private String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            // Define all possible "Lines" on the tic tac toe board
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            // Check if a line (3-concecutive slots) equal xxx or ooo
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }

        return null;
    }

    private void printBoard() {
        
        // Draw / Print the board
        System.out.println(board[0]+ " " + board[1]+ " " + board[2]);
        System.out.println(board[3]+ " " + board[4]+ " " + board[5]);
        System.out.println(board[6]+ " " + board[7]+ " " + board[8]);
        
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Please write the amount of players (1/2)\nType 2 if playing locally with a friend or 1 if playing against and AI.:");
        Scanner input = new Scanner(System.in);
        numberOfPlayers = Integer.parseInt(input.nextLine());
        
        if (numberOfPlayers == 1) {
            useAIPlayer = true;
        } else if (numberOfPlayers == 2) {
            useAIPlayer = false;
        }
            else {throw new IllegalArgumentException("This game needs two players.");
        }

        in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to Tic Tac Toe.");
        printBoard();
    }

    @Override
    public boolean endOfGame() {
        winner = checkWinner();
        return winner != null;
    }

    @Override
    public void playSingleTurn(int player) {
        if (player == 0) {
            turn = "X";
        } else {
            turn = "O";
        }

        if (useAIPlayer && player == 1) {
            System.out.println("AI's turn");
            for (int slot = 0; slot < 9; slot++) {
                if (board[slot].equals(String.valueOf(slot + 1))) {
                    board[slot] = turn;
                    break;
                }
            }
            printBoard();
            return;
        }

        System.out.println("\n" + turn + "'s turn. Type a slot number to place " + turn + " in:");

        while (true) {
            try {
                int numInput = in.nextInt();

                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Pick a number from 1 to 9:");
                } else if (board[numInput - 1].equals(String.valueOf(numInput))) {
                    board[numInput - 1] = turn;
                    printBoard();
                    return;
                } else {
                    System.out.println("That spot is taken. Try again:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please ienter a number:");
                in.nextLine();
            }
        }
    }

    @Override
    public void displayWinner() {
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("The winner is " + winner + "!\nThanks for playing.");
        }

        in.close();
    }

    public static void main(String[] args) {
        new ticTacToe().play(2);
    }
}
