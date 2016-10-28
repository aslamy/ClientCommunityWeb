package dto;

import bo.Message;
import bo.MessageStatus;

import java.util.Date;

/**
 * Created by Benjamin on 2015-11-10.
 */
public class MessageDto {

    public MessageDto(long messageId, String text, String subtitle, Date created, MessageStatus status, Long userId, Long receiverId) {
        this.messageId = messageId;
        this.text = text;
        this.subtitle = subtitle;
        this.created = created;
        this.status = status;
        this.userId = userId;
        this.receiverId = receiverId;
    }

    public MessageDto(Message message) {
        this.messageId = message.getMessageId();
        this.text = message.getText();
        this.subtitle = message.getSubtitle();
        this.created = message.getCreated();
        this.status = message.getStatus();

        this.userId = message.getUser().getUserId();
        this.userFirstName = message.getUser().getFirstName();
        this.userLastName = message.getUser().getLastName();
        this.userUserName = message.getUser().getUserName();

        this.receiverId = message.getReceiver().getUserId();
        this.receiverFirstName = message.getReceiver().getFirstName();
        this.receiverLastName = message.getReceiver().getLastName();
        this.receiverUserName = message.getReceiver().getUserName();
    }

    private long messageId;

    private String text;

    private String subtitle;

    private Date created;

    private MessageStatus status;

    private Long userId;

    private String userFirstName;

    private String userLastName;

    private String userUserName;

    private Long receiverId;

    private String receiverFirstName;

    private String receiverLastName;

    private String receiverUserName;


    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserUserName() {
        return userUserName;
    }

    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getReceiverUserName() {
        return receiverUserName;
    }

    public void setReceiverUserName(String receiverUserName) {
        this.receiverUserName = receiverUserName;
    }
}

