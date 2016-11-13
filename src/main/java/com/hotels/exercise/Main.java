package com.hotels.exercise;

import com.hotels.exercise.conversion.BerlinClock;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        BerlinClock berlinClock = new BerlinClock();

        final LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        System.out.println("CURRENT TIME IN BERLIN CLOCK");
        System.out.println(berlinClock.convert(hour, minute, second));
    }

}
