package bbc.roman_numerals.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class ArabicNumeral {
    private int numeral;

    // For Jaxb
    ArabicNumeral() {}

    public ArabicNumeral(int numeral) {
        this.numeral = numeral;
    }

    @XmlValue
    public int getNumeral() {
        return numeral;
    }
}
