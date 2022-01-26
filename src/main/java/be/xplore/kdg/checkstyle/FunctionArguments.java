package be.xplore.kdg.checkstyle;

import java.time.LocalDate;

class FunctionArguments {

    static class Order {
        // The ideal number of arguments for a function is zero (niladic).
        void cancel() {
        }

        // Next comes one (monadic)
        void changeDeliveryDate(LocalDate date) {
        }

        // Followed closely by two (dyadic)
        // Three arguments (triadic) should be avoided where possible.

        // More than three (polyadic) requires very special justification
        void changeDeliveryAddress(Address address) {
        }
    }
}
