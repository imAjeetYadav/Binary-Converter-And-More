public class Exceptions {

    /**
     * Invalid base in general is provided
     */
    static class InvalidBaseException extends RuntimeException {
        public InvalidBaseException() {}

        public InvalidBaseException(String message) {
            super(message);
        }
    }

    /**
     * Invalid number for the base is provided
     */
    static class InvalidValueException extends RuntimeException {
        public InvalidValueException() {}

        public InvalidValueException(String message) {
            super(message);
        }
    }

}
