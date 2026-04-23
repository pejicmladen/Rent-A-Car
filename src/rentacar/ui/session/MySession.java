package rentacar.ui.session;

import rentacar.domain.UserModel;
import rentacar.domain.response.LoginResponseModel;

/**
 *
 * @author mlade
 */
public class MySession {
    private static MySession instance;
    private LoginResponseModel loginUser;

    public static MySession getInstance(){
        if (instance == null) instance = new MySession();
        return instance;
    }

    public LoginResponseModel getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginResponseModel loginUser) {
        this.loginUser = loginUser;
    }

    public void signOut(){
        if (instance != null) {
            instance = null;
            loginUser = null;
        }else{
            System.out.println("Vec odjavljen!");
        }
    }
    
    public static MySession instanceValue(){
        return instance;
    }
}
