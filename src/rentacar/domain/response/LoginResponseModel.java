package rentacar.domain.response;

public class LoginResponseModel {
    private boolean successful;
    private String userId;

    public LoginResponseModel(boolean successful, String userId) {
        this.successful = successful;
        this.userId = userId;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getUserId() {
        return userId;
    }
}
