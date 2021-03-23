package test;

import fakhri.chaerul.insan.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import test.resolver.RandomParameterResolver;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {

    public Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
    }
}
