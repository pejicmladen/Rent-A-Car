package rentacar.repository;

import rentacar.domain.UserModel;
import rentacar.domain.request.LoginRequestModel;
import rentacar.domain.request.RegisterRequestModel;
import rentacar.domain.response.LoginResponseModel;
import rentacar.domain.response.RegisterResponseModel;

import java.util.List;

public interface UserRepository {
    RegisterResponseModel registerUser(RegisterRequestModel rrm);
    LoginResponseModel loginUser(LoginRequestModel lrm);
    LoginResponseModel update(UserModel um, String newPassword);
    UserModel getUser(int userId);
    List<UserModel> getAllUsers();
    boolean isAdmin(int userId);
}
