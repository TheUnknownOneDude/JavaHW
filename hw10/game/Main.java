package game;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player SecondPlayer = new RandomPlayer(0,0,0);
        Player FirstPlayer = new RandomPlayer(0,0,0);
        Scanner in = new Scanner(System.in);
        String[] mnk = new String[4];
        int m = 0, n = 0, k = 0;
        int BestOf = 0;
        int FPwins = 0;
        int SPwins = 0;
        int CurGame = 1;
        do {
               System.out.println("Input rows, columns,in a row to win, games to win series , each one on the new a line");
               mnk[0] = in.nextLine();
               mnk[1] = in.nextLine();
               mnk[2] = in.nextLine();
               mnk[3] = in.nextLine();
            try {
                m = Integer.parseInt(mnk[0]);
                n = Integer.parseInt(mnk[1]);
                k = Integer.parseInt(mnk[2]);
                BestOf = Integer.parseInt(mnk[3]);
                if (m <= 0 || n <= 0 || k <= 0 || BestOf <= 0) {
                    System.out.println("Input integers > 0");
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Input integers > 0");
                continue;
            } catch (NoSuchElementException e) {
                System.out.println("Don't input random things...");
                continue;
            }
            break;
        } while (true);

        System.out.println("Player One:");
        System.out.println("Write Human , to choose HumanPlayer, Random , to choose RandomPlayer" +
                " Sequential , to choose SequentialPlayer");

        boolean FPadded = false;
        while (!(FPadded)) {
            String type = in.next();
            if (type.equals("Human")) {
                FirstPlayer = new HumanPlayer(new Scanner(System.in));
                FPadded = true;
            }
            else if (type.equals("Random")) {
                FirstPlayer = new RandomPlayer(m,n,k);
                FPadded = true;
            }
            else if (type.equals("Sequential")) {
                FirstPlayer = new SequentialPlayer(m,n,k);
                FPadded = true;
            } else {
                System.out.println("Enter correct player type");
            }
        }
        System.out.println("Player Two:");
        System.out.println("Write Human , to choose HumanPlayer, Random , to choose RandomPlayer" +
                " Sequential , choose SequentialPlayer");
        boolean SPAdded = false;
        while (!(SPAdded)) {
            String type = in.next();
            if (type.equals("Human")) {
                SecondPlayer = new HumanPlayer(new Scanner(System.in));
                SPAdded = true;
            }
            else if (type.equals("Random")) {
                SecondPlayer = new RandomPlayer(m,n,k);
                SPAdded = true;
            }
            else if (type.equals("Sequential")) {
                SecondPlayer = new SequentialPlayer(m,n,k);
                SPAdded = true;
            } else {
                System.out.println("Enter correct player type");
            }
        }

        while (FPwins < BestOf && SPwins < BestOf) {
            final int result = new TwoPlayerGame(
                    new TicTacToeBoard(m, n, k),
//                        new RandomPlayer(m,n,k),
                    FirstPlayer,
                    SecondPlayer,
      //              new HumanPlayer(new Scanner(System.in)),
 //                   new HumanPlayer(new Scanner(System.in)),
//                        new HumanPlayer(new Scanner(System.in)),
                    CurGame
            ).play(true);
            switch (result) {
                case 1:
                    System.out.println("First player won");
                    FPwins++;
                    break;
                case 2:
                    System.out.println("Second player won");
                    SPwins++;
                    break;
                case 0:
                    System.out.println("Draw");
                    break;
                default:
                    throw new AssertionError("Unknown result " + result);
            }
            if (FPwins < BestOf && SPwins < BestOf) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("First player score: " + FPwins + " " + "Second player score: " + SPwins);
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Turn order and symbols have been swapped");
                System.out.println("-----------------------------------------------------------------------");
                CurGame++;
            } else if (FPwins > SPwins){
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("The winner is FIRST PLAYER");
                System.out.println("-----------------------------------------------------------------------");
            } else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("The winner is SECOND PLAYER");
                System.out.println("-----------------------------------------------------------------------");
            }
        }
        }
    }