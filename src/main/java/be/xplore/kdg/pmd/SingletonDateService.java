package be.xplore.kdg.pmd;

import java.text.SimpleDateFormat;
import java.util.Date;

// Singleton
public class SingletonDateService {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}
