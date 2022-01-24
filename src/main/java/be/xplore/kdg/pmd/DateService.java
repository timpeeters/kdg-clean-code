package be.xplore.kdg.pmd;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DateService {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}
