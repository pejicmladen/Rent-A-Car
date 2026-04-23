package rentacar.domain;

import java.time.LocalDate;

/**
 *
 * @author mlade
 */
public class ContractsModel {
    
    private int contract_id, user_id, car_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private Double total_price;
    private boolean signed, approved;

    public ContractsModel(int contract_id, int user_id, int car_id, LocalDate start_date, LocalDate end_date, Double total_price, boolean signed, boolean approved) {
        this.contract_id = contract_id;
        this.user_id = user_id;
        this.car_id = car_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_price = total_price;
        this.signed = signed;
        this.approved = approved;
    }

    public ContractsModel(int user_id, int car_id, LocalDate start_date, LocalDate end_date, Double total_price, boolean signed, boolean approved) {
        this.user_id = user_id;
        this.car_id = car_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_price = total_price;
        this.signed = signed;
        this.approved = approved;
    }

    public ContractsModel(ContractsModel cm) {
        this.contract_id = cm.contract_id;
        this.user_id = cm.user_id;
        this.car_id = cm.car_id;
        this.start_date = cm.start_date;
        this.end_date = cm.end_date;
        this.total_price = cm.total_price;
        this.signed = cm.signed;
        this.approved = cm.approved;
    }

    public int getContract_id() {
        return contract_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public boolean isSigned() {
        return signed;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
    
}
