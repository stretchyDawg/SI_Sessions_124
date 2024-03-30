package si.session_activities.unit09.converter;

import java.util.Scanner;

public class LengthConverter {
    
    // Inner class for converting meters to feet
    public static class MetersToFeetConverter implements UnitConverter{
        public MetersToFeetConverter() {}

        @Override
        public double convertUnit(double meters) {
            return meters * 3.28084;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length in meters:");
        double lengthInMeters = scanner.nextDouble();
        
        // Meters to feet (Inner Class)
        MetersToFeetConverter metersToFeetConverter = new MetersToFeetConverter();
        System.out.println("Meters to feet: " + metersToFeetConverter.convertUnit(lengthInMeters));

        // Feet to meters (Anon class)
        UnitConverter ftom = new UnitConverter() {
            @Override
            public double convertUnit(double feet) {
                return feet / 3.28084;
            }
        };
        System.out.println("Feet to meters: " + ftom.convertUnit(lengthInMeters));

        // Inches to meters (Lambda)
        UnitConverter inchesToMeters = inches -> inches * 0.0254;
        System.out.println("Inches to meters: " + inchesToMeters.convertUnit(lengthInMeters));

        scanner.close();
    }
}
