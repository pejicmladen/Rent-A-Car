package rentacar.repository.impl;

import rentacar.domain.CarModel;
import rentacar.domain.ContractsModel;
import rentacar.domain.response.RegisterResponseModel;
import rentacar.repository.ContractRepository;
import rentacar.repository.connection.DatabaseAccess;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class ContractRepositoryImpl implements ContractRepository {

    private static final Connection conn = DatabaseAccess.getConnection();
    @Override
    public RegisterResponseModel add(ContractsModel cm) {
        boolean inUse = false;

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE car_id NOT IN " +
                    "(SELECT car_id FROM contracts " +
                    "WHERE (('"+cm.getStart_date()+"' BETWEEN start_date AND end_date) OR ('"+cm.getEnd_date()+"' BETWEEN start_date AND end_date)) " +
                    "OR ((start_date BETWEEN '"+cm.getStart_date()+"' AND '"+cm.getEnd_date()+"') OR (end_date BETWEEN '"+cm.getStart_date()+"' AND '"+cm.getEnd_date()+"'))) " +
                    "AND car_id = '"+cm.getCar_id()+"' ");

            if (!rs.next())
//                list.add(new CarModel(UUID.fromString(rs.getString(1)), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(7),rs.getString(13),rs.getString(14),rs.getInt(5),rs.getInt(6),rs.getInt(9),rs.getInt(11),rs.getDouble(8),rs.getString(10),rs.getBoolean(12)));
                return new RegisterResponseModel(false,"Већ је заузет аутомобил");

        } catch (SQLException e) {
            e.printStackTrace();
//            return new RegisterResponseModel(false,"Већ је заузет аутомобил");
        }

        String query = "INSERT INTO contracts (user_id, car_id, start_date, end_date, total_price, signed, approved /*,contract_id*/) " +
                "VALUES (?, ?, '"+cm.getStart_date()+"', '"+cm.getEnd_date()+"', ?, ?, ? /*,?*/) ;";

        try {
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, String.valueOf(cm.getUser_id()));
            st.setString(2, String.valueOf(cm.getCar_id()));
//            st.setString(4, cm.getStart_date().toString());
//            st.setString(5,cm.getEnd_date().toString());
            st.setDouble(3,cm.getTotal_price());
            st.setBoolean(4, cm.isSigned());
            st.setBoolean(5,cm.isApproved());
            //st.setString(6, String.valueOf(cm.getContract_id()));

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new RegisterResponseModel(true,"Уговор креиран, чека одобрење");

    }

    @Override
    public List<ContractsModel> getAllContracts() {
        List<ContractsModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contracts ORDER BY start_date ");

            while (rs.next())
                list.add(new ContractsModel(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)), LocalDate.parse(rs.getString(4)),LocalDate.parse(rs.getString(5)),rs.getDouble(6),rs.getBoolean(7),rs.getBoolean(8)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ContractsModel> getAllPendingContracts() {
        List<ContractsModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contracts WHERE approved = false ORDER BY start_date ");

            while (rs.next())
                list.add(new ContractsModel(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3)), LocalDate.parse(rs.getString(4)),LocalDate.parse(rs.getString(5)),rs.getDouble(6),rs.getBoolean(7),rs.getBoolean(8)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void ContractApproval(boolean isApproved, String contractId) {
        if (isApproved) {
            String query = "UPDATE contracts SET approved = true WHERE contract_id = ? ";
            try {
                PreparedStatement st = conn.prepareStatement(query);

                st.setString(1, contractId);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            String query = "DELETE FROM contracts WHERE contract_id = ? ";
            try {
                PreparedStatement st = conn.prepareStatement(query);

                st.setString(1, contractId.toString());
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ContractsModel> getAllUserContracts(String userId) {
        List<ContractsModel> list = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM contracts WHERE user_id = '"+userId+"' ");

            while (rs.next())
                list.add(new ContractsModel(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)), LocalDate.parse(rs.getString(4)),LocalDate.parse(rs.getString(5)),rs.getDouble(6),rs.getBoolean(7),rs.getBoolean(8)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public HashMap<CarModel, ContractsModel> getAllUserContractsForUser(String userId) {
        HashMap<CarModel, ContractsModel> resultMap = new HashMap<>();

        try {
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT contracts.car_id, cars.licence_plate, cars.make, cars.model, cars.color, cars.fuel, cars.image, cars.year, cars.engine_capacity, cars.doors, cars.power, cars.price, cars.size, cars.automatic, " +
                    "contracts.contract_id, contracts.user_id, contracts.start_date, contracts.end_date, contracts.total_price, contracts.signed, contracts.approved " +
                    "FROM contracts " +
                    "JOIN cars ON contracts.car_id = cars.car_id " +
                    "WHERE contracts.user_id = '"+userId+"';");

            while (resultSet.next()) {

                int carId = resultSet.getInt("car_id");
                String licencePlate = resultSet.getString("licence_plate");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                String fuel = resultSet.getString("fuel");
                String image = resultSet.getString("image");
                int year = resultSet.getInt("year");
                int engineCapacity = resultSet.getInt("engine_capacity");
                int doors = resultSet.getInt("doors");
                int power = resultSet.getInt("power");
                double price = resultSet.getDouble("price");
                String size = resultSet.getString("size");
                boolean automatic = resultSet.getBoolean("automatic");


                int contractId = resultSet.getInt("contract_id");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                double totalPrice = resultSet.getDouble("total_price");
                boolean signed = resultSet.getBoolean("signed");
                boolean approved = resultSet.getBoolean("approved");


                CarModel carModel = new CarModel(carId, licencePlate, make, model, color, fuel, image, year, engineCapacity, doors, power, price, size, automatic);
                ContractsModel contractsModel = new ContractsModel(contractId, Integer.parseInt(userId), carId, startDate, endDate, totalPrice, signed, approved);


                resultMap.put(carModel, contractsModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public void ApproveAllContracts() {
        String query = "UPDATE contracts SET approved = true";
            try {
                PreparedStatement st = conn.prepareStatement(query);

                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
