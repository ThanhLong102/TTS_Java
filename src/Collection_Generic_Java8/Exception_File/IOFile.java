package Collection_Generic_Java8.Exception_File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class IOFile {

    public static <T> List<T> doc(String file) {
        List<T> list = new ArrayList<>();
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<T>) o.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static <T> void viet(String file, List<T> list) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
            o.writeObject(list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
