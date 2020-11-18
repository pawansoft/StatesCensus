import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTest {
    public String INDIA_STATE_CENSUS_DATA = "/home/pawan/Desktop/PlayGround/IndiaStateCensusData .csv";
    public String INDIA_STATE_CODE = "/home/pawan/Desktop/PlayGround/IndiaStateCode .csv";
    public String FILE_NOT_FOUND = "/home/pawan/Desktop/PlayGround/IndiaState.csv";
    public String INVALID_FILE_TYPE= "/home/pawan/Desktop/PlayGround/abc/IndiaStateCensusData .txt";

    @Test
    public void ProvideFileLocation_WhenRecordFound_TestCaseShouldPass() throws IOException, StateCensusException {
        StateCensusService stateCensusService = new StateCensusService();
        int numberOfRecord = stateCensusService.fetchStateCensusDetail(INDIA_STATE_CENSUS_DATA);
        System.out.println(numberOfRecord);
        Assert.assertEquals(29, numberOfRecord);
    }

    @Test
    public void ProvideFileLocation_WhenNotMatched_ShouldReturnCustomException() throws IOException {
        try {
            StateCensusService stateCensusService = new StateCensusService();
            stateCensusService.fetchStateCodeFileDetail(INVALID_FILE_TYPE);

        }catch (StateCensusException e)
        {
            Assert.assertEquals(StateCensusException.exceptionType.INCORRECT_FILE_TYPE, e.type);
        }
    }
    @Test
    public void ProvideFileLocation_WhenDelimiterIssue_ShouldRetunCustomException() {
        StateCensusService stateCensusService = new StateCensusService();
        try {
            stateCensusService.fetchStateCensusDetail(INDIA_STATE_CODE);
        }
        catch (StateCensusException e) {
            Assert.assertEquals(StateCensusException.exceptionType.DELIMITER_EXCEPTION, e.type);
        }
    }

    @Test
    public void ProvideFileLocation_WhenFileNotFound_ShouldReturnCustomException() throws StateCensusException {
        try {
            StateCensusService stateCensusService = new StateCensusService();
            stateCensusService.fetchStateCensusDetail(FILE_NOT_FOUND);

        }catch (StateCensusException e)
        {
            Assert.assertEquals(StateCensusException.exceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    @Test
    public void ProvideFileLocation_WhenFoundErrorInHeader_ShouldThrowException() throws StateCensusException {
        try {
            StateCensusService stateCensusService = new StateCensusService();
            stateCensusService.fetchStateCensusDetail(INDIA_STATE_CODE);
        }
        catch (ClassCastException e){
            Assert.assertEquals(StateCensusException.exceptionType.HEADER_EXCEPTION, e.getMessage());
        }
    }

    @Test
    public void ProvideStateCodeCSV_WhenRecordMatches_TestCaseShouldPass(){
        try {
            StateCensusService stateCensusService = new StateCensusService();
            int count = stateCensusService.fetchStateCodeFileDetail(INDIA_STATE_CODE);
            Assert.assertEquals(37, count);
        }catch (StateCensusException e){
            e.printStackTrace();
        }
    }

    @Test
    public void ProvideStateCodeCSV_WhenRecordExtensionNotCSV_TestCaseShouldPass(){
        try {
            StateCensusService stateCensusService = new StateCensusService();
            int count = stateCensusService.fetchStateCodeFileDetail(INVALID_FILE_TYPE);
        }catch (StateCensusException e){
            Assert.assertEquals(StateCensusException.exceptionType.INCORRECT_FILE_TYPE, e.type);
        }
    }

    @Test
    public void ProvideStateCodeCSV_WhenFileNotFound_TestCaseShouldPass(){
        try {
            StateCensusService stateCensusService = new StateCensusService();
            int count = stateCensusService.fetchStateCodeFileDetail(FILE_NOT_FOUND);
        }catch (StateCensusException e){
            Assert.assertEquals(StateCensusException.exceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    @Test
    public void ProvideStateCodeCSV_WhenFileHeaderNotMatched_TestCaseShouldPass(){
        try {
            StateCensusService stateCensusService = new StateCensusService();
            int count = stateCensusService.fetchStateCodeFileDetail(INDIA_STATE_CENSUS_DATA);
        }catch (StateCensusException e){
            Assert.assertEquals(StateCensusException.exceptionType.HEADER_EXCEPTION, e.type);
        }
    }

    @Test
    public void ProvideFileLocation_WhenDelimiterIssueInStateCode_ShouldReturnCustomException() {
        StateCensusService stateCensusService = new StateCensusService();
        try {
            stateCensusService.fetchStateCensusDetail(INDIA_STATE_CENSUS_DATA);
        }
        catch (StateCensusException e) {
            Assert.assertEquals(StateCensusException.exceptionType.DELIMITER_EXCEPTION, e.type);
        }
    }

}
