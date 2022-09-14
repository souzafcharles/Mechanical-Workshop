package services;

import entities.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class VehicleService {
    private List<Vehicle> vehicles = new LinkedList<>();

    public boolean vehicleExists(Vehicle vehicle) {
        for (Vehicle v : vehicles) {
            if (v.equals(vehicle))
                return true;
        }

        return false;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void findAll() {
        if (vehicles.isEmpty())
            System.out.println("\nThere is no vehicles on the system.");
        else
            vehicles.forEach(System.out::println);
    }
}
