import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonWriterHelper {

    public static void writeListToJSON(String jsonString){
        Path path = Paths.get("/home/pawan/Desktop/PlayGround/StateCensusDetails.json");
        try(FileWriter writer = new FileWriter(path.toFile())) {
            writer.write(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
