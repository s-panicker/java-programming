import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (0, 1, 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                gameWon = checkWinner();
                if (gameWon) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';  // Switch player
            } else {
                System.out.println("Cell already filled! Try again.");
            }
        }

        scanner.close();
    }

    public static void printBoard() {
        System.out.println("-----");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println("\n-----");
        }
    }

    public static boolean checkWinner() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;

        // Check for a draw (no more empty spaces)
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    isDraw = false;
                    break;
                }
            }
        }

        if (isDraw) {
            printBoard();
            System.out.println("It's a draw!");
            return true;
        }

        return false;
    }
}
