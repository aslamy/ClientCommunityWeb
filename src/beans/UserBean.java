package beans;

import javax.faces.bean.*;
import java.io.Serializable;

/**
 * Created by Benjamin on 2015-11-06.
 */
@ManagedBean(name = "user")
@RequestScoped
public class UserBean implements Serializable {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
