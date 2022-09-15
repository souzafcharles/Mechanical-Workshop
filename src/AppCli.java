import entities.Vehicle;
import services.VehicleService;

import java.util.Scanner;

public class AppCli {
    private static Scanner scanner = new Scanner(System.in);

    private static VehicleService vehicleService = new VehicleService();

    public static void execute() {
        createVehicleMock();

        int option = 0;

        while (option != 3) {
            option = getMainMenuOption();

            switch (option) {

                // [1] entities.Mechanic submenu
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

                // [2] entities.Vehicle submenu
                case 2:
                    System.out.println("\n===== VEHICLE SUBMENU =====\n");
                    option = getSubmenuOption();

                    switch (option) {

                        // [2][1] Register a vehicle
                        case 1:
                            vehicleService.getVehicleData();
                            break;

                        case 2:
                            break;

                        case 3:
                            vehicleService.findAll();
                            option = 0;
                            break;

                        case 4:
                            break;

                        case 5:
                            break;

                        // Invalid options vehicle menu
                        default:
                            System.out.println("\n*-*-*- WARNING! *-*-*-*-*\nINVALID option. Try again\n*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                    }
                    break;

                // [3] Exit
                case 3:
                    System.out.println("Program CLOSED. See you later!");
                    break;

                // Invalid options main menu
                default:
                    System.out.println("\n*-*-*- WARNING! *-*-*-*-*\nINVALID option. Try again\n*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
        }
    }

    private static void createVehicleMock() {
        vehicleService.addVehicle(new Vehicle(
                "SC", "000", "São Carlos", "SP", Vehicle.VehicleType.toEnum("Sport"),
                "Peugeot", "RCZ", 2022, 2, 4, Vehicle.FuelType.FLEX, "Yellow", "Led light"));

        vehicleService.addVehicle(new Vehicle(
                "SC", "010", "Votuporanga", "SP", Vehicle.VehicleType.toEnum("SUV"),
                "Renault", "Duster", 2021, 4, 5, Vehicle.FuelType.GAS, "White", "Leather seat"));

        vehicleService.addVehicle(new Vehicle(
                "SC", "1", "J", "SP", Vehicle.VehicleType.toEnum("Sedan"),
                "Fiat", "Argo", 2020, 4, 5, Vehicle.FuelType.ALCOHOL, "Black", "None"));
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
