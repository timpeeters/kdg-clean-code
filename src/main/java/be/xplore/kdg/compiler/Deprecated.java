package be.xplore.kdg.compiler;

import java.util.Date;

class Deprecated {

    /**
     * Deprecated as of JDK version 1.1 (1997).
     *
     * Confusing constructor params:
     * year – the year minus 1900.
     * month – the month between 0-11.
     * date – the day of the month between 1-31.
     */
    void newDate() {
        new Date(122, 0, 26);
    }
}
