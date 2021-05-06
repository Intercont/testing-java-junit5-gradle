package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void testandoInjecaoDeDependencia(TestInfo testInfo) {
        System.out.println("Teste em Execução: " + testInfo.getDisplayName());
    }
}
