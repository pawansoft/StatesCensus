import com.opencsv.CSVReader;

import java.io.*;

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

    public CSVReader readCSVFile(String fileLocation) throws StateCensusException {
        try {
            CSVReader reader = new CSVReader(new FileReader(fileLocation));
            return reader;
        }catch (IOException e){
            throw new StateCensusException(StateCensusException.exceptionType.DELIMITER_EXCEPTION, "Wrong delimiter");
        }

    }

    public <E>int countNumberOfRows(String fileLocation) throws StateCensusException {

        Integer numRows = -1;

        checkFileExtension(fileLocation);

        isFileFound(fileLocation);

        CSVReader read = readCSVFile(fileLocation);

        try {
            while (read.readNext() != null) {
                numRows++;
            }

        }
        catch (RuntimeException e) {
            throw new StateCensusException(StateCensusException.exceptionType.HEADER_EXCEPTION, "Error in Header");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return numRows;
    }
}
