package be.xplore.kdg.pmd;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonDateServiceTest {

    private final SingletonDateService dateService = new SingletonDateService();

    @Test
    void formatDate() throws ParseException {
        var date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");

        assertThat(dateService.formatDate(date)).isEqualTo("01/01/2022");
    }
}
