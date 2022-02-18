package expression;

public class Subtract extends AbsractAction {


    Expression var, c;

    public Subtract(CommonExpression var, CommonExpression c) {
        super(var, c, "-");
        this.var = var;
        this.c = c;
    }

    @Override
    public int evaluate(int x) {
        return var.evaluate(x) - c.evaluate(x);
    }


}
