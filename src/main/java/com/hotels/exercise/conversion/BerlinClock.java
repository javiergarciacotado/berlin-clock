package com.hotels.exercise.conversion;

import java.time.DateTimeException;
import java.time.LocalTime;

public class BerlinClock {

    public String convert(int hour, int min, int sec) {
        if (isValidTime(hour, min, sec)) {
            return "";
        }
        return "Unable to convert digital time to Berlin Clock representation";
    }

    private boolean isValidTime(int hour, int min, int sec)  {
        try {
            final LocalTime localTime = LocalTime.of(hour, min, sec);
            return true;
        }
        catch (DateTimeException dateTimeException) {
            dateTimeException.printStackTrace();
        }
        return false;
    }
}
