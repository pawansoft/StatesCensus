public class CSVBuilderFactory {
    public static ICSVBuilder createBuilder() throws CSVBuilderException {
       try {
           return new CSVBuilder();
       }
       catch (Exception e)
       {
           throw new CSVBuilderException("Something wrong in encapsulation",CSVBuilderException.CSVException.ENCAPSULATE_EXCEPTION);
       }

    }
}
