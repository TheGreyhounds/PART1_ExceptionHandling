# Exceptions, Exception Handling, and Errors
I can honestly say this was my favorite repository to write so far. It's partly because GenerateStackOverflow
is just devious, but also because I got to talk about exception handling in Java. While other languages do
exception handling just as well, if not a little better, Java exception handling has always been close to my 
heart because it always seemed like the one thing out of the language the designers of Java seemed to get right.

Exception handling in Java is done through the use of throwing and catching exceptions, and uses the *try-catch-finally* 
block, often just the *try-catch* block, whose form is below:
```
try {
    ...
    // code that may generate exception
    ...
} catch (SomeSubclassOfException ex) {
    ...
    // code to handle exception
    ...
} finally {
    ...
    // Regardless if an exception is thrown
    // or not, this block will run at the end.
    ...
}
```
or just:
```
try {
    ...
} catch (SomeSubClassOfException ex) {
    ...
}
```
A *try-catch* block can even have multiple catch blocks, and handle each exception that may arise separately:
```
try {
    ...
    // code that may generate multiple exceptions
    ...
} catch (ExceptionTypeOne ex) {
    ...
} catch (ExceptionTypeTwo ex) {
    ...
} catch (ExceptionTypeThree ex) {
    // this can continue for n exception types
    ...
} finally {
    ...
}
```
The multiple catch block form of the *try-catch-finally* block is especially useful for file input/output, which
can generate a number of exceptions, like if the file is empty, or cannot be found, etc.

The beauty of Java's model of throwing and catching exceptions is that we can decouple code that may generate an exception
from code that must handle that exception. Take a second to think about the importance and meaning of that statement.
This feature is especially delightful, in that multiple functions can all throw the exception up their stack of function 
calls, one to another like a programmatic game of hot potato (no, seriously, this is in essence what the methods are doing) 
until the programmer finally decides she is ready to handle that exception.

So far in this README, I've been referring to the general idea of an "exception," rather than addressing any exceptions
in particular. This is because, beyond the slew of natively defined Java exceptions, a programmer can create her own
exceptions, like our DivideByZeroException, and throw/catch those. Thus, the Java model of exception handling supports
raising programmer-defined exceptions to address any situations that may arise in our programs, giving us massive power 
to write cleanly and concisely.

Finally, this repository introduced an example of an error. An error is something that goes wrong in a program that a
programmer should NOT try to check for or handle, while an exception IS something the programmer should try to handle.
A StackOverFlowError occurs when the program literally uses up more memory on the stack than has been allocated to it.
Put another way, the list of method calls in the program is larger than can be stored on the stack. As a result, the
program exits with the error, like it does in our GenerateStackOverflow class. You shouldn't encounter errors like this 
in the wild unless your creating a deeply nested application, or are working under extremely extreme hardware constraints. 
The former requires some rethinking of program structure, but the latter will rarely if ever be encountered. Thus, worry 
about exceptions, but simply be aware of errors in Java.