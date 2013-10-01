package bbc.roman_numerals.service;

public interface RomanNumeralGenerator {
    public String generate(int number);

    public int parse(String numeral);
}
