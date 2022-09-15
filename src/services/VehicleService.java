package services;

import entities.Vehicle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VehicleService {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Vehicle> vehicles = new LinkedList<>();

    private Vehicle getPlateData() {
        System.out.print(" 1. Letters plate: ");
        String lettersPlate = scanner.nextLine();

        System.out.print(" 2. Numbers plate: ");
        String numbersPlate = scanner.nextLine();

        System.out.print(" 3. City plate: ");
        String cityPlate = scanner.nextLine();

        System.out.print(" 4. State plate: ");
        String statePlate = scanner.nextLine();

        return new Vehicle(lettersPlate, numbersPlate, cityPlate, statePlate);
    }

    public Vehicle getVehicleData(Vehicle vehicleToValidate) {
        System.out.print(" 5. Vehicle type: Sedan, Sport, SUV or Other? ");
        String vehicleTypeString = scanner.nextLine();

        Vehicle.VehicleType vehicleType;
        if (vehicleTypeString.equals("Sedan") || vehicleTypeString.equals("Sport") || vehicleTypeString.equals("SUV"))
            vehicleType = Vehicle.VehicleType.toEnum(vehicleTypeString);
        else
            vehicleType = Vehicle.VehicleType.toEnum("Other");

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

        System.out.print(" 11. Vehicle fuel type: Alcohol, Flex, Gas or Other? ");
        scanner.nextLine();
        String fuelTypeString = scanner.nextLine();

        Vehicle.FuelType fuelType;
        if (fuelTypeString.equals("Alcohol") || fuelTypeString.equals("Flex") || fuelTypeString.equals("Gas"))
            fuelType = Vehicle.FuelType.toEnum(fuelTypeString);
        else
            fuelType = Vehicle.FuelType.toEnum("Other");

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

        return new Vehicle(lettersPlate, numbersPlate, cityPlate, statePlate,
                vehicleType, brand, model, year, doors, seats, fuelType, color, accessories);
    }

    private boolean vehiclePlateIsNull(Vehicle vehiclePlate) {
        return vehiclePlate.getLettersPlate().isEmpty() || vehiclePlate.getNumbersPlate().isEmpty() ||
                vehiclePlate.getCityPlate().isEmpty() || vehiclePlate.getStatePlate().isEmpty();
    }

    public int vehiclePosition(Vehicle vehicleToFind) {
        int position = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.equals(vehicleToFind))
                return position;
            position++;
        }
        return -1;
    }

    public void vehicleToAdd() {
        System.out.println("\nFill vehicle data:");

        Vehicle vehiclePlate = getPlateData();

        if (vehiclePlateIsNull(vehiclePlate))
            System.out.println("\nThere is a null vehicle plate field. Please fill the input fields with a valid data.");

        else {
            int checkPosition = vehiclePosition(vehiclePlate);

            if (checkPosition != -1)
                System.out.println("\nThe vehicle exists in the system. Try again.");

            else {
                Vehicle vehicle = getVehicleData(vehiclePlate);
                addVehicle(vehicle);
                System.out.println("\nVehicle successfully added to the system!");
            }
        }
    }

    public void vehicleToUpdate() {
        System.out.println("\nFill vehicle data:");

        Vehicle vehiclePlate = getPlateData();

        if (vehiclePlateIsNull(vehiclePlate))
            System.out.println("\nThere is a null vehicle plate field. Please fill the input fields with a valid data.");

        else {
            int checkPosition = vehiclePosition(vehiclePlate);

            if (checkPosition == -1)
                System.out.println("\nThe vehicle does not exists in the system. Try again.");

            else {
                Vehicle vehicle = getVehicleData(vehiclePlate);
                updateVehicle(checkPosition, vehicle);
                System.out.println("\nVehicle successfully updated in the system!");
            }
        }
    }

    public void vehicleToFind() {
        if (vehicles.isEmpty())
            System.out.println("\nThere is no vehicles on the system.");

        else {
            System.out.println("\nFill plate data:");

            Vehicle vehiclePlate = getPlateData();

            if (vehiclePlateIsNull(vehiclePlate))
                System.out.println("\nThere is a null vehicle plate field. Please fill the input fields with a valid data.");

            else {
                int checkPosition = vehiclePosition(vehiclePlate);

                if (checkPosition == -1)
                    System.out.println("\nThe vehicle does not exists in the system. Try again.");

                else {
                    System.out.println(findOne(checkPosition));
                }
            }
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void updateVehicle(int position, Vehicle vehicle) {
        vehicles.set(position, vehicle);
    }

    public void findAll() {
        if (vehicles.isEmpty())
            System.out.println("\nThere is no vehicles on the system.");
        else
            vehicles.forEach(System.out::println);
    }

    public Vehicle findOne(int vehiclePosition) {
        return vehicles.get(vehiclePosition);
    }
}
