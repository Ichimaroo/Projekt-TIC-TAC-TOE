package Game;

public class TieCheck {
    public static boolean tieCheck (char[][] board, char currentSymbol) {
        int dimension = board.length;
        for(int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
                if (board[row][column] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
