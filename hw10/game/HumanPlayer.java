package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    @Override
    public Move makeMove(Position position) {
        try {
            System.out.println();
            System.out.println("Current position");
            System.out.println(position);
            System.out.println("Enter you move for " + position.getTurn());
            return new Move(in.nextInt() - 1, in.nextInt() - 1, position.getTurn());
        } catch (InputMismatchException e) {
            System.out.println("Input integers > 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Move is out of bounds");
        }
        return new Move(-1,-1, position.getTurn());
    }
}
