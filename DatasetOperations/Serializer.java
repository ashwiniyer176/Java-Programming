package DatasetOperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializer {
    public static void save(List<RegionStats> obj) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("lab9.ser"));
        out.writeObject(obj);
        String hitesh = "Main bhout bada chutiya hun";
        out.writeObject(hitesh);
        out.close();

    }

}
