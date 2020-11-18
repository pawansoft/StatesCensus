import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;

public class CSVBuilder<K> implements ICSVBuilder{

    @Override
    public Iterator fetchCsvFileIterator(Reader reader, Class csvClass) throws StateCensusException {
        try {
            CsvToBean<K> csvToBean =  new CsvToBeanBuilder<K>(reader)
                    .withType(csvClass)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.iterator();
        }
        catch (RuntimeException e){
            throw new StateCensusException(StateCensusException.exceptionType.HEADER_EXCEPTION, "Incorrect header");
        }
    }
}
