import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StateCensusService {

    public boolean checkFileExtension(String fileLocation) throws StateCensusException {
        int index = fileLocation.lastIndexOf(".");
        String extension = fileLocation.substring(index+1);
        if(!extension.equals("csv")){
            throw new StateCensusException(StateCensusException.exceptionType.INCORRECT_FILE_TYPE, "Incorrect File type");
        }
        else{
            return true;
        }
    }

    public boolean isFileFound(String fileLocation) throws StateCensusException {
        File file = new File(fileLocation);
        if(!file.exists()){
            throw new StateCensusException(StateCensusException.exceptionType.FILE_NOT_FOUND, "please provide valid file");
        }
        else {
            return true;
        }
    }

    public int countNumberOfRows(String fileLocation) throws StateCensusException {

        int numRows = -1;

        checkFileExtension(fileLocation);

        isFileFound(fileLocation);

        try {
                BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
                while (reader.readLine() != null) {
                    numRows++;
                }

                reader.close();
        }
        catch (RuntimeException e) {
            throw new StateCensusException(StateCensusException.exceptionType.HEADER_EXCEPTION, "Error in Header");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return numRows;
    }
}
