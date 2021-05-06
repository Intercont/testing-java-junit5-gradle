package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("repeated")
class PersonRepeatedTest implements ModelRepeatedTests {

    @RepeatedTest(value = 10, name = RepeatedTest.DISPLAY_NAME_PLACEHOLDER + " : " + RepeatedTest.CURRENT_REPETITION_PLACEHOLDER + " - " + RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        //do nothing
    }

    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 10, name = RepeatedTest.DISPLAY_NAME_PLACEHOLDER + " : " + RepeatedTest.CURRENT_REPETITION_PLACEHOLDER + " - " + RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
    @DisplayName("Assignment 68 - JUnit Dependency Injection")
    void myAssignmentRepeatedTest() {
        System.out.println();
    }
}