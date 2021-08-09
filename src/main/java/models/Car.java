package models;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Car {
    private String address;
    private String make;
    private String model;
    private String year;
    private String engine;
    private String fuel;
    private String gear;
    private String wD;
    private String doors;
    private String seats;
    private String clasS;
    private String fuelConsumption;
    private String carRegNumber;
    private String price;
    private String distanceIncluded;
    private String typeFeature;
    private String about;


    public Car setAddress(String address) {
        this.address = address;
        return this;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Car setYear(String year) {
        this.year = year;
        return this;
    }

    public Car setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car setGear(String gear) {
        this.gear = gear;
        return this;
    }

    public Car setWD(String wD) {
        this.wD = wD;
        return this;
    }

    public Car setDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public Car setSeats(String seats) {
        this.seats = seats;
        return this;
    }

    public Car setClasS(String clasS) {
        this.clasS = clasS;
        return this;
    }

    public Car setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public Car setCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
        return this;
    }

    public Car setPrice(String price) {
        this.price = price;
        return this;
    }

    public Car setDistanceIncluded(String distanceIncluded) {
        this.distanceIncluded = distanceIncluded;
        return this;
    }

    public Car setTypeFeature(String typeFeature) {
        this.typeFeature = typeFeature;
        return this;
    }

    public Car setAbout(String about) {
        this.about = about;
        return this;
    }
}
