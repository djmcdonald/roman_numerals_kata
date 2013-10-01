package bbc.roman_numerals.service.impl;

import bbc.roman_numerals.service.RomanNumeralGenerator;

public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

    private final String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private final int[] romanNumeralValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    @Override
    public String generate(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("generate only takes numbers greater than or equal to zero and less than 4,000");
        }

        StringBuilder numerals = new StringBuilder();

        for (int i = 0; i < romanNumerals.length; i++) {
            int romanNumeralValue = romanNumeralValues[i];
            int result = number / romanNumeralValue;

            for (int j = 0; j < result; j++) {
                numerals.append(romanNumerals[i]);
            }

            number -= result * romanNumeralValue;
        }

        return numerals.toString();
    }

    @Override
    public int parse(String numeral) {
        return 0;
    }
}
