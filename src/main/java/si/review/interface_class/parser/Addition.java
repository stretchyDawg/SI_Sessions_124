package si.review.interface_class.parser;

public class Addition implements Expression {
    private final Expression operand1;
    private final Expression operand2;

    public Addition(Expression operand1, Expression operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public double evaluate(){
        double one = operand1.evaluate();
        double two = operand2.evaluate();
        return one + two;
    }
}
