package test;

import entities.Vehicle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.VehicleService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Vehicle Service Tests")
class VehicleServiceTest {
    private final VehicleService vehicleService = new VehicleService();

    @BeforeAll
    public void mockTestInitialize() {
        List<String> accessories1 = Arrays.asList("Automatic", "Led light", "Leather seat", "Air conditioning", "Wifi");
        List<String> accessories2 = Arrays.asList("Automatic", "Led light", "Air conditioning");
        List<String> accessories3 = Arrays.asList("Leather seat", "Air conditioning");

        vehicleService.addVehicle(new Vehicle(
                "SC", "000", "São Carlos", "SP", Vehicle.VehicleType.toEnum("Sport"),
                "Peugeot", "RCZ", 2022, 2, 4, Vehicle.FuelType.FLEX, "Yellow", accessories1));

        vehicleService.addVehicle(new Vehicle(
                "SC", "010", "Votuporanga", "SP", Vehicle.VehicleType.toEnum("SUV"),
                "Renault", "Duster", 2021, 4, 5, Vehicle.FuelType.GAS, "White", accessories2));

        vehicleService.addVehicle(new Vehicle(
                "SC", "020", "Test", "devTest", Vehicle.VehicleType.toEnum("Sedan"),
                "Fiat", "Argo", 2020, 4, 5, Vehicle.FuelType.ALCOHOL, "Black", accessories3));
    }

    @Order(1)
    @Test
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    @DisplayName("Checking the number of vehicles mocked in the system test")
    public void size() {
        assertEquals(3, vehicleService.countVehicles());
    }

    @Order(2)
    @RepeatedTest(value = 3, name = "{displayName}: #{currentRepetition} vehicle")
    @DisplayName("Checking insertions with repeated test")
    public void populateVehicles_RepeatedTest(RepetitionInfo rep) {
        Vehicle vehicleToRepeat = new Vehicle();
        vehicleService.addVehicle(vehicleToRepeat);
        assertEquals((3 + rep.getCurrentRepetition()), vehicleService.countVehicles());
    }

    @Order(3)
    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_18)
    @DisplayName("Checking update and find vehicle methods by using getters and setters with assert all")
    public void populateVehicle_TestingUpdate_GetterAndSetters() {
        Vehicle vehicleToSet = new Vehicle();

        vehicleToSet.setLettersPlate("ABC");
        vehicleToSet.setNumbersPlate("000");
        vehicleToSet.setCityPlate("Campinas");
        vehicleToSet.setStatePlate("SP");
        vehicleToSet.setVehicleType(Vehicle.VehicleType.toEnum("Other"));
        vehicleToSet.setBrand("Renault");
        vehicleToSet.setModel("Captur");
        vehicleToSet.setYear(2022);
        vehicleToSet.setDoors(4);
        vehicleToSet.setSeats(5);
        vehicleToSet.setFuelType(Vehicle.FuelType.OTHER);
        vehicleToSet.setColor("Blue");
        vehicleToSet.addAccessory("Radio");
        vehicleToSet.addAccessory("Led light");

        vehicleService.updateVehicle(4, vehicleToSet);

        Vehicle vehicleUpdated = vehicleService.findVehicle(4);

        assertAll("Checking getters and setters...",
                () -> assertEquals("ABC", vehicleUpdated.getLettersPlate()),
                () -> assertEquals("000", vehicleUpdated.getNumbersPlate()),
                () -> assertEquals("Campinas", vehicleUpdated.getCityPlate()),
                () -> assertEquals("SP", vehicleUpdated.getStatePlate()),
                () -> assertEquals(Vehicle.VehicleType.OTHER, vehicleUpdated.getVehicleType()),
                () -> assertEquals("Renault", vehicleUpdated.getBrand()),
                () -> assertEquals("Captur", vehicleUpdated.getModel()),
                () -> assertEquals(2022, vehicleUpdated.getYear()),
                () -> assertEquals(4, vehicleUpdated.getDoors()),
                () -> assertEquals(5, vehicleUpdated.getSeats()),
                () -> assertEquals(Vehicle.FuelType.OTHER, vehicleUpdated.getFuelType()),
                () -> assertEquals("Blue", vehicleUpdated.getColor()),
                () -> assertEquals(Arrays.asList("Radio", "Led light"), vehicleUpdated.getAccessories())
        );
    }

    @Order(4)
    @ParameterizedTest
    @DisplayName("Checking vehicles with parameterized test")
    @MethodSource("vehicleArguments")
    public void checkCompareVehicle(Vehicle vehiclePlate) {
        Vehicle vehicleParameterized = new Vehicle(vehiclePlate.getLettersPlate(), vehiclePlate.getNumbersPlate(),
                vehiclePlate.getCityPlate(), vehiclePlate.getStatePlate());

        assertEquals(vehiclePlate, vehicleParameterized);
    }

    static Stream<Arguments> vehicleArguments() {
        return Stream.of(
                Arguments.arguments(new Vehicle("SC", "000", "São Carlos", "SP")),
                Arguments.arguments(new Vehicle("SC", "010", "Votuporanga", "SP")),
                Arguments.arguments(new Vehicle("SC", "020", "Test", "devTest"))
        );
    }

    @Order(5)
    @Test
    @DisplayName("Checking remove method")
    public void checkRemoveVehicle() {
        vehicleService.removeVehicle(5);
        vehicleService.removeVehicle(4);
        assertEquals(4, vehicleService.countVehicles());
    }
}
