package DatasetOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializer {

    public static List<RegionStats> read() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("lab9.ser"));
        System.out.println();
        List<RegionStats> data = (List<RegionStats>) in.readObject();
        System.out.println((String) in.readObject());
        in.close();
        return data;

    }

}
