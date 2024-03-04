package si.session_activities.mock_practicums.test03.set1.problem01;

import java.util.Scanner;

public class Converter {
    public static class CtoF {
        private double temp;

        public CtoF(double temp){
            this.temp = temp;
        }
        
        public double convert() {
            return temp*  9/5 + 32;
        }
    }
    
    public static TempConverter FtoC(){
        return new TempConverter() {
            @Override
            public double convert(double f) {
                return (f - 32) * 5/9;
            }
        };
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the current temperature:");
        double temp = scan.nextDouble();
        
        // C to F (Inner Class)
        CtoF ctof = new CtoF(temp);
        System.out.println("C to F: " + ctof.convert());

        // F to C (Anon class)
        System.out.println("F to C: " + FtoC().convert(temp));
        
        // F to K (Lambda)
        TempConverter k = f -> (f-32)*5/9+273.15;
        System.out.println("F to K: " + k.convert(temp));

        scan.close();
    }

}
