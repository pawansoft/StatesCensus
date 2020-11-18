public class CSVBuilderException extends Exception{
    enum CSVException{
        ENCAPSULATE_EXCEPTION
    }

    CSVException csvExcType;

    public CSVBuilderException(String message, CSVException csvExcType) {
        super(message);
        this.csvExcType = csvExcType;
    }
}
