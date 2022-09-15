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
                            getVehicleData();
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

    private static Vehicle validatePlate() {
        System.out.print(" 1. Letters plate: ");
        scanner.nextLine();
        String lettersPlate = scanner.nextLine();

        System.out.print(" 2. Numbers plate: ");
        String numbersPlate = scanner.nextLine();

        System.out.print(" 3. City plate: ");
        String cityPlate = scanner.nextLine();

        System.out.print(" 4. State plate: ");
        String statePlate = scanner.nextLine();

        Vehicle vehicleToCheck = new Vehicle(lettersPlate, numbersPlate, cityPlate, statePlate);

        if (vehicleService.vehicleExists(vehicleToCheck))
            return null;
        return vehicleToCheck;
    }

    private static void getVehicleData() {
        System.out.println("\nFill vehicle data:");

        Vehicle vehicleToValidate = validatePlate();

        if (vehicleToValidate == null)
            System.out.println("\nThe vehicle exists in the system. Try again.");
        else {
            System.out.print(" 5. Vehicle type: Sedan, Sport or SUV? ");
            String vehicleTypeString = scanner.nextLine();

            if (vehicleTypeString.equals("Sedan") ||
                    vehicleTypeString.equals("Sport") || vehicleTypeString.equals("SUV")) {
                Vehicle.VehicleType vehicleType = Vehicle.VehicleType.toEnum(vehicleTypeString);

                System.out.print(" 6. Vehicle brand: ");
                String brand = scanner.nextLine();

                System.out.print(" 7. Vehicle model: ");
                String model = scanner.nextLine();

                System.out.print(" 8. Vehicle year: ");
                Integer year = scanner.nextInt();

                System.out.print(" 9. Vehicle doors: ");
                Integer doors = scanner.nextInt();

                System.out.print(" 10. Vehicle seats: ");
                Integer seats = scanner.nextInt();

                System.out.print(" 11. Vehicle fuel type: Alcohol, Flex or Gas? ");
                scanner.nextLine();
                String fuelTypeString = scanner.nextLine();

                if (fuelTypeString.equals("Alcohol") || fuelTypeString.equals("Flex") || fuelTypeString.equals("Gas")) {
                    Vehicle.FuelType fuelType = Vehicle.FuelType.toEnum(fuelTypeString);

                    System.out.print(" 12. Vehicle color: ");
                    String color = scanner.nextLine();

                    System.out.print(" 13. Vehicle accessories: ");
                    String accessories = scanner.nextLine();

                    String lettersPlate = vehicleToValidate.getLettersPlate();
                    String numbersPlate = vehicleToValidate.getNumbersPlate();
                    String cityPlate = vehicleToValidate.getCityPlate();
                    String statePlate = vehicleToValidate.getStatePlate();

                    Vehicle vehicle = new Vehicle(lettersPlate, numbersPlate, cityPlate, statePlate,
                            vehicleType, brand, model, year, doors, seats, fuelType, color, accessories);

                    vehicleService.addVehicle(vehicle);
                    System.out.println("\nVehicle successfully added to the system!");
                } else {
                    System.out.println("\nThe fuel type " + fuelTypeString + " doesn't exist in the system. Try again");
                }
            } else {
                System.out.println("\nThe vehicle type " + vehicleTypeString + " doesn't exist in the system. Try again");
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
