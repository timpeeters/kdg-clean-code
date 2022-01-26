package be.xplore.kdg.pmd;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Writer {

    public void writeFile(Path path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(content);
        } catch (IOException e) {
            throw new UncheckedIOException(String.format("Unable to write file %s", content), e);
        }
    }
}
