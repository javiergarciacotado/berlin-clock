package com.hotels.exercise.conversion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {

    @Test
    public void shouldConvert24hTime() {
        BerlinClock berlinClock = new BerlinClock();
        String expectedMessage = "Unable to convert digital time to Berlin Clock representation";
        assertEquals(expectedMessage, berlinClock.convert(13,60,0));
    }




}