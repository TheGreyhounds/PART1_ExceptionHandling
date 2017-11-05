public class ExceptionHandling {
    public static void main(String[] args) {
        new ExceptionHandling();
    }
    
    public ExceptionHandling() {
        printAndWaitFiveTimes("my message", 500);
        beginExceptionHeirarchyWith(false);
    }
    
    // Delay is in milliseconds.
    public void printAndWaitFiveTimes(String message, long delay) {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(message);
                Thread.sleep(delay);
            }
        } catch (InterruptedException ex) {
            // Handle the exception here
            // if it does occur.
            ex.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println("You've printed \"" + message + "\" 5 times with " + delay + " seconds of delay.");
        }
    }
    
    public void beginExceptionHeirarchyWith(boolean condition) {
        try {
            firstExceptionThrowingMethod(condition);
        } catch (Exception ex) {
            System.out.println();
            ex.printStackTrace();
            System.out.println();
            
            System.out.println("We caught the exception! What you see above you is the called the \"stack trace\".");
            System.out.println("It is a list of all the method calls that led to the exception, from most to least recent,");
            System.out.println("with the method that actually threw the exception at the top of the heirarchy.");
        }
    }
    
    public void firstExceptionThrowingMethod(boolean condition) throws Exception {
        secondExceptionThrowingMethod(condition);
    }
    
    public void secondExceptionThrowingMethod(boolean condition) throws Exception {
        finalExceptionThrowingMethod(condition);
    }
    
    public void finalExceptionThrowingMethod(boolean condition) throws Exception {
        if (condition == false) {
            throw new Exception();
        }
    }
}