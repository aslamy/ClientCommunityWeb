package beans;

import controlller.CommunicationController;
import dto.MessageDto;
import dto.UserDto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Benjamin on 2015-11-10.
 */
@ManagedBean(name = "chat")
@SessionScoped
public class ChatBean implements Serializable {

    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean ;

    private  long receiverId;

    private  long userId;


    private String messageText ;

    private  ArrayList<UserDto> inbox = new ArrayList<>();

    private  ArrayList<MessageDto> messages =new  ArrayList< MessageDto>() ;


    public void init(){
        inboxReceiver();
        findUnreadMessages();
    }

    public  ArrayList<UserDto> getInbox() {
        return inbox;
    }

    public  void setInbox(ArrayList<UserDto> inbox) {
        this.inbox = inbox;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }


    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public long getUserId() {
        return loginBean.getUserId();
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public ArrayList<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageDto> messages) {
        this.messages = messages;
    }


    public void sendMessage(){

        if(messageText!=null && !messageText.trim().isEmpty()){
            CommunicationController controller =  new CommunicationController();
            controller.findInbox(loginBean.getUserId())     ;
            boolean isSend = controller.sendMessage(loginBean.getUserId(),receiverId,messageText);
            if(isSend){
                messageText = null;
                inboxReceiver();
            }
            findUnreadMessages();
        }
    }


    public void findUnreadMessages(){
        CommunicationController controller = new CommunicationController();
        ArrayList<MessageDto> messageList = controller.findUnreadMessages(loginBean.getUserId(),receiverId);
        if(messageList!=null){
            messages = messageList;
        }
    }

     public void inboxReceiver(){
         CommunicationController controller = new CommunicationController();
         inbox = controller.findInbox(loginBean.getUserId());
     }


    public void showChat(long receiverId){
        this.receiverId = receiverId;
        findUnreadMessages();

    }

    public void updatePage(){
        findUnreadMessages();
        inboxReceiver();
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
}
