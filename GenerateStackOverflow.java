public class GenerateStackOverflow {
    public static void main(String[] args) {
        new GenerateStackOverflow();
    }
    
    public GenerateStackOverflow() {
        // Oh boy, you know what's coming...
        generateStackOverflowError();
    }
    
    public void generateStackOverflowError() {
        // The specifics of this code don't really matter
        // all that much, all that matters is that there
        // is a MONUMENTAL amount of looping and (recursive)
        // function calls going onto the stack (poor thing).
        for (int x = 0; x < 1_000; x++) {
            for (int y = 0; y < 100; y++) {
                for (int z = 0; z < 10; z++) {
                    System.out.println(factorial((long) x*y*z));
                }
            }
        }
    }

    public long factorial(long n) {
        if (n == 1) {
            return n;
        }
        
        return n * factorial(n-1);
    }
}