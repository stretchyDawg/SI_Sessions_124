package si.review.unit09_review.lambdas.shape;

public class ShapeMain {
    public static void main(String[] args) {
        int x = 5;

        Shape circle = (radius) -> {
           return Math.PI * Math.pow(radius, 2);
        };
        
        /*
        Things the lambda knows:
        - Name of the method (area())
        - Return type of the method (int)
        - Parameter type of the method (double radius)

        Requires a Functional Interface.
        */
        
        


        System.out.println(circle.area(x));
    }
}
