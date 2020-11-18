import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderHelper {
    public static Reader readCSVFile(String fileLocation) throws StateCensusException {
        try {
            Reader reader = new BufferedReader(new FileReader(fileLocation));
            return reader;
        }catch (IOException e){
            throw new StateCensusException(StateCensusException.exceptionType.DELIMITER_EXCEPTION, "Wrong delimiter");
        }

    }
}
