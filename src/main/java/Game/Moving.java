package Game;

import java.util.Scanner;

public class Moving {

    public static int makeAMove ( char[][] board, char currentSymbol, int row, int column) {
        boolean properMove;
        try {
            properMove = board[row][column] == ' ';
        } catch (ArrayIndexOutOfBoundsException e) {
            return 1;
        }
        if (!properMove) {
            return 2;
        }
        board[row][column] = currentSymbol;
        return 0;
    }
}
