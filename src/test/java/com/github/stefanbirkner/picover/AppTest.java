package com.github.stefanbirkner.picover;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AppTest {
    @Parameter(0)
    public String name; //must be assigned. Otherwise the Parameterized runner throws an exception.
    @Parameter(1)
    public App app;

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Pico only", new PicoOnlyApp()},
                {"Pico and Spring", new PicoAndSpringMixedApp()},
                {"Spring only", new SpringOnlyApp()}});
    }

    @Test
    public void isWorking() {
        String output = app.run();
        assertThat(output, is(equalTo("red Renault Twizy at Time Square")));
    }
}
