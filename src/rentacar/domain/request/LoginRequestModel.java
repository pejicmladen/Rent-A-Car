package rentacar.domain.request;

public class LoginRequestModel {
    private String identification, password;

    public LoginRequestModel(String identification, String password) {
        this.identification = identification;
        this.password = password;
    }

    public String getIdentification() {
        return identification;
    }

    public String getPassword() {
        return password;
    }
}
