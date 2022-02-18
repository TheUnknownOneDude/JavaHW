package expression;

import java.util.Objects;

public abstract class AbsractAction implements CommonExpression {

    final CommonExpression x, y;
    String operator;

    public AbsractAction(CommonExpression x, CommonExpression y, String operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");
        sb.append(x);
        sb.append(" ");
        sb.append(operator);
        sb.append(" ");
        sb.append(y);
        sb.append(")");

        return sb.toString();
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsractAction that = (AbsractAction) o;
        return (Objects.equals(x, that.x) && Objects.equals(y, that.y) && Objects.equals(operator, that.operator));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, getClass(), y);
    }
}
