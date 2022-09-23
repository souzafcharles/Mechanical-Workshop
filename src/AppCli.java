import entities.Mechanic;
import entities.Vehicle;
import services.MechanicService;
import services.VehicleService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppCli {
    private static final Scanner scanner = new Scanner(System.in);

    private static final MechanicService mechanicService = new MechanicService();
    private static final VehicleService vehicleService = new VehicleService();

    public static void execute() {
        createMechanicMock();
        createVehicleMock();

        int option = 0;

        while (option != 3) {
            option = getMainMenuOption();

            switch (option) {

                // [1] Mechanic submenu
                case 1:
                    System.out.println("\n===== MECHANIC SUBMENU =====\n");
                    option = getSubmenuOption();

                    switch (option) {
                        // [1][1] Register a mechanic
                        case 1:
                            mechanicService.mechanicToAdd();
                            break;
                        // [1][2] Update a mechanic
                        case 2:
                            mechanicService.mechanicToUpdate();
                            break;
                        // [1][3] Find all mechanic
                        case 3:
                            mechanicService.findAll();
                            option = 0;
                            break;
                        // [1][4] Find mechanic
                        case 4:
                            mechanicService.mechanicToFind();
                            break;
                        // [1][5] Remove mechanic
                        case 5:
                            mechanicService.mechanicToRemove();
                            break;
                        // Invalid options mechanic menu
                        default:
                            System.out.println("\n*-*-*- WARNING! *-*-*-*-*\nINVALID option. Try again\n*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                    }
                    break;

                // [2] Vehicle submenu
                case 2:
                    System.out.println("\n===== VEHICLE SUBMENU =====\n");
                    option = getSubmenuOption();

                    switch (option) {

                        // [2][1] Register a vehicle
                        case 1:
                            vehicleService.vehicleToAdd();
                            break;

                        // [2][2] Update a vehicle
                        case 2:
                            vehicleService.vehicleToUpdate();
                            break;

                        // [2][3] Find all vehicles
                        case 3:
                            vehicleService.findAll();
                            option = 0;
                            break;

                        // [2][4] Find vehicle
                        case 4:
                            vehicleService.vehicleToFind();
                            break;

                        // [2][5] Remove vehicle
                        case 5:
                            vehicleService.vehicleToRemove();
                            break;

                        // Invalid options vehicle menu
                        default:
                            System.out.println("\n*-*-*- WARNING! *-*-*-*-*\nINVALID option. Try again\n*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                    }
                    break;

                // [3] Exit
                case 3:
                    System.out.println("\nProgram CLOSED. See you later!");
                    scanner.close();
                    break;

                // Invalid options main menu
                default:
                    System.out.println("\n*-*-*- WARNING! *-*-*-*-*\nINVALID option. Try again\n*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
        }
    }

    private static void createMechanicMock() {
        List<String> email1 = Arrays.asList("balthazar@email.com");
        List<String> email2 = Arrays.asList("ophilomena", "ophelia@eail.com");
        List<String> email3 = Arrays.asList("belizario@email.com", "bcrispim@email.com", "crispimbelizario@email.com");

        List<String> telephone1 = Arrays.asList("(11)11111-1111");
        List<String> telephone2 = Arrays.asList("(22)22222-2222", "(21)21211-2121");
        List<String> telephone3 = Arrays.asList("(33)33333-3333", "(31)31313-3131", "(32)32323-3232");

        mechanicService.addMechanic(new Mechanic("111.111.111.11", "Balthazar Bartholomeu", "10/03/1990", "M", 1.111, email1, telephone1));
        mechanicService.addMechanic(new Mechanic("222.222.222-22", "Ophelia Philomena", "10/11/1990", "F", 2.222, email2, telephone2));
        mechanicService.addMechanic(new Mechanic("333.333.333-33", "Belizario Crispim", "10/06/1990", "M", 3.333, email3, telephone3));

    }

    private static void createVehicleMock() {
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

    private static int getSubmenuOption() {
        System.out.println("\t[1] Register");
        System.out.println("\t[2] Update");
        System.out.println("\t[3] List all");
        System.out.println("\t[4] List one");
        System.out.println("\t[5] Remove");

        System.out.print("\nSelect one option: ");
        return scanner.nextInt();
    }

    private static int getMainMenuOption() {
        System.out.println("\n===== MAIN MENU - MECHANICAL WORKSHOP =====\n");
        System.out.println("\t[1] Mechanic Submenu");
        System.out.println("\t[2] Vehicle Submenu");
        System.out.println("\t[3] Exit");

        System.out.print("\nSelect one option: ");
        return scanner.nextInt();
    }
}
