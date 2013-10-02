package bbc.roman_numerals.exception;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RomanNumeralExceptionResolverTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Mock
    private Object handler;

    @Mock
    private Exception exception;

    private RomanNumeralExceptionResolver romanNumeralExceptionResolver;

    @Before
    public void setup() {
        romanNumeralExceptionResolver = new RomanNumeralExceptionResolver();
    }

    @Test
    public void shouldSet400BadRequest() {
        romanNumeralExceptionResolver.resolveException(httpServletRequest, httpServletResponse, handler, exception);
        verify(httpServletResponse).setStatus(400);
    }
}
