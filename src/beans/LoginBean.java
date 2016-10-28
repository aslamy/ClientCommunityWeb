package beans;

import controlller.ManagerController;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by Benjamin on 2015-11-07.
 */


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    public LoginBean(){

    }

    private  boolean loggedIn;

    public  long  userId;

    private String userName ;

    private String password ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String doLogin() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ManagerController controller = new ManagerController() ;
        Long userId = controller.login(userName,password);
        if (userId>-1) {
            this.userId= userId;
            loggedIn = true;

        } else {
            this.userId = -1;
            loggedIn = false;
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Username or password is incorrect!",
                            "Please Try Again!"));
            return null;
        }

        return "pages/index?faces-redirect=true";
    }

    public String doLogout(){


        loggedIn = false ;
        userId = -1 ;
        ((HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false)).invalidate();
        return "/login?faces-redirect=true";
    }
}
