package com.demoqa.practiceform;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    public static String dateRandom() {
        int hundredYears = 100 * 365;
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, hundredYears)).toString();
    }
}
