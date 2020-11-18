import java.io.Reader;
import java.util.Iterator;

public interface ICSVBuilder <K>{
    public Iterator<K> fetchCsvFileIterator(Reader reader, Class<K> csvClass) throws StateCensusException;
}
