package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllersTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllersTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");
        assertEquals("index", controller.index(), () -> "Another expensive message, " +
                "just use lambdas into the messages if it's really needed");

        //using AssertJ
        assertThat(controller.index()).isEqualTo("index");
        assertThat(controller.index()).startsWith("in").endsWith("ex");
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
//        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "Expensive message to build" +
//                " for the tests, use lambda"); //These messages are only shown when error occurs

        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());

        //AssertJ
        assertThatThrownBy(() -> controller.oopsHandler()).isInstanceOf(ValueNotFoundException.class);

    }

    @Disabled("assertTimeout Demo")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100),
                () -> {
                    Thread.sleep(2000);
                    System.out.println("I got here running after 2000 miliseconds");
                });
    }

    @Disabled("assertTimeoutPreemptively Demo")
    @Test
    void testPreemptiveTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(100),
                () -> {
                    Thread.sleep(2000);
                    System.out.println("Will not reach this text running " +
                            "after 2000 miliseconds, because will quit after 100 milis");
                });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("IGOR".equalsIgnoreCase(System.getenv("IGOR_RUNTIME")));
    }

    @Test
    void testAssumptionTrueSucceed() {
        assumeTrue("IGOR".equalsIgnoreCase("igor"));
        System.out.println("Since it passes the assume with true value, " +
                "the execution of the test continues");
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testMeOnLinux() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledOnJre(JRE.OTHER)
    @Test
    void testMeOnJava14() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "intercont")
    @Test
    void testIfUserIntercont() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "bitufo")
    @Test
    void testIfUserBitufo() {

    }
}