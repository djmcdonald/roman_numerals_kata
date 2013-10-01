package bbc.roman_numerals.controller;

import bbc.roman_numerals.domain.ArabicNumeral;
import bbc.roman_numerals.domain.RomanNumeral;
import bbc.roman_numerals.service.RomanNumeralGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RomanNumeralControllerTest {

    @Mock
    private RomanNumeralGenerator romanNumeralGenerator;

    private RomanNumeralController romanNumeralController;

    @Before
    public void setup() {
        romanNumeralController = new RomanNumeralController(romanNumeralGenerator);
    }

    @Test
    public void shouldReturnAGeneratedRomanNumeral() {
        String romanNumeral = "I";
        int arabicNumeral = 1;
        when(romanNumeralGenerator.generate(arabicNumeral)).thenReturn(romanNumeral);

        RomanNumeral actualRomanNumeral = romanNumeralController.generate(arabicNumeral);
        assertThat(actualRomanNumeral.getRomanNumeral(), is(romanNumeral));
    }

    @Test
    public void shouldReturnAParsedArabicNumeral() {
        String romanNumeral = "IV";
        int arabicNumeral = 4;
        when(romanNumeralGenerator.parse(romanNumeral)).thenReturn(arabicNumeral);

        ArabicNumeral actualArabicNumeral = romanNumeralController.parse(romanNumeral);
        assertThat(actualArabicNumeral.getNumeral(), is(arabicNumeral));
    }
}
