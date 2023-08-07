package Game;

public class WinConditionCheck {

    public static boolean winCheck(char[][] board, char currentSymbol) {
        boolean winnerRows = checkRows(board, currentSymbol);
        boolean winnerColumns = checkColumns(board, currentSymbol);
        boolean winnerCorner1 = checkCorner1(board, currentSymbol);
        boolean winnerCorner2 = checkCorner2(board, currentSymbol);
        if (winnerRows || winnerColumns || winnerCorner1 || winnerCorner2) {
           return true;
        }
        return false;
    }


    public static boolean checkRows(char[][] board, char currentSymbol) {
        int dimension = board.length;
        for(int row = 0;row < dimension; row++){
            boolean winner = true;

            for(int column = 0; column < dimension; column++){
                if(board[row][column] != currentSymbol) {
                    winner = false;
                    break;
                }
            }
            if(winner){return true;}
        }
        return false;
    }
    public static boolean checkColumns(char[][] board, char currentSymbol) {
        int dimension = board.length;
        for(int column = 0;column < dimension; column++){
            boolean winner = true;

            for(int row = 0; row < dimension; row++){
                if(board[row][column] != currentSymbol) {
                    winner = false;
                    break;
                }
            }
            if(winner){return true;}
        }
        return false;
    }
    public static boolean checkCorner1(char[][] board, char currentSymbol){
        int dimension = board.length;
        for (int i = 0;i < dimension; i++){
            if (board[i][i] != currentSymbol){
                return false;
            }
        }
        return true;
    }
    public static boolean checkCorner2(char[][] board, char currentSymbol){
        int dimension = board.length;
        int row = 0;
        int column = dimension - 1;
        for (int i = 0;i < dimension; i++){
            if (board[row][column] != currentSymbol){
                return false;
            }
            --column;
            ++row;
        }
        return true;
    }
}

