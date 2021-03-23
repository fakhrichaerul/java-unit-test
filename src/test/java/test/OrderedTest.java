package test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private int counter = 0;

    @BeforeAll
        // Karna test instance PER_CLASS jadi bisa digunakan diluar static method
    void beforeAll() {

    }

    @AfterAll
    void afterAll() {

    }

    @Test
    @Order(1)
    void test3() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    void test1() {
        counter++;
        System.out.println(counter);
    }
}
