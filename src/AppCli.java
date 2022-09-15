import entities.Vehicle;
import services.VehicleService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppCli {
    private static final Scanner scanner = new Scanner(System.in);

    private static final VehicleService vehicleService = new VehicleService();

    public static void execute() {
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
                        case 1:
                            break;

                        case 2:
                            break;

                        case 3:
                            option = 0;
                            break;

                        case 4:
                            break;

                        case 5:
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
