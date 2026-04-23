package rentacar.repository.impl;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import rentacar.domain.CarModel;
import rentacar.domain.request.CarSearchModel;
import rentacar.repository.CarRepository;
import rentacar.repository.connection.DatabaseAccess;

/**
 *
 * @author mlade
 */
public class CarRepositoryImpl implements CarRepository{

    private static final Connection conn = DatabaseAccess.getConnection();

    @Override
    public List<CarModel> getAllCars() {
        List<CarModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars ORDER BY make; ");

            while (rs.next())
                list.add(new CarModel(Integer.parseInt(rs.getString(1)), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(13),rs.getString(14),rs.getInt(5),rs.getInt(6),rs.getInt(9),rs.getInt(11),rs.getDouble(8),rs.getString(10),rs.getBoolean(12)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CarModel> getAllCars(CarSearchModel car) {
        List<CarModel> list = getAllCars();
        List<CarModel> containingList = new ArrayList<>();

        for (CarModel cm :
                list) {
            if ((car.getYear() == null || cm.getYear() >= car.getYear()) &&
                    (car.getMake() == null || cm.getMake().toLowerCase().contains(car.getMake().toLowerCase())) &&
                    (car.getModel() == null || cm.getModel().toLowerCase().contains(car.getModel().toLowerCase())) &&
                    (car.getAutomatic() == null || Boolean.parseBoolean(car.getAutomatic()) == cm.isAutomatic()) &&
                    (car.getPrice() == null || cm.getPrice() <= car.getPrice()) &&
                    (car.getPower() == null || cm.getPower() >= car.getPower()) &&
                    (car.getDoors() == null || cm.getDoors() >= car.getDoors())) containingList.add(cm);
        }

        return containingList;
    }

    @Override
    public CarModel getCar(int carId) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE car_id = '"+ carId +"' ");

            if (rs.next())
                return new CarModel(Integer.parseInt(rs.getString(1)), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(13),rs.getString(14),rs.getInt(5),rs.getInt(6),rs.getInt(9),rs.getInt(11),rs.getDouble(8),rs.getString(10),rs.getBoolean(12));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(CarModel cm) {
        CarModel cmSQL = new CarModel();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE car_id = '" + cm.getCar_id() +"' ");

            if (rs.next()) {
                cmSQL.setCar_id(Integer.parseInt(rs.getString(1)));
                cmSQL.setLicence_plate(rs.getString(2));
                cmSQL.setMake(rs.getString(3));
                cmSQL.setModel(rs.getString(4));
                cmSQL.setYear(rs.getInt(5));
                cmSQL.setEngine_capacity(rs.getInt(6));
                cmSQL.setColor(rs.getString(7));
                cmSQL.setPrice(rs.getDouble(8));
                cmSQL.setDoors(rs.getInt(9));
                cmSQL.setSize(rs.getString(10));
                cmSQL.setPower(rs.getInt(11));
                cmSQL.setAutomatic(rs.getBoolean(12));
                cmSQL.setFuel(rs.getString(13));
                cmSQL.setImage(rs.getString(14));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("CarSQL " + cmSQL.getSize());
        System.out.println("Car " + cm.getSize());


        if (cm.getLicence_plate() == null || cm.getLicence_plate().equals("null") || cm.getLicence_plate().equals("")) cm.setLicence_plate(cmSQL.getLicence_plate());
        if (cm.getMake() == null || cm.getMake().equals("null") || cm.getMake().equals("")) cm.setMake(cmSQL.getMake());
        if (cm.getModel() == null || cm.getModel().equals("null") || cm.getModel().equals("")) cm.setModel(cmSQL.getModel());
        if (cm.getYear() == 0) cm.setYear(cmSQL.getYear());
        if (cm.getEngine_capacity() == 0) cm.setEngine_capacity(cmSQL.getEngine_capacity());
        if (cm.getColor() == null || cm.getColor().equals("null") || cm.getColor().equals("")) cm.setColor(cmSQL.getColor());
        if (cm.getPrice() == 0.0) cm.setPrice(cmSQL.getPrice());
        if (cm.getDoors() == 0.0) cm.setDoors(cmSQL.getDoors());
        if (cm.getSize() == null || cm.getSize().equals("null") || cm.getSize().equals("")) cm.setSize(cmSQL.getSize());
        if (cm.getPower() == 0.0) cm.setPower(cmSQL.getPower());
        if (!cm.isAutomatic()) cm.setAutomatic(cmSQL.isAutomatic());
        if (cm.getFuel() == null || cm.getFuel().equals("null") || cm.getFuel().equals("")) cm.setFuel(cmSQL.getFuel());
        if (cm.getImage() == null  || cm.getImage().equals("")) cm.setImage((cmSQL.getImage()));

        String query = "UPDATE cars SET licence_plate = ?, make = ?, model = ?, year = ?, engine_capacity = ?, color = ?, price = ?, doors = ?, size = ?, power = ?, automatic = ?, fuel = ?, image = ? " +
                "WHERE car_id = ? ";

        try {
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, cm.getLicence_plate());
            st.setString(2, cm.getMake());
            st.setString(3, cm.getModel());
            st.setInt(4,cm.getYear());
            st.setInt(5,cm.getEngine_capacity());
            st.setString(6, cm.getColor());
            st.setDouble(7,cm.getPrice());
            st.setInt(8, cm.getDoors());
            st.setString(9,cm.getSize());
            st.setInt(10, cm.getPower());
            st.setBoolean(11, cm.isAutomatic());
            st.setString(12, cm.getFuel());
            st.setString(13, cm.getImage());
            st.setString(14, String.valueOf(cm.getCar_id()));

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("CarRepositoryImpl Update odradjen");
    }

    @Override
    public void delete(int carId) {
        String query = "DELETE FROM cars WHERE car_id = ? ";

        try {
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, String.valueOf(carId));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(CarModel cm) {
        String query = "INSERT INTO cars (licence_plate, make, model, year, engine_capacity, color, price, doors, size, power, automatic, fuel, image /*, car_id*/) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?/*, ?*/) ;";

        try {
            PreparedStatement st = conn.prepareStatement(query);


            st.setString(1, cm.getLicence_plate());
            st.setString(2, cm.getMake());
            st.setString(3, cm.getModel());
            st.setInt(4,cm.getYear());
            st.setInt(5,cm.getEngine_capacity());
            st.setString(6, cm.getColor());
            st.setDouble(7,cm.getPrice());
            st.setInt(8, cm.getDoors());
            st.setString(9,cm.getSize());
            st.setInt(10, cm.getPower());
            st.setBoolean(11, cm.isAutomatic());
            st.setString(12, cm.getFuel());
            st.setString(13, cm.getImage());
            //st.setString(14, String.valueOf(cm.getCar_id()));

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CarModel> getAllAvailableCars(LocalDate startDate, LocalDate endDate) {
        List<CarModel> list = new ArrayList<>();
        
        String start_date = "NULL";
        String end_date = "NULL";
        
        if(startDate!=null){
            start_date = "'"+startDate.toString()+"'";
        }
        
        if(endDate!=null){
            end_date = "'"+endDate.toString()+"'";
        }
           

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE car_id NOT IN " +
                    "(SELECT car_id FROM contracts " +
                    "WHERE (("+start_date+" BETWEEN start_date AND end_date) OR ("+end_date+" BETWEEN start_date AND end_date)) " +
                    "OR ((start_date BETWEEN "+start_date+" AND "+end_date+") OR (end_date BETWEEN "+start_date+" AND "+end_date+"))) " +
                    "ORDER BY make ");

            while (rs.next())
                list.add(new CarModel(Integer.parseInt(rs.getString(1)), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(13),rs.getString(14),rs.getInt(5),rs.getInt(6),rs.getInt(9),rs.getInt(11),rs.getDouble(8),rs.getString(10),rs.getBoolean(12)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CarModel> getAllAvailableCars(LocalDate start_date, LocalDate end_date, CarSearchModel car) {
        List<CarModel> list = getAllAvailableCars(start_date,end_date);
        List<CarModel> containingList = new ArrayList<>();



        for (CarModel cm :
                list) {
            if ((car.getYear() == null || cm.getYear() >= car.getYear()) &&
                    (car.getMake() == null || cm.getMake().toLowerCase().contains(car.getMake().toLowerCase())) &&
                    (car.getModel() == null || cm.getModel().toLowerCase().contains(car.getModel().toLowerCase())) &&
                    (car.getAutomatic() == null || Boolean.parseBoolean(car.getAutomatic()) == cm.isAutomatic()) &&
                    (car.getPrice() == null || cm.getPrice() <= car.getPrice()) &&
                    (car.getPower() == null || cm.getPower() >= car.getPower()) &&
                    (car.getDoors() == null || cm.getDoors() >= car.getDoors())) containingList.add(cm);
        }


        return containingList;
    }

    @Override
    public List<String> getUnavailableDates(int carId) {
        List<String> unavailableDates = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT start_date, end_date FROM contracts " +
                    "WHERE car_id = '"+carId+"' " +
                    "ORDER BY start_date ");

            while (rs.next()) {
                LocalDate start_date = LocalDate.parse(rs.getString(1));
                LocalDate end_date = LocalDate.parse(rs.getString(2));

                for (int i = 0; i <= start_date.until(end_date, ChronoUnit.DAYS); i++) {
                    unavailableDates.add(start_date.plusDays(i).toString());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return unavailableDates;
    }
    

    

}
