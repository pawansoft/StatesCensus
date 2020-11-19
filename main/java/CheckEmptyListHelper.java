import java.util.List;

public class CheckEmptyListHelper {
    public static void isListEmpty(List myList) throws StateCensusException {
        StateCensusAnalyserService analyserService = new StateCensusAnalyserService();
        if(myList == null || myList.size() == 0){
            throw new StateCensusException(StateCensusException.exceptionType.EMPTY_LIST_EXCEPTION, "Provided list is empty");
        }
    }
}
