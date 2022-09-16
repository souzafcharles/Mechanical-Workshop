package entities;

import java.util.*;

public class Vehicle {
    public enum VehicleType {
        SEDAN("Sedan"),
        SPORT_CAR("Sport"),
        SUV("SUV"),
        OTHER("Other");

        private String vehicleType;

        VehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public static VehicleType toEnum(String value) {
            return Arrays.stream(VehicleType.values())
                    .filter(c -> value.equals(c.toString()))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        @Override
        public String toString() {
            return vehicleType;
        }
    }

    public enum FuelType {
        ALCOHOL("Alcohol"),
        FLEX("Flex"),
        GAS("Gas"),
        OTHER("Other");

        private String fuelType;

        FuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public static FuelType toEnum(String value) {
            return Arrays.stream(FuelType.values())
                    .filter(c -> value.equals(c.toString()))
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }

        @Override
        public String toString() {
            return fuelType;
        }
    }

    private String lettersPlate;
    private String numbersPlate;
    private String cityPlate;
    private String statePlate;
    private VehicleType vehicleType;
    private String brand;
    private String model;
    private Integer year;
    private Integer doors;
    private Integer seats;
    private FuelType fuelType;
    private String color;
    private List<String> accessories = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String lettersPlate, String numbersPlate, String cityPlate, String statePlate) {
        this.lettersPlate = lettersPlate;
        this.numbersPlate = numbersPlate;
        this.cityPlate = cityPlate;
        this.statePlate = statePlate;
    }

    public Vehicle(String lettersPlate, String numbersPlate, String cityPlate, String statePlate,
                   VehicleType vehicleType, String brand, String model, Integer year, Integer doors, Integer seats,
                   FuelType fuelType, String color, List<String> accessories) {
        this.lettersPlate = lettersPlate;
        this.numbersPlate = numbersPlate;
        this.cityPlate = cityPlate;
        this.statePlate = statePlate;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.doors = doors;
        this.seats = seats;
        this.fuelType = fuelType;
        this.color = color;
        this.accessories = accessories;
    }

    public String getLettersPlate() {
        return lettersPlate;
    }

    public void setLettersPlate(String lettersPlate) {
        this.lettersPlate = lettersPlate;
    }

    public String getNumbersPlate() {
        return numbersPlate;
    }

    public void setNumbersPlate(String numbersPlate) {
        this.numbersPlate = numbersPlate;
    }

    public String getCityPlate() {
        return cityPlate;
    }

    public void setCityPlate(String cityPlate) {
        this.cityPlate = cityPlate;
    }

    public String getStatePlate() {
        return statePlate;
    }

    public void setStatePlate(String statePlate) {
        this.statePlate = statePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getAccessories() {
        return accessories;
    }

    public void addAccessory(String accessory) {
        accessories.add(accessory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(lettersPlate, vehicle.lettersPlate) && Objects.equals(numbersPlate, vehicle.numbersPlate)
                && Objects.equals(cityPlate, vehicle.cityPlate) && Objects.equals(statePlate, vehicle.statePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lettersPlate, numbersPlate, cityPlate, statePlate);
    }

    public String listAccessories() {
        StringBuilder result = new StringBuilder();

        for (String accessory : accessories) {
            result.append("\n\t- ").append(accessory);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "\nPlate: " + lettersPlate + numbersPlate + " - " + cityPlate + "/" + statePlate +
                "\n   Type: " + vehicleType +
                "\n   Brand: " + brand + "\tModel: " + model + "  (" + year + ")" +
                "\n   Doors: " + doors +
                "\n   Seats: " + seats +
                "\n   Fuel type: " + fuelType +
                "\n   Color: " + color +
                "\n   Accessories:" + listAccessories() +
                "\n\n-----------------------------";
    }
}
