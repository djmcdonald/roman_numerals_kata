package bbc.roman_numerals.exception;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RomanNumeralExceptionResolver implements HandlerExceptionResolver {
    private final Logger logger = Logger.getLogger(RomanNumeralExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.error("Exception in service", ex);
        response.setStatus(400);

        return new ModelAndView();
    }
}
