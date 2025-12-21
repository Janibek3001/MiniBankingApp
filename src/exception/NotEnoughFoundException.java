package exception;

public class NotEnoughFoundException extends Exception {
    NotEnoughFoundException() {
        System.out.println("Not Enough Money!");
    }       
}