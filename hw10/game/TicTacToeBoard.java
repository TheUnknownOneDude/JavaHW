package game;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;

public class TicTacToeBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );
    public int m;
    public int n;
    public int k;

    private final Cell[][] field;
    private Cell turn;

    public TicTacToeBoard(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        field = new Cell[m][n];for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOOSE;
        }

        field[move.getRow()][move.getCol()] = move.getValue();

        if (checkWin()) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return GameResult.UNKNOWN;
    }

    private boolean checkDraw() {
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (field[r][c] == Cell.E) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    private boolean checkWin() {
        for (int r = 0; r < m; r++) {
            int count = 0;
            for (int c = 0; c < n; c++) {
                if (field[r][c] == turn) {
                    count++;
                    if (count == k) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int r = 0; r < m; r++) {
                if (field[r][c] == turn) {
                    count++;
                    if (count == k) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        //Диагонали
        for (int c = 0; c < n; c++) {
            int countT = 0;
            int countB = 0;
            for (int r = 0; r < m; r++) {
                if (r + c <= m && r + c < n) {
                    if (field[r][c + r] == turn) {
                        countT++;
                        if (countT == k) {
                            return true;
                        }
                    } else {
                        countT = 0;
                    }
                }
                if (r - c >= 0 && c != 0 && r-c < n) {
                    if (field[r][r-c] == turn) {
                        countB++;
                        if (countB == k) {
                            return  true;
                        }
                    } else {
                        countB = 0;
                    }
                }
            }
        }
        for (int c = 0; c < n; c++) {
            int countT = 0;
            int countB = 0;
            for (int r = 0; r < m; r++) {
                if (r + c <= m && r + c < n) {
                    if (field[m - r - 1][c + r] == turn) {
                        countT++;
                        if (countT == k) {
                            return true;
                        }
                    } else {
                        countT = 0;
                    }
                }
                if (r - c >= 0 && c != 0 && r - c < n) {
                    if (field[m - r - 1][r - c] == turn) {
                        countB++;
                        if (countB == k) {
                            return  true;
                        }
                    } else {
                        countB = 0;
                    }
                }
            }
        }
        return false;
    } // конец диагоналей

    public boolean isValid(final Move move) {
        try {
            return 0 <= move.getRow() && move.getRow() <= m
                    && 0 <= move.getCol() && move.getCol() <= n
                    && field[move.getRow()][move.getCol()] == Cell.E
                    && turn == move.getValue();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Move is out of bounds");
        } catch (InputMismatchException e) {
            System.out.println("Input integers > 0");
        }
        return false;
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        for (int c = 0; c < n; c++) {
            sb.append(c + 1);
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < m; r++) {
            sb.append(r + 1);
            for (Cell cell : field[r]) {
                sb.append(CELL_TO_STRING.get(cell));
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }
}
