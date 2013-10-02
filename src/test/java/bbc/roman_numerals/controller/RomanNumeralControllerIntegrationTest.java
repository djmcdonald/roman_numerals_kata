package bbc.roman_numerals.controller;

import bbc.roman_numerals.config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class RomanNumeralControllerIntegrationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        mockMvc = webAppContextSetup(wac).alwaysExpect(status().isOk()).build();
    }

    @Test
    public void testParse() throws Exception {
        mockMvc.perform(get("/parse/IV"))
                .andExpect(xpath("/arabicNumeral").string("4"));
    }

    @Test
    public void testGenerate() throws Exception {
        mockMvc.perform(get("/generate/10"))
                .andExpect(xpath("/romanNumeral").string("X"));
    }
}
