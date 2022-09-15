package services;

import entities.Vehicle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VehicleService {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Vehicle> vehicles = new LinkedList<>();

    private Vehicle validatePlate() {
        System.out.print(" 1. Letters plate: ");
        String lettersPlate = scanner.nextLine();

        System.out.print(" 2. Numbers plate: ");
        String numbersPlate = scanner.nextLine();

        System.out.print(" 3. City plate: ");
        String cityPlate = scanner.nextLine();

        System.out.print(" 4. State plate: ");
        String statePlate = scanner.nextLine();

        Vehicle vehicleToCheck = new Vehicle(lettersPlate, numbersPlate, cityPlate, statePlate);

        if (vehicleExists(vehicleToCheck))
            return null;
        return vehicleToCheck;
    }

    public void getVehicleData() {
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

                    List<String> accessories = new ArrayList<>();
                    char answer = 'y';
                    while (answer != 'n') {
                        System.out.print(" 13. Vehicle accessory: ");
                        String accessory = scanner.nextLine();
                        accessories.add(accessory);

                        System.out.print("   Do you want add another accessory (y/n)? ");
                        answer = scanner.nextLine().charAt(0);
                    }

                    String lettersPlate = vehicleToValidate.getLettersPlate();
                    String numbersPlate = vehicleToValidate.getNumbersPlate();
                    String cityPlate = vehicleToValidate.getCityPlate();
                    String statePlate = vehicleToValidate.getStatePlate();

                    Vehicle vehicle = new Vehicle(lettersPlate, numbersPlate, cityPlate, statePlate,
                            vehicleType, brand, model, year, doors, seats, fuelType, color, accessories);

                    addVehicle(vehicle);
                    System.out.println("\nVehicle successfully added to the system!");
                } else {
                    System.out.println("\nThe fuel type " + fuelTypeString + " doesn't exist in the system. Try again");
                }
            } else {
                System.out.println("\nThe vehicle type " + vehicleTypeString + " doesn't exist in the system. Try again");
            }
        }
    }

    public boolean vehicleExists(Vehicle vehicleToFind) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.equals(vehicleToFind))
                return true;
        }
        return false;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null)
            System.out.println("\nVehicle is null. Please fill the input fields with a valid data.");
        else
            vehicles.add(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        if (vehicle == null)
            System.out.println("\nVehicle is null. Please fill the input fields with a valid data.");
//        else
//            vehicles.set(vehicle);
    }

    public void findAll() {
        if (vehicles.isEmpty())
            System.out.println("\nThere is no vehicles on the system.");
        else
            vehicles.forEach(System.out::println);
    }
}
