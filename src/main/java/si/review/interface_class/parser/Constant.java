package si.review.interface_class.parser;

public class Constant implements Expression{
    private final double value;

    public Constant(double value){
        this.value = value;
    }    

    @Override
    public double evaluate(){
        return value;
    }

}
