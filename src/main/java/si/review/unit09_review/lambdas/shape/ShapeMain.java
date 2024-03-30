package si.review.unit09_review.lambdas.shape;

public class ShapeMain {
    public static double triangleArea (double side) {
        return Math.sqrt(3) * Math.pow (side, 2) / 4;
    }    
    
    public static void main(String[] args) {   
        Shape circle = (radius) -> {
            return Math.PI * Math.pow(radius, 2);
        };
        System.out.println(circle.area(2));
        
        /*
        Things the lambda knows:
        - Name of the method (area())
        - Return type of the method (int)
        - Parameter type of the method (double radius)

        Requires a Functional Interface.
        */
        
        Shape triangle = ShapeMain::triangleArea;
        System.out.println(triangle.area(2));

        /*
        Lambdas can also use method referencing (as shown above). 
        Essentially setting area() to be an already made method.

        Method references require:
        - The return type to be the same.
        - The parameter type to be the same.
        */

        


    }
}
