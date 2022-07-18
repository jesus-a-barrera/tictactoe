import java.util.Scanner;
import java.util.Random;

public class Game {
    private int turn = 2;
    private final Board board = new Board();
    private final Scanner reader = new Scanner(System.in);
    private final Random random = new Random();

    public void run() {
        board.init();
        board.print();
        System.out.println("Welcome to the game!");
        while ((!board.checkWinner('X') && !(board.checkWinner('O'))) || !board.isFull()) {
            int x;
            int y;
            char mark;
            if (turn % 2 == 0) {
                mark = 'X';
                System.out.println("\nIt is your turn.");
                System.out.println("Enter x: ");
                x = reader.nextInt();
                System.out.println("Enter y: ");
                y = reader.nextInt();
            } else {
                mark = 'O';
                System.out.println("\nIt is computer turn.");
                x = random.nextInt(3);
                y = random.nextInt(3);
            }
            if (!board.checkMove(x, y, mark)) {
                System.out.println("Invalid movement. Try again.");
                continue;
            }
            System.out.println("Moving to (" + (x + 1) + ", " + (y + 1) + ")");
            board.move(x, y, mark);
            board.print();
            turn++;
        }
        if (board.checkWinner('X')) {
            System.out.println("You are the winner. Congrats!");
        }
        else if (board.checkWinner('O')) {
            System.out.println("Computer is the winner.");
        }
        else {
            System.out.println("There is no winner.");
        }

    }

}
