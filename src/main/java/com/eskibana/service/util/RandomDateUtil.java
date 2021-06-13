package com.eskibana.service.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateUtil {

    public static final long minDay = LocalDate.of(2010, Month.JANUARY,1).toEpochDay();
    public static final long maxDay = LocalDate.now().toEpochDay();
    public static LocalDate generateRandomLocalDate(){
        long randomDay = minDay + ThreadLocalRandom.current().nextLong(maxDay-minDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
