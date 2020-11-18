public class CheckFileExtension {
    public static boolean checkFileExtension(String fileLocation) throws StateCensusException {
        int index = fileLocation.lastIndexOf(".");
        String extension = fileLocation.substring(index+1);
        if(!extension.equals("csv")){
            throw new StateCensusException(StateCensusException.exceptionType.INCORRECT_FILE_TYPE, "Incorrect File type");
        }
        else{
            return true;
        }
    }
}
