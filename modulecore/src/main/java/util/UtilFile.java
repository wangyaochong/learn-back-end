package util;

import java.io.File;
import java.io.IOException;

public class UtilFile {
    public static File getOrCreate(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
