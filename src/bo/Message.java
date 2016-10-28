package bo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Benjamin on 2015-11-06.
 */
@Entity
@Table(name = "message")
@NamedQueries({
        @NamedQuery(name = "Message.findMessages", query = "from Message where user = :user and receiver =:userTo and status =:status order by created asc "),
        @NamedQuery(name = "Message.findAllMessagesInConversation", query = "from Message where (user = :user and receiver = :userTo) or (user=:userTo and receiver=:user) and status =:status order by created asc "),
        @NamedQuery(name = "Message.findMessagesSendFromAndToUser", query = "from Message where user = :user or receiver =:userTo order by created desc "),
})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long messageId ;

    private String text ;

    private String subtitle ;

    private Date created;

    private MessageStatus status;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId",nullable = false)
    private User user ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiverId",nullable = false)
    private User receiver ;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User userTo) {
        this.receiver = userTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}
