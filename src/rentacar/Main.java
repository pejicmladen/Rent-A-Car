package rentacar;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import rentacar.domain.CarModel;
import rentacar.repository.CarRepository;
import rentacar.repository.connection.DatabaseAccess;
import rentacar.repository.impl.CarRepositoryImpl;
import rentacar.ui.form.MainForm;


/**
 * @author mlade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        JFrame MainForm = new MainForm();
        MainForm.setVisible(true);


//        DatabaseAccess db = new DatabaseAccess();
//        try {
//            db.connectDatabase();
//            List<CarModel> cm = new CarRepositoryImpl().getAllCars();
//
//            System.out.println(cm.size());
//
//            for (CarModel Car :
//                    cm) {
//                System.out.println(Car.toString());
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            db.disconnectDatabase();
//        }




    }
}
