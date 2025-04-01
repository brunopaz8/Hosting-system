package dio.travel_system.controller.handler;

public class InvalidException extends RuntimeException {

    public InvalidException(String message) {
        super(message);
    }
}