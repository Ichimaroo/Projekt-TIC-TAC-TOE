package Game;

import java.util.Scanner;

public class TicTacToe {

    public static void printGrid ( char[][] board){
        int dimension = board.length;
        //column
        for (int c = 0; c < dimension; c++) {
            System.out.print("\t" + c);
        }
        System.out.println();
        for (int row = 0; row < dimension; row++) {
            //rows
            System.out.print(row + ":\t");
            for (int column = 0; column < dimension; column++) {
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static void playPvAi(char[][] board, AiPlayer ai) {
        char currentSymbol = 'X';
        while (true) {
            if (ai.mark == currentSymbol) {
                ai.makeMove(board);
            } else {
                letPlayerMove(board, currentSymbol);
            }
            if (WinConditionCheck.winCheck(board, currentSymbol)) {
                printGrid(board);
                System.out.println("Congratulations! Player " + currentSymbol + " wins!");
                System.exit(0);
            } else if (TieCheck.tieCheck(board, currentSymbol)) {
                printGrid(board);
                System.out.println("It's a tie!");
                System.exit(0);
            } else {
                currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
            }
        }
    }
    public static void playPvp(char[][] board) {
        char currentSymbol = 'X';
        while (true) {
            letPlayerMove(board, currentSymbol);
            if (WinConditionCheck.winCheck(board, currentSymbol)) {
                printGrid(board);
                System.out.println("Congratulations! Player " + currentSymbol + " wins!");
                System.exit(0);

            } else if (TieCheck.tieCheck(board,currentSymbol)) {
                printGrid(board);
                System.out.println("It's a tie!");
                System.exit(0);
            } else {
                currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
            }
        }
    }
    public static void letPlayerMove(char[][] board, char currentSymbol) {
        boolean properMove = false;
        while (!properMove) {
            printGrid(board);
            System.out.println(currentSymbol + "  Your turn...");
            System.out.println("Pick row index:");
            int row = new Scanner(System.in).nextInt();
            System.out.println("Pick column index:");
            int column = new Scanner(System.in).nextInt();
            switch (Moving.makeAMove(board, currentSymbol, row, column)) {
                case 1:
                    System.err.println("Illegal Move!");
                    break;
                case 2:
                    System.err.println("This place is already taken!");
                    break;
                case 0:
                    properMove = true;
                    break;
                default:
                    throw new RuntimeException("Unexpected value!");
            }
        }
    }
}

