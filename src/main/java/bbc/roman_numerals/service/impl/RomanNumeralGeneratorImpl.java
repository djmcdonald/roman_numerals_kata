package bbc.roman_numerals.service.impl;

import bbc.roman_numerals.service.RomanNumeralGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang3.StringUtils.*;

@Component
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

    enum RomanNumerals {
        M("M", 1000),
        CM("CM", 900),
        D("D", 500),
        CD("CD", 400),
        C("C", 100),
        XC("XC", 90),
        L("L", 50),
        XL("XL", 40),
        X("X", 10),
        IX("IX", 9),
        V("V", 5),
        IV("IV", 4),
        I("I", 1);

        private final String numeral;
        private final int value;

        RomanNumerals(String numeral, int value) {
            this.numeral = numeral;
            this.value = value;
        }

        String getNumeral() {
            return numeral;
        }

        int getValue() {
            return value;
        }
    }

    @Override
    public String generate(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("generate only takes numbers greater than or equal to zero and less than 4,000");
        }

        StringBuilder numerals = new StringBuilder();

        for (RomanNumerals romanNumeral : numeralsForGenerate()) {
            int romanNumeralValue = romanNumeral.getValue();
            int result = number / romanNumeralValue;

            for (int i = 0; i < result; i++) {
                numerals.append(romanNumeral.getNumeral());
            }

            number -= result * romanNumeralValue;
        }

        return numerals.toString();
    }

    private List<RomanNumerals> numeralsForGenerate() {
        return newArrayList(RomanNumerals.M, RomanNumerals.CM,
                RomanNumerals.D, RomanNumerals.CD, RomanNumerals.C,
                RomanNumerals.XC, RomanNumerals.L, RomanNumerals.XL,
                RomanNumerals.X, RomanNumerals.IX, RomanNumerals.V,
                RomanNumerals.IV, RomanNumerals.I);
    }

    @Override
    public int parse(String numeral) {
        if (isBlank(numeral)) {
            throw new IllegalArgumentException("Numeral cannot be blank");
        }

        int total = 0;

        for (RomanNumerals romanNumeral : numeralsForParse()) {
            int matches = countMatches(numeral, romanNumeral.getNumeral());
            total += matches * romanNumeral.getValue();
            numeral = remove(numeral, romanNumeral.getNumeral());
        }

        return total;
    }

    private List<RomanNumerals> numeralsForParse() {
        return newArrayList(RomanNumerals.CM, RomanNumerals.CD,
                RomanNumerals.XC, RomanNumerals.XL, RomanNumerals.IX,
                RomanNumerals.IV, RomanNumerals.M, RomanNumerals.D,
                RomanNumerals.C, RomanNumerals.L, RomanNumerals.X,
                RomanNumerals.V, RomanNumerals.I);
    }
}
