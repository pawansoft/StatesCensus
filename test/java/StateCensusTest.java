import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTest {
    public String INDIA_STATE_CENSUS_DATA = "/home/pawan/Desktop/PlayGround/IndiaStateCensusData .csv";
    public String INDIA_STATE_CODE = "/home/pawan/Desktop/PlayGround/indiaStateCode .csv";
    public String INDIA_STATE_CENSUS_DATA_Wrong_Type= "/home/pawan/Desktop/PlayGround/abc/IndiaStateCensusData .txt";

    @Test
    public void ProvideFileLocation_WhenRecordFound_TestCaseShouldPass() throws IOException, StateCensusException {
        StateCensusService stateCensusService = new StateCensusService();
        int numberOfRecord = stateCensusService.countNumberOfRows(INDIA_STATE_CENSUS_DATA);
        System.out.println(numberOfRecord);
        Assert.assertEquals(29, numberOfRecord);

    }

    @Test
    public void ProvideFileLocation_WhenNotMatched_ShouldReturnCustomException() throws IOException {
        try {
            StateCensusService stateCensusService = new StateCensusService();
            stateCensusService.countNumberOfRows(INDIA_STATE_CENSUS_DATA_Wrong_Type);

        }catch (StateCensusException e)
        {
            Assert.assertEquals(StateCensusException.exceptionType.INCORRECT_FILE_TYPE, e.type);
        }
    }

    @Test
    public void ProvideFileLocation_WhenFileNotFound_ShouldReturnCustomException() throws StateCensusException {
        try {
            StateCensusService stateCensusService = new StateCensusService();
            stateCensusService.countNumberOfRows(INDIA_STATE_CENSUS_DATA_Wrong_Type);

        }catch (StateCensusException e)
        {
            Assert.assertEquals(StateCensusException.exceptionType.FILE_NOT_FOUND, e.getMessage());
        }
    }

    @Test
    public void ProvideFileLocation_WhenFoundErrorInHeader_ShouldThrowException() throws StateCensusException {
        try {
            StateCensusService stateCensusService = new StateCensusService();
            stateCensusService.countNumberOfRows(INDIA_STATE_CODE);
        }
        catch (ClassCastException e){
            Assert.assertEquals(StateCensusException.exceptionType.HEADER_EXCEPTION, e.getMessage());
        }
    }

}
