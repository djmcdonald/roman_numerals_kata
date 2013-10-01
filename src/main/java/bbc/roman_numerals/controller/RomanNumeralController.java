package bbc.roman_numerals.controller;

import bbc.roman_numerals.domain.ArabicNumeral;
import bbc.roman_numerals.domain.RomanNumeral;
import bbc.roman_numerals.service.RomanNumeralGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RomanNumeralController {
    private final RomanNumeralGenerator romanNumeralGenerator;

    @Autowired
    public RomanNumeralController(RomanNumeralGenerator romanNumeralGenerator) {
        this.romanNumeralGenerator = romanNumeralGenerator;
    }

    @RequestMapping(value = "/generate/{number}", method = RequestMethod.GET)
    @ResponseBody
    public RomanNumeral generate(@PathVariable int number) {
        return new RomanNumeral(romanNumeralGenerator.generate(number));
    }

    @RequestMapping(value = "/parse/{numeral}", method = RequestMethod.GET)
    @ResponseBody
    public ArabicNumeral parse(@PathVariable String numeral) {
        return new ArabicNumeral(romanNumeralGenerator.parse(numeral));
    }
}
