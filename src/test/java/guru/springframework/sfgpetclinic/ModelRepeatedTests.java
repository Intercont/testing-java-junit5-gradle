package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeated")
public interface ModelRepeatedTests {

    @BeforeEach
    default void testandoInjecaoDeDependencia(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Teste em Execução: " + testInfo.getDisplayName() + ": " +
                "Repetição " + repetitionInfo.getCurrentRepetition() + " de " + repetitionInfo.getTotalRepetitions() + " repetições");
    }

}
