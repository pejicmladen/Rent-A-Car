package rentacar.repository;

import java.time.LocalDate;
import java.util.List;
import rentacar.domain.CarModel;
import rentacar.domain.request.CarSearchModel;

/**
 *
 * @author mlade
 */
public interface CarRepository {
    
    List<CarModel> getAllCars();
    List<CarModel> getAllCars(CarSearchModel car);
    CarModel getCar(int carId);
    void update(CarModel cm);
    void delete(int carId);
    void add(CarModel cm);
    List<CarModel> getAllAvailableCars(LocalDate start_date, LocalDate end_date);
    List<CarModel> getAllAvailableCars(LocalDate start_date, LocalDate end_date, CarSearchModel car);
    List<String> getUnavailableDates(int carId);
}
