package bbc.roman_numerals.service.impl;

import bbc.roman_numerals.service.RomanNumeralGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralGeneratorImplTest {

    private RomanNumeralGenerator romanNumeralGenerator;

    @Before
    public void setup() {
        romanNumeralGenerator = new RomanNumeralGeneratorImpl();
    }

    @Test
    public void generateOneShouldReturnI() {
        assertThat(romanNumeralGenerator.generate(1), is("I"));
    }

    @Test
    public void generateFiveShouldReturnV() {
        assertThat(romanNumeralGenerator.generate(5), is("V"));
    }

    @Test
    public void generate10ShouldReturnX() {
        assertThat(romanNumeralGenerator.generate(10), is("X"));
    }

    @Test
    public void generate3999ShouldReturnMMMCMXCIX() {
        assertThat(romanNumeralGenerator.generate(3999), is("MMMCMXCIX"));
    }

    @Test
    public void parseIShouldReturnOne() {
        assertThat(romanNumeralGenerator.parse("I"), is(1));
    }

    @Test
    public void parseVShouldReturn5() {
        assertThat(romanNumeralGenerator.parse("V"), is(5));
    }

    @Test
    public void parseXShouldReturn10() {
        assertThat(romanNumeralGenerator.parse("X"), is(10));
    }

    @Test
    public void parseMMMCMXCIXShouldReturn3999() {
        assertThat(romanNumeralGenerator.parse("MMMCMXCIX"), is(3999));
    }
}
