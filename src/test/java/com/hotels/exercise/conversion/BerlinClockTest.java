package com.hotels.exercise.conversion;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BerlinClockTest {

    @Test
    @Parameters({"13, 60, 00", "24, 00, 00", "0, 0, 0"})
    public void shouldNotConvertTimeNotIn24hFormat(int hour, int min, int sec) {
        BerlinClock berlinClock = new BerlinClock();
        String expectedMessage = "Unable to convert digital time to Berlin Clock representation";
        assertEquals(expectedMessage, berlinClock.convert(hour,min,sec));
    }






}