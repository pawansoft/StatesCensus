import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class StateCensusAnalyserService {

    public int fetchStateCodeFileDetail(String fileLocation) throws StateCensusException, CSVBuilderException {
        CheckFileExtension.checkFileExtension(fileLocation);

        FileAvailabilityCheckService.isFileFound(fileLocation);

        Reader reader = ReaderHelper.readCSVFile(fileLocation);

        ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();

        List<IndianStateCode> stateCodeList = csvBuilder.getFileDataInToList(reader, IndianStateCode.class);

        return stateCodeList.size();
    }

    public int fetchStateCensusDetail(String fileLocation) throws StateCensusException, CSVBuilderException {
        CheckFileExtension.checkFileExtension(fileLocation);

        FileAvailabilityCheckService.isFileFound(fileLocation);

        Reader reader = ReaderHelper.readCSVFile(fileLocation);

        ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();

        List<StateCensus> stateCensusList = csvBuilder.getFileDataInToList(reader, StateCensus.class);

        return stateCensusList.size();
    }

}
