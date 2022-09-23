import entities.Mechanic;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.MechanicService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Order(2)
    @RepeatedTest(value = 3, name = "{displayName}: #{currentRepetition} mechanic")
    @DisplayName("Checking insertions with repeated test")
    public void populateMechanic_RepeatedTest(RepetitionInfo rep) {
        Mechanic mechanicToRepeat = new Mechanic();
        mechanicService.addMechanic(mechanicToRepeat);
        assertEquals((3 + rep.getCurrentRepetition()), mechanicService.countMechanics());
    }

    @Order(3)
    @Test
    @DisplayName("Checking update and find mechanic methods by using getters and setters with assert all")
    public void populateMechanic_TestingUpdate_GetterAndSetters() {
        Mechanic mechanicToSet = new Mechanic();

        mechanicToSet.setCpf("444.444.444-44");
        mechanicToSet.setName("Cleide Lady Neide");
        mechanicToSet.setBirthDate("10/02/1990");
        mechanicToSet.setGender("F");
        mechanicToSet.setSalary(4.444);
        mechanicToSet.addEmail("cleide@email.com");
        mechanicToSet.addTelephone("(44)44444-4444");

        mechanicService.updateMechanic(4, mechanicToSet);

        Mechanic mechanicUpdated = mechanicService.findMechanic(4);

        assertAll("Checking getters and setters...",

                () -> assertEquals("444.444.444-44", mechanicUpdated.getCpf()),
                () -> assertEquals("Cleide Lady Neide",mechanicUpdated.getName()),
                () -> assertEquals("10/02/1990",mechanicUpdated.getBirthDate()),
                () -> assertEquals("F",mechanicUpdated.getGender()),
                () -> assertEquals(4.444,mechanicUpdated.getSalary()),
                () -> assertEquals(Arrays.asList("cleide@email.com"), mechanicUpdated.getEmails()),
                () -> assertEquals(Arrays.asList("(44)44444-4444"), mechanicUpdated.getTelephones())
        );
    }

    @Order(4)
    @ParameterizedTest
    @DisplayName("Checking mechanic with parameterized test")
    @MethodSource("mechanicArguments")
    public void checkCompareMechanic(Mechanic mechanicCpf) {
        Mechanic mechanicParameterized = new Mechanic(mechanicCpf.getCpf());

        assertEquals(mechanicCpf, mechanicParameterized);
    }

    static Stream<Arguments> mechanicArguments() {
        return Stream.of(
                Arguments.arguments(new Mechanic("111.111.111.11")),
                Arguments.arguments(new Mechanic("222.222.222-22")),
                Arguments.arguments(new Mechanic("333.333.333-33"))
        );
    }

    @Order(5)
    @Test
    @DisplayName("Checking remove method")
    public void checkRemoveVehicle() {
        mechanicService.removeMechanic(5);
        mechanicService.removeMechanic(4);
        assertEquals(4, mechanicService.countMechanics());
    }
}
