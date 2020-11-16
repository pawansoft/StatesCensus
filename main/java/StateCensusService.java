import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class StateCensusService {
public int countNumberOfRows(String fileLocation) throws StateCensusException {

    File file = new File(fileLocation);
    int numRows = -1;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        int index = fileLocation.lastIndexOf('.');
        String extension = fileLocation.substring(index + 1);
        System.out.println(extension);
        if (!extension.equals("csv")) {
            throw new StateCensusException(StateCensusException.exceptionType.INCORRECT_FILE_TYPE, "please select correct file type");
        }

        while (reader.readLine() != null) {
            numRows++;
        }
        reader.close();
    } catch (NoSuchFileException notFound) {
        throw new StateCensusException(StateCensusException.exceptionType.FILE_NOT_FOUND, "File not found");
    }
    catch (RuntimeException e){
        throw new StateCensusException(StateCensusException.exceptionType.HEADER_EXCEPTION, "Error in Header");
    }
    catch (IOException e){
        e.printStackTrace();
    }


    return numRows;
}
}
