package Game;

import Game.GameMenu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;


class ProjectTicTacToeApplicationTests {

    @Test
    void playerOWinsInRow() {
        playerWinsInRow('O', 'X');
    }
    @Test
    void playerXWinsInRow () {
        playerWinsInRow('X', 'O');
    }
    private void playerWinsInRow (char currentSymbol, char oppositeSymbol) {
        int dimension = 3;
        char board[][] = GameMenu.createBoard(dimension);
        //Given
        for (int column = 0; column < dimension; column++) {
            board[0][column] = currentSymbol;
        }
        //When & Then
        Assertions.assertTrue(WinConditionCheck.checkRows(board, currentSymbol));
        Assertions.assertFalse(WinConditionCheck.checkRows(board, oppositeSymbol));
    }
    @Test
    void playerXWinsInColumns () {
        playerWinsInColumn('X','O');
    }

    @Test
    void playerOWinsInColumns () {
        playerWinsInColumn('O','X');
    }

    private void playerWinsInColumn (char currentSymbol, char oppositeSymbol) {
        int dimension = 3;
        char board[][] = GameMenu.createBoard(dimension);
        //Given
        for (int row = 0; row < dimension; row++) {
            board[row][0] = currentSymbol;
        }
        //When & Then
        Assertions.assertTrue(WinConditionCheck.checkColumns(board, currentSymbol));
        Assertions.assertFalse(WinConditionCheck.checkColumns(board, oppositeSymbol));
    }

    @Test
    void makeAMoveWrongCoordinatesException() {
        int dimension = 3;
        char board[][] = GameMenu.createBoard(dimension);
        //When
        Assertions.assertEquals(1, Moving.makeAMove(board,'X',-1,4));
        Assertions.assertEquals(1, Moving.makeAMove(board,'X',-1,1));
        Assertions.assertEquals(1, Moving.makeAMove(board,'X',1,4));
        for (int row = 0; row < dimension; row++) {
            for(int column = 0; column < dimension; column++){
                Assertions.assertEquals(' ', board[row][column]);
            }
        }
    }
    @Test
    void makeAMoveProperMove () {

    }

}
