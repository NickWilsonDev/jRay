package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PPM {

    private byte[] data;

    public PPM(byte[] data) {

        this.data = data;
        Path file = Paths.get("the-file-name");
        try {
            Files.write(file, data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}