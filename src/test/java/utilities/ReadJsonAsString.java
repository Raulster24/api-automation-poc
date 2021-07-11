package utilities;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonAsString {

    public static String readFileAsString(String file) {
        String data = null;
        try {
            data = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }
}
