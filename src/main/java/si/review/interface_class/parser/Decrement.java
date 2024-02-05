package si.review.interface_class.parser;

public class Decrement implements Expression {
    private final Expression operand;

    public Decrement (Expression operand){
        this.operand = operand;
    }

    @Override
    public double evaluate(){
        return operand.evaluate() - 1;
    }
}
