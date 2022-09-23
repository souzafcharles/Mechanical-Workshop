import entities.Mechanic;
import org.junit.jupiter.api.*;
import services.MechanicService;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Mechanic Service Tests")
public class MechanicTest {

    private final MechanicService mechanicService = new MechanicService();
    @BeforeAll

    public void mockTestInitialize() {
        List<String> email1 = Arrays.asList("balthazar@email.com");
        List<String> email2 = Arrays.asList("ophilomena", "ophelia@eail.com");
        List<String> email3 = Arrays.asList("belizario@email.com", "bcrispim@email.com", "crispimbelizario@email.com");

        List<String> telephone1 = Arrays.asList("(11)11111-1111");
        List<String> telephone2 = Arrays.asList("(22)22222-2222", "(21)21211-2121");
        List<String> telephone3 = Arrays.asList("(33)33333-3333", "(31)31313-3131","(32)32323-3232");

        mechanicService.addMechanic(new Mechanic("111.111.111.11", "Balthazar Bartholomeu", "10/03/1990", "M", 1.111, email1, telephone1));
        mechanicService.addMechanic(new Mechanic("222.222.222-22", "Ophelia Philomena", "10/11/1990", "F", 2.222, email2, telephone2));
        mechanicService.addMechanic(new Mechanic("333.333.333-33", "Belizario Crispim", "10/06/1990", "M", 3.333, email3, telephone3));
    }

    @Order(1)
    @Test
    @DisplayName("Checking the number of mechanic mocked in the system test")
    public void size() {
        assertEquals(3, mechanicService.countMechanics());
    }
}
