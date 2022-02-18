package expression;

public class Divide extends AbsractAction  {

    CommonExpression var, c;


    public Divide(CommonExpression var, CommonExpression c) {
        super(var, c, "/");
        this.var = var;
        this.c = c;
    }


    @Override
    public int evaluate(int x) {
        return var.evaluate(x) / c.evaluate(x);
    }



}
