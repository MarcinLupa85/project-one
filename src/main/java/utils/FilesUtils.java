package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesUtils {
        public static void appendTextToFile(List<String> content, Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}