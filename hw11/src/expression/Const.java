package expression;

import java.util.Objects;

public class Const implements CommonExpression {
    int c;

    public Const(int cin) {
        c = cin;
    }



    public String toString() {
            return Integer.toString(c);
    }


    @Override
    public int evaluate(int x) {
        return c;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Const aConst = (Const) o;
        return c == aConst.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }
}




