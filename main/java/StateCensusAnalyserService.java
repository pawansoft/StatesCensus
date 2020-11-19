import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StateCensusAnalyserService {

    static List<IndianStateCode> stateCodeContainer = null;
    static List<StateCensus> stateCensusContainer = null;

    public int fetchStateCodeFileDetail(String fileLocation) throws StateCensusException, CSVBuilderException {
        CheckFileExtension.checkFileExtension(fileLocation);

        FileAvailabilityCheckService.isFileFound(fileLocation);

        Reader reader = ReaderHelper.readCSVFile(fileLocation);

        ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();

        stateCodeContainer = csvBuilder.getFileDataInToList(reader, IndianStateCode.class);

        return stateCodeContainer.size();
    }

    public int fetchStateCensusDetail(String fileLocation) throws StateCensusException, CSVBuilderException {
        CheckFileExtension.checkFileExtension(fileLocation);

        FileAvailabilityCheckService.isFileFound(fileLocation);

        Reader reader = ReaderHelper.readCSVFile(fileLocation);

        ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();

        stateCensusContainer = csvBuilder.getFileDataInToList(reader, StateCensus.class);

        return stateCensusContainer.size();
    }

    public String shortByPopulation() throws StateCensusException {
        CheckEmptyListHelper.isListEmpty(stateCensusContainer);
        stateCensusContainer = stateCensusContainer.stream()
        .sorted((detail1, detail2) -> detail2.getPopulation().compareTo(detail1.getPopulation()))
        .collect(Collectors.toList());
    String sortedStateCensusData = new Gson().toJson(stateCensusContainer);
    JsonWriterHelper.writeListToJSON(sortedStateCensusData);
    return sortedStateCensusData;
    }
}
