package beans;

import controlller.ManagerController;
import dto.UserDto;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Benjamin on 2015-11-07.
 */
@ManagedBean(name="register")
public class RegisterBean implements Serializable {

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

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String doRegister() {

        ManagerController controller = new ManagerController();

        UserDto userDto = new UserDto(0,username,password,
                firstName,lastName,email);

        boolean isReg = controller.register(userDto);
        if (!isReg) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Register error!",
                            "Please Try Again!"));
            return null;
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Register success!", ""));
        return "pages/index?faces-redirect=true";

    }
}
