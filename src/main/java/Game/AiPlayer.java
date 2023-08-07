package Game;

import java.util.Random;
import java.util.Scanner;

public class AiPlayer {

    char mark;

    AiPlayer(char mark) {
        this.mark = mark;
    }

    void makeMove(char board[][]) {
        int row;
        int column;
        do {
            Random r = new Random();
            row = r.nextInt(board.length);
            column = r.nextInt(board.length);

        } while (Moving.makeAMove(board, mark, row, column) != 0);
    }
}

