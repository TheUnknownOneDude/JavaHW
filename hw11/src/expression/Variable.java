package expression;

import java.util.Objects;


public class Variable implements CommonExpression {
    String var;

    public Variable(String x) {
        this.var = x;
    }

    public String toString() {
        return var;
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return Objects.equals(var, variable.var);
    }

    @Override
    public int hashCode() {
        return Objects.hash(var);
    }
}
