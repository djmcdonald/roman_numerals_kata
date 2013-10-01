package bbc.roman_numerals.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class RomanNumeral {
    private String romanNumeral;

    // For Jaxb
    RomanNumeral() {}

    public RomanNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral;
    }

    @XmlValue
    public String getRomanNumeral() {
        return romanNumeral;
    }
}
