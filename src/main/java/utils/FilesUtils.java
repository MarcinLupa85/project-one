package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesUtils {
    private static final Logger LOGGER = LogManager.getLogger(FilesUtils.class);

    public static void appendTextToFile(List<String> content, Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            LOGGER.error("Cannot append text to file {}", e.getMessage());
        }
    }
}
