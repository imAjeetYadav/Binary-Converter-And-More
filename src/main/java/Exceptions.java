public class Exceptions {

    static class InvalidBaseException extends RuntimeException {
        public InvalidBaseException() {}

        public InvalidBaseException(String message) {
            super(message);
        }
    }

    static class InvalidValueException extends RuntimeException {
        public InvalidValueException() {}

        public InvalidValueException(String message) {
            super(message);
        }
    }

}
