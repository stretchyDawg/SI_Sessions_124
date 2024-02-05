package unit03;

public class Fahrenheit extends Thermometer {
        public Fahrenheit(double degrees) {
            super(degrees);
        }

        @Override
        public double getFreezingPoint() {
            return 32;
        }

        @Override
        public double getBoilingPoint() {
            return 212;
        }

        @Override
        public char getScale() {
            return 'F';
        }
    }
