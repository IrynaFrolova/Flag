package ua.edu.znu.flags;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

public class ExampleTest {

    @Test
    void testWithAssumptions() {
        // Припущення: значення має бути позитивним
        int value = -1;

        // Тест буде пропущено, якщо значення не є позитивним
        Assumptions.assumeTrue(value > 0, "Значення не є позитивним");

        // Якщо припущення виконано, тест буде виконано
        assertTrue(value > 0, "Значення повинно бути більше за нуль");
    }
}
