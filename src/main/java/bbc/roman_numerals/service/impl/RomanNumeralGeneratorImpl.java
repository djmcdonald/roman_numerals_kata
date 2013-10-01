package bbc.roman_numerals.service.impl;

import bbc.roman_numerals.service.RomanNumeralGenerator;

import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.remove;

public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

    private final String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private final int[] romanNumeralValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    private final String[] romanNumeralsForParse = { "CM", "CD", "XC", "XL", "IX", "IV", "M", "D", "C", "L", "X", "V", "I" };
    private final int[] romanNumeralValuesForParse = { 900, 400, 90, 40, 9, 4, 1000, 500, 100, 50, 10, 5, 1 };

    @Override
    public String generate(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("generate only takes numbers greater than or equal to zero and less than 4,000");
        }

        StringBuilder numerals = new StringBuilder();

        for (int i = 0; i < romanNumerals.length; i++) {
            number = appendRomanNumeral(number, numerals, i);
        }

        return numerals.toString();
    }

    private int appendRomanNumeral(int number, StringBuilder numerals, int romanNumeralIndex) {
        int romanNumeralValue = romanNumeralValues[romanNumeralIndex];
        int result = number / romanNumeralValue;

        for (int i = 0; i < result; i++) {
            numerals.append(romanNumerals[romanNumeralIndex]);
        }

        number -= result * romanNumeralValue;
        return number;
    }

    @Override
    public int parse(String numeral) {
        if (isBlank(numeral)) {
            throw new IllegalArgumentException("Numeral cannot be blank");
        }

        int total = 0;

        for (int i = 0; i < romanNumeralsForParse.length; i++) {
            int matches = countMatches(numeral, romanNumeralsForParse[i]);
            total += matches * romanNumeralValuesForParse[i];

            numeral = remove(numeral, romanNumeralsForParse[i]);
        }

        return total;
    }
}
