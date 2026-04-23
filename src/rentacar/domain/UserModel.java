package rentacar.domain;

/**
 *
 * @author mlade
 */
public class UserModel {
    
    private int user_id;
    private String username, email, password, first_name, last_name, phone_number, personal_number, image;
    private boolean admin;

    public UserModel(int user_id, String username, String email, String password, String first_name, String last_name, String phone_number, String personal_number, String image, boolean admin) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.personal_number = personal_number;
        this.image = image;
        this.admin = admin;
    }
    
    public UserModel(UserModel user) {
        this.user_id = user.user_id;
        this.username = user.username;
        this.email = user.email;
        this.password = user.password;
        this.first_name = user.first_name;
        this.last_name = user.last_name;
        this.phone_number = user.phone_number;
        this.personal_number = user.personal_number;
        this.image = user.image;
        this.admin = user.admin;
    }

    public UserModel() {
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPersonal_number() {
        return personal_number;
    }

    public String getImage() {
        return image;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPersonal_number(String personal_number) {
        this.personal_number = personal_number;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    
}
