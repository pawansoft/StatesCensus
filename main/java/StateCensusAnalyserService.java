import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyserService {

    public static <K> int getRowCount(Iterator<K> iterator) throws StateCensusException {
        int numDetails = 0;
        try{
            while (iterator.hasNext()){
                numDetails++;
                iterator.next();
            }
        }catch (RuntimeException e){
            throw new StateCensusException(StateCensusException.exceptionType.DELIMITER_EXCEPTION, "Wrong delimiter");
        }
        return numDetails;
    }

    public int fetchStateCodeFileDetail(String fileLocation) throws StateCensusException, CSVBuilderException {
        CheckFileExtension.checkFileExtension(fileLocation);

        FileAvailabilityCheckService.isFileFound(fileLocation);

        Reader reader = ReaderHelper.readCSVFile(fileLocation);

        ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();

        Iterator<IndianStateCode> iterator = csvBuilder.fetchCsvFileIterator(reader, IndianStateCode.class);

        return getRowCount(iterator);
    }

    public int fetchStateCensusDetail(String fileLocation) throws StateCensusException, CSVBuilderException {
        CheckFileExtension.checkFileExtension(fileLocation);

        FileAvailabilityCheckService.isFileFound(fileLocation);

        Reader reader = ReaderHelper.readCSVFile(fileLocation);

        ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();

        Iterator<IndianStateCode> iterator = csvBuilder.fetchCsvFileIterator(reader, StateCensus.class);

        return getRowCount(iterator);
    }

}
