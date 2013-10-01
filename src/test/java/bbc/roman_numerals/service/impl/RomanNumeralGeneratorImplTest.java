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
    public void generate50ReturnsL() {
        assertThat(romanNumeralGenerator.generate(50), is("L"));
    }

    @Test
    public void generate100ReturnsC() {
        assertThat(romanNumeralGenerator.generate(100), is("C"));
    }

    @Test
    public void shouldReturnIVFor4() {
        assertThat(romanNumeralGenerator.generate(4), is("IV"));
    }

    @Test
    public void shouldReturnIXFor9() {
        assertThat(romanNumeralGenerator.generate(9), is("IX"));
    }

    @Test
    public void generate3999ShouldReturnMMMCMXCIX() {
        assertThat(romanNumeralGenerator.generate(3999), is("MMMCMXCIX"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateShouldOnlyAllowOneOrAbove() {
        romanNumeralGenerator.generate(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateShouldntAcceptNumbersOver3999() {
        romanNumeralGenerator.generate(4000);
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
