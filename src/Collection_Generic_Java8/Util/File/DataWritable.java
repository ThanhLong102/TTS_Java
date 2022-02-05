package Collection_Generic_Java8.Util.File;

import java.util.List;

public interface DataWritable {
    <T> void writeDataToFile(List<T> data, String fileName);
}
