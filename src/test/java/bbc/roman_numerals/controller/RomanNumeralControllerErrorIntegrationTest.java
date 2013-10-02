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
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class RomanNumeralControllerErrorIntegrationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        mockMvc = webAppContextSetup(wac).alwaysExpect(status().isBadRequest()).build();
    }

    @Test
    public void generateShouldReturnBadRequestWhenGivenZero() throws Exception {
        mockMvc.perform(get("/generate/0"));
    }

    @Test
    public void generateShouldReturnBadRequestWhenGivenGreaterThan3999() throws Exception {
        mockMvc.perform(get("/generate/4000"));
    }
}
