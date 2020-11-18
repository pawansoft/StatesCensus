import java.io.File;

public class FileAvailabilityCheckService {
    public static boolean isFileFound(String fileLocation) throws StateCensusException {
        File file = new File(fileLocation);
        if(!file.exists()){
            throw new StateCensusException(StateCensusException.exceptionType.FILE_NOT_FOUND, "please provide valid file");
        }
        else {
            return true;
        }
    }
}
