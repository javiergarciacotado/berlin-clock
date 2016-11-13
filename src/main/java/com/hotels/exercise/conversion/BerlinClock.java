package com.hotels.exercise.conversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class to transform digital time to Berlin Clock representation
 */
public class BerlinClock {

    private static final String TIME24HOURS_PATTERN = "HH:mm:ss";
    private static final String LAMP_OFF = "X";
    private static final String LAMP_YELLOW = "Y";
    private static final String LAMP_RED = "R";
    private static final int INT_LAMP = 5;

    private static Logger logger = LoggerFactory.getLogger(BerlinClock.class);

    public String convert(int hour, int min, int sec) {
        if (isValidTime(hour, min, sec)) {
            StringJoiner sj = new StringJoiner("\n");

            sj.add(getTopLine(sec));
            sj.add(getFirstLine(hour));
            sj.add(getSecondLine(hour));
            sj.add(getThirdLine(min));
            sj.add(getFourthLine(min));

            return sj.toString();
        }
        return "Unable to convert digital time to Berlin Clock representation";
    }

    /**
     * Return blinking top lamp
     *
     * @param seconds Seconds
     * @return Yellow lamp turned on/off
     */
    public String getTopLine(int seconds) {
        return (seconds % 2 == 0) ? LAMP_YELLOW : LAMP_OFF;
    }

    /**
     * Return first red lamps
     *
     * @param hour Hours
     * @return Red lamps turned on
     */
    public String getFirstLine(int hour) {
        int numberOfLampsOn = hour / INT_LAMP;
        return turn(numberOfLampsOn, LAMP_RED, 4);
    }

    /**
     * Return second red lamps
     *
     * @param hour Hours
     * @return Red lamps turned on
     */
    public String getSecondLine(int hour) {
        int numberOfLampsOn = hour % INT_LAMP;
        return turn(numberOfLampsOn, LAMP_RED, 4);
    }

    /**
     * Return first yellow + red lamps
     *
     * @param min Minutes
     * @return Yellow + Red lamps turned on
     */
    public String getThirdLine(int min) {
        int numberOfLampsOn = min / INT_LAMP;
        return turn(numberOfLampsOn, LAMP_YELLOW, 11).replaceAll("YYY", "YYR");
    }

    /**
     * Return second yellow + red lamps
     *
     * @param min Minutes
     * @return Yellow lamps turned on
     */
    public String getFourthLine(int min) {
        int numberOfLampsOn = min % INT_LAMP;
        return turn(numberOfLampsOn, LAMP_YELLOW, 4);
    }

    /**
     * Validates the unit times are valid
     *
     * @param hour Hour
     * @param min  Minutes
     * @param sec  Seconds
     * @return true valid time format, false invalid time format
     */
    private boolean isValidTime(int hour, int min, int sec) {
        try {
            String time = convertToTextTime(hour, min, sec);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME24HOURS_PATTERN);
            return LocalTime.parse(time, dateTimeFormatter) != null;
        } catch (DateTimeException dateTimeException) {
            logger.error(dateTimeException.getMessage());
        }
        return false;
    }

    /**
     * Returns the text representation of an hour, minutes and seconds
     *
     * @param hour Hour
     * @param min  Minutes
     * @param sec  Seconds
     * @return Text representation in format HH:mm:ss
     */
    private String convertToTextTime(int hour, int min, int sec) {
        StringJoiner time = new StringJoiner(":");
        time.add(String.format("%02d", hour));
        time.add(String.format("%02d", min));
        time.add(String.format("%02d", sec));
        return time.toString();
    }

    /**
     * Turns on/off the lamps given a length
     *
     * @param numberOfLampsOn Number of lamps to turn on
     * @param lampColour      Color of the turned lamp
     * @param length          length of the row to turn on
     * @return turned on/off lamps
     */
    private String turn(int numberOfLampsOn, String lampColour, int length) {
        return IntStream.range(0, length).mapToObj(i -> i < numberOfLampsOn ? lampColour : LAMP_OFF).collect(Collectors.joining());
    }


}
