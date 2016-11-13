package com.hotels.exercise.conversion;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BerlinClockTest {

    private BerlinClock berlinClock;

    @Before
    public void setUp() throws Exception {
        berlinClock = new BerlinClock();
    }

    @Test
    @Parameters({"13, 60, 00", "24, 00, 00", "0, 0, 0"})
    public void shouldNotConvertTimeNotIn24hFormat(int hour, int min, int sec) {
        String expectedMessage = "Unable to convert digital time to Berlin Clock representation";
        assertEquals(expectedMessage, berlinClock.convert(hour,min,sec));
    }

    @Test
    @Parameters({"Y, 2", "X, 1"})
    public void shouldTurnTopLampYellowEveryTwoSeconds(String expectedResult, int seconds) {
        assertEquals(expectedResult, berlinClock.getTopLine(seconds));
    }






}