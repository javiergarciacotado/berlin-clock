package com.hotels.exercise.conversion;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BerlinClockTest {

    private BerlinClock berlinClock;

    @Before
    public void setUp() throws Exception {
        berlinClock = new BerlinClock();
    }

    @Test
    @Parameters({"13, 60, 00", "25, 00, 00"})
    public void shouldNotConvertTimeNotIn24hFormat(int hour, int min, int sec) {
        String expectedMessage = "Unable to convert digital time to Berlin Clock representation";
        assertEquals(expectedMessage, berlinClock.convert(hour,min,sec));
    }

    @Test
    @Parameters({"Y, 2", "X, 1"})
    public void shouldTurnTopLampYellowEveryTwoSeconds(String expectedResult, int seconds) {
        assertEquals(expectedResult, berlinClock.getTopLine(seconds));
    }


    @Test
    @Parameters({"XXXX, 00", "RRXX, 14", "RRRR, 20", "RRRR, 23"})
    public void shouldTurnFirstLineLampsRed(String expectedResult, int hours) {
        assertEquals(expectedResult, berlinClock.getFirstLine(hours));
    }

    @Test
    @Parameters({"XXXX, 00", "RRRR, 14", "XXXX, 20", "RRRX, 23"})
    public void shouldTurnSecondLineLampsRed(String expectedResult, int hours) {
        assertEquals(expectedResult, berlinClock.getSecondLine(hours));
    }

    @Test
    @Parameters({"XXXXXXXXXXX, 00", "YYXXXXXXXXX, 14", "YYRYXXXXXXX, 20", "YYRYYRYYRYY, 59"})
    public void shouldTurnThirdLineLampsRedandYellow(String expectedResult, int min) {
        assertEquals(expectedResult, berlinClock.getThirdLine(min));
    }

    @Test
    @Parameters({"XXXX, 00", "YYYY, 14", "XXXX, 20", "YYYY, 59"})
    public void shouldTurnFourthLineLampsRed(String expectedResult, int min) {
        assertEquals(expectedResult, berlinClock.getFourthLine(min));
    }

    @Test
    @Parameters({"23, 59, 59"})
    public void shouldConvert24hTimeToBerlinClockRepresentation(int hour, int min, int sec) {
        String expectedResult = "XRRRRRRRXYYRYYRYYRYYYYYY";
        final String conversion = berlinClock.convert(hour, min, sec);
        assertThat(expectedResult, is(equalTo(conversion.replaceAll("\n", ""))));
    }




}