package bbc.roman_numerals.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("bbc.roman_numerals")
@EnableWebMvc
public class ApplicationConfig {
}
