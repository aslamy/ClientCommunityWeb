package beans;

import bo.FriendShipStatus;
import controlller.AccountController;
import controlller.CommunicationController;
import dto.PostDto;
import dto.UserDto;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Benjamin on 2015-11-09.
 */
@ManagedBean(name = "people")
@SessionScoped
public class PeopleBean implements Serializable {

    private UserDto user ;

    public UserDto getUser() {
        return user;
    }

    private  Boolean isSendMessageClicked ;

    private String messageText ;

    private String friendRequest ;

    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean ;


    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getFriendRequest() {
        CommunicationController controller = new CommunicationController();
        FriendShipStatus status =controller.getFriendShipStatus(loginBean.getUserId(),user.getUserId());

        if(status!=null) {

            if (status.equals(FriendShipStatus.FRIEND)) {
                friendRequest = "Friend";

            } else if (status.equals(FriendShipStatus.REQUESTED)) {
                friendRequest = "Friend Request Sent";
            }else if(status.equals(FriendShipStatus.ONWAIT)){
                friendRequest = "Confirm Friend Request";
            }else{
                friendRequest = "Add Friend";
            }
        }else{
            friendRequest = "Add Friend";
        }

        return friendRequest;
    }

    public void setFriendRequest(String friendRequest) {
        this.friendRequest = friendRequest;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


    public String showUserPage(Long userId){
        AccountController controller = new AccountController();
        user = controller.getUserbyId(userId);
        isSendMessageClicked = false ;
        return "/pages/people?faces-redirect=true";
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Boolean getSendMessageClicked() {
        System.out.println("getSendMessageClicked");
        return isSendMessageClicked;
    }

    public void sendMessageIsClicked() {
        System.out.println("sendMessageIsClicked");
        isSendMessageClicked = true;
    }

    public void sendMessage(){

        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("form:messageId");
        System.out.println("Value: "+value);
        if(messageText!=null && !messageText.trim().isEmpty()){
            CommunicationController controller =  new CommunicationController();
            boolean isSend = controller.sendMessage(loginBean.getUserId(),user.getUserId(),messageText);
            if(isSend){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Message is send!", ""));
               messageText = null;
            }

        }

    }

    public void sendFriendRequest(){
        if(friendRequest.equals("Add Friend")){
            CommunicationController controller = new CommunicationController();
            controller.requestFriendShip(loginBean.getUserId(),user.getUserId());

        }
    }

    public ArrayList<PostDto> getAllPosts(){

        AccountController controller = new AccountController() ;
        return controller.getAllPosts(user.getUserId());

    }
}
