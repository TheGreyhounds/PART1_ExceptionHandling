class DivideByZeroException extends Exception {
    public DivideByZeroException() {
        super("Error, cannot divide by zero!");
    }
}

public class CustomException {
    public static void main(String[] args) {
        new CustomException();
    }
    
    public CustomException() {
        demonstrateCustomException();
    }
    
    public void demonstrateCustomException() {
        try {
            for (double numerator = 0, denominator = 10; denominator >= 0; numerator++, denominator--) {
                System.out.println(numerator + " / " + denominator + " == " + divide(numerator, denominator));
            }
        } catch (DivideByZeroException ex) {
            ex.printStackTrace();
            System.out.println();
            System.out.println("We caught our custom-made DivideByZeroException!");
        }
    }
    
    public double divide(double numerator, double denominator) throws DivideByZeroException {
        if (denominator == 0) {
            throw new DivideByZeroException();
        }
        return numerator / denominator;
    }
}