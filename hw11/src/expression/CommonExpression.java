package expression;

public interface CommonExpression extends Expression {
    int evaluate(int x);
    String toString();
    boolean equals(Object exp);
    int hashCode();
}
