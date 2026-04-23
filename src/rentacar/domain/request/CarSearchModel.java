package rentacar.domain.request;

/**
 *
 * @author mlade
 */
public class CarSearchModel {

    private Integer year, doors, power;
    private String make, model, automatic, color;
    private Double price;

    public CarSearchModel(Integer year, Integer doors, Integer power, String make, String model, String automatic, Double price) {
        this.year = year;
        this.doors = doors;
        this.power = power;
        this.make = make;
        this.model = model;
        this.automatic = automatic;
        this.price = price;
    }

    public CarSearchModel(String make) {
        this.make = make;
    }

    public CarSearchModel(Integer year, String make, String model, String automatic, Double price) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.automatic = automatic;
        this.price = price;
    }

    public CarSearchModel() {
    }

    public Integer getYear() {
        return year;
    }

    public Integer getDoors() {
        return doors;
    }

    public Integer getPower() {
        return power;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getAutomatic() {
        return automatic;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAutomatic(String automatic) {
        this.automatic = automatic;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

