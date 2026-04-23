package rentacar.domain;

/**
 *
 * @author mlade
 */
public class CarModel {
    
    private int car_id;
    private String licence_plate;
    private String make;
    private String model;
    private String color;
    private String fuel;
    private String image;
    private int year;
    private int engine_capacity;
    private int doors;
    private int power;
    private double price;
    private String size;
    private boolean automatic;

    public CarModel(int car_id, String licence_plate, String make, String model, String color, String fuel, String image, int year, int engine_capacity, int doors, int power, double price, String size, boolean automatic) {
        this.car_id = car_id;
        this.licence_plate = licence_plate;
        this.make = make;
        this.model = model;
        this.color = color;
        this.fuel = fuel;
        this.image = image;
        this.year = year;
        this.engine_capacity = engine_capacity;
        this.doors = doors;
        this.power = power;
        this.price = price;
        this.size = size;
        this.automatic = automatic;
    }

    public CarModel(String licence_plate, String make, String model, String color, String fuel, String image, int year, int engine_capacity, int doors, int power, double price, String size, boolean automatic) {
        this.licence_plate = licence_plate;
        this.make = make;
        this.model = model;
        this.color = color;
        this.fuel = fuel;
        this.image = image;
        this.year = year;
        this.engine_capacity = engine_capacity;
        this.doors = doors;
        this.power = power;
        this.price = price;
        this.size = size;
        this.automatic = automatic;
    }

    public CarModel(CarModel car) {
        this.car_id = car.car_id;
        this.licence_plate = car.licence_plate;
        this.make = car.make;
        this.model = car.model;
        this.color = car.color;
        this.fuel = car.fuel;
        this.image = car.image;
        this.year = car.year;
        this.engine_capacity = car.engine_capacity;
        this.doors = car.doors;
        this.power = car.power;
        this.price = car.price;
        this.size = car.size;
        this.automatic = car.automatic;
    }

    public CarModel() {
    }

    public int getCar_id() {
        return car_id;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getFuel() {
        return fuel;
    }

    public String getImage() {
        return image;
    }

    public int getYear() {
        return year;
    }

    public int getEngine_capacity() {
        return engine_capacity;
    }

    public int getDoors() {
        return doors;
    }

    public int getPower() {
        return power;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngine_capacity(int engine_capacity) {
        this.engine_capacity = engine_capacity;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }


}
