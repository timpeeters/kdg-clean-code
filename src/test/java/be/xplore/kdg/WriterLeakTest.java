package be.xplore.kdg;

import be.xplore.kdg.pmd.WriterLeak;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class WriterLeakTest {

    @Test
    void writeFile(@TempDir Path tmp) {
        var file = tmp.resolve("test.txt");

        new WriterLeak().writeFile(file, "Hello World!");

        assertThat(file).hasContent("Hello World!");
    }
}
