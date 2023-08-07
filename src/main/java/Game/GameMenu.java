package Game;

import java.util.Scanner;

public class GameMenu {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        GameMenu.startGame();
    }

    public static void startGame() {
        System.out.println("XXXXX XXXXX XXXXX XXXXX XXXXX");
        System.out.println("XXXXX  TIC   TAC   TOE  OOOOO");
        System.out.println("OOOOO OOOOO OOOOO OOOOO OOOOO");

        System.out.println("Welcome in Tic Tac Toe game!");

        gameMenu();
    }

    public static void gameMenu() {
        char ch = '0';
        System.out.println("Choose an option...");
        System.out.println("1. Play Game with other Players (PvP mode)");
        System.out.println("2. Play Game against AI (PvAI)");
        System.out.println("3. Exit");
        do {
            System.out.println("Enter your option...");
            ch = scan.nextLine().charAt(0);
            switch (ch) {
                case '1':
                    System.out.println("Welcome inside the grid. Write a dimension of your grid...");
                    int dimension = scan.nextInt();
                    TicTacToe.playPvp(createBoard(dimension));
                    break;
                case '2':
                    System.out.println("Welcome inside the grid. Write a dimension of your grid...");
                    dimension = scan.nextInt();
                    TicTacToe.playPvAi(createBoard(dimension), new AiPlayer('O'));
                    break;
                case '3':
                    System.out.println("Good Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Choice (1 - 3) to continue!");
                    break;
            }
        } while (!(ch == '1' || ch == '2' || ch == '3'));
    }
     static char[][] createBoard(int dimension) {
        char[][] board = new char[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
                board[row][column] = ' ';
            }
        }
        return board;
    }
}
