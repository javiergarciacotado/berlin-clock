package com.hotels.exercise.conversion;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class BerlinClock {

    private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
    private static final String LAMP_OFF = "X";
    private static final String LAMP_YELLOW = "Y";

    public String convert(int hour, int min, int sec) {
        if (isValidTime(hour, min, sec)) {
            return "";
        }
        return "Unable to convert digital time to Berlin Clock representation";
    }

    /**
     * Return blinking top lamp
     * @param seconds Seconds
     * @return Yellow lamp turned on/off
     */
    public String getTopLine(int seconds) {
        return (seconds % 2 == 0) ? LAMP_YELLOW : LAMP_OFF;
    }

    /**
     * Validates the unit times are valid
     * @param hour Hour
     * @param min Minutes
     * @param sec Seconds
     * @return true valid time format, false invalid time format
     */
    private boolean isValidTime(int hour, int min, int sec)  {
        try {

            String time = convertToTextTime(hour, min, sec);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME24HOURS_PATTERN);
            return LocalTime.parse(time, dateTimeFormatter) != null;
        }
        catch (DateTimeException dateTimeException) {
            dateTimeException.printStackTrace();
        }
        return false;
    }

    /**
     * Returns the text representation of an hour, minutes and seconds
     * @param hour Hour
     * @param min Minutes
     * @param sec Seconds
     * @return Text representation in format HH:mm:ss
     */
    private String convertToTextTime(int hour, int min, int sec) {
        StringJoiner time = new StringJoiner(":");
        time.add(String.valueOf(hour));
        time.add(String.valueOf(min));
        time.add(String.valueOf(sec));
        return time.toString();
    }


}
