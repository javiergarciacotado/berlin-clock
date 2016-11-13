package com.hotels.exercise.cucumber;

import com.hotels.exercise.conversion.BerlinClock;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class BerlinClockStepDefinitions {

    private int hour;
    private int minute;
    private int second;
    private String berlinClockRepresentation;


    @Given("^the current time is \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void theCurrentTimeIs(String hour, String minute, String second) throws Throwable {
        this.hour = Integer.parseInt(!hour.equals("") ? hour : "-01");
        this.minute = Integer.parseInt(!minute.equals("") ? minute : "00");
        this.second = Integer.parseInt(!second.equals("") ? second : "00");
    }

    @When("^the client converts it to Berlin representation$")
    public void convert() {
        BerlinClock berlinClock = new BerlinClock();
        berlinClockRepresentation = berlinClock.convert(hour, minute, second);
    }

    @Then("^the Berlin representation is \"([^\"]*)\"$")
    public void result(final String expected) throws Throwable {
        assertEquals(expected, berlinClockRepresentation.replaceAll("\n", ""));
    }


}
