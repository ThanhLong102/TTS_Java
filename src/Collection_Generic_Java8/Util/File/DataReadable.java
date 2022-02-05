package Collection_Generic_Java8.Util.File;

import java.util.List;

public interface DataReadable {
    <T> List<T> readDataFromFile(String fileName);
}
