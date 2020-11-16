public class StateCensusException extends Exception {

    enum exceptionType {
        FILE_NOT_FOUND, INCORRECT_FILE_TYPE, HEADER_EXCEPTION
    }

    exceptionType type;

    public StateCensusException(exceptionType type, String message){
        super(message);
        this.type = type;
    }
}
