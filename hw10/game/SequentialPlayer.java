package game;

public class SequentialPlayer implements Player {
    int m;
    int n;
    int k;
    public SequentialPlayer(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
    }
    @Override
    public Move makeMove(Position position) {
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                final Move move = new Move(r, c, position.getTurn());
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new AssertionError("No valid moves");
    }
}
