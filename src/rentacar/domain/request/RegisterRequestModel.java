package rentacar.domain.request;

import java.util.UUID;

public class RegisterRequestModel {
    private String username, password, email, name, lastName, phoneNumber, personalNumber;
    private int user_id;

    public RegisterRequestModel(String username, String password, String email, int user_id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.user_id = user_id;
    }

    public RegisterRequestModel(String username, String password, String email, String name, String lastName, String phoneNumber, String personalNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.personalNumber = personalNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
}
