package test;

import fakhri.chaerul.insan.Calculator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@DisplayNameGeneration(value = SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    // Mehtod harus static
    public static void beforeAll(){
        System.out.println("Before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After all");
    }

    @BeforeEach
    public void setUP(){
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After each");
    }


//    @DisplayName("Test untuk Calculator Class")
    @Test
    public void testAddSuccess() {
        Integer result = calculator.add(10, 10);

//        if(result != 20){
//            throw new RuntimeException("Test Gagal");
//        }

        assertEquals(20, result);
    }

//    @DisplayName("Test Skenario sukses untuk method add(Integer, Integer)")
    @Test
    public void testDivideSucces(){
        Integer result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed(){
        assertThrows(IllegalArgumentException.class, ()->{
            calculator.divide(100,0);
        });
    }

    @Test
    @Disabled
    public void testComingSoon(){

    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if(!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan dev");
        }

        // Unit test untuk DEV
    }

    @Test
    public void testAssumption(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        // Unit test untuk DEV
    }
}
