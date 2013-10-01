package bbc.roman_numerals.controller;

import bbc.roman_numerals.domain.ArabicNumeral;
import bbc.roman_numerals.domain.RomanNumeral;
import bbc.roman_numerals.service.RomanNumeralGenerator;

public class RomanNumeralController {
    private final RomanNumeralGenerator romanNumeralGenerator;

    public RomanNumeralController(RomanNumeralGenerator romanNumeralGenerator) {
        this.romanNumeralGenerator = romanNumeralGenerator;
    }

    public RomanNumeral generate(int number) {
        return new RomanNumeral(romanNumeralGenerator.generate(number));
    }

    public ArabicNumeral parse(String numeral) {
        return new ArabicNumeral(romanNumeralGenerator.parse(numeral));
    }
}
