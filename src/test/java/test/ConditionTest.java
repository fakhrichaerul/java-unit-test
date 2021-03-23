package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

@Tag("integration-test")
public class ConditionTest {

    @Test
    void testSystemProperty(){
        Properties properties = System.getProperties();
        properties.forEach((key, value) ->
                System.out.println(key+""+value));
    }

    @Test
    @EnabledOnOs(value = {OS.WINDOWS})
    void testEnableRunOnWindows(){

    }

    @Test
    @DisabledOnOs(value = {OS.WINDOWS})
    void testDisableRunOnWindows(){

    }

    @Test
    @EnabledOnJre(value = {JRE.JAVA_11})
    void testEnableOnJre(){

    }

    @Test
    @DisabledOnJre(value = {JRE.JAVA_11})
    void testDisableOnJre(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    void testEnableOnJava11to15(){

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    void testDisableForJava11to15(){

    }

    @Test
    @EnabledIfSystemProperties({
                @EnabledIfSystemProperty(
                        named = "java.vendor", matches = "Oracle Corporation"
                )
            })
    void testEnableOnJavaVendorOracle(){

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(
                    named = "java.vendor", matches = "Oracle Corporation"
            )
    })
    void testDisableOnJavaVendorOracle(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    void testEnableOnProfileDev(){

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    void testDisabledOnProfileDev(){

    }

}
