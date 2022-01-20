package Exception_JavaIO.Exception;

import java.io.*;

public class IOFile {
    public static Object[] doc(String file, int soPtu) {
        Object[] arr = new Object[soPtu];
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
            arr = (Object[]) o.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return arr;
    }

        public static <T> void viet(String file,T[] arr){
        try(ObjectOutputStream o =new ObjectOutputStream(new FileOutputStream(file))){
            o.writeObject(arr);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
