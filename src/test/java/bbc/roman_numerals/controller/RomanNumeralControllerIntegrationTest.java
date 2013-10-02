package bbc.roman_numerals.controller;

import bbc.roman_numerals.controller.RomanNumeralControllerIntegrationTest.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
@ActiveProfiles("test")
public class RomanNumeralControllerIntegrationTest {

    @Configuration
    @EnableWebMvc
    @ComponentScan("bbc.roman_numerals")
    @Profile("test")
    static class WebConfig {
    }

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
