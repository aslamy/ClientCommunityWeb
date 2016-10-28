package dto;

import bo.FriendShip;
import bo.FriendShipStatus;

import java.util.Date;

/**
 * Created by Benjamin on 2015-11-11.
 */
public class FriendShipDto {


    public FriendShipDto(FriendShip friendShip) {

        this.friendShipId = friendShip.getFriendShipId();
        this.created = friendShip.getCreated();
        this.status = friendShip.getStatus();


        this.friendId = friendShip.getFriend().getUserId();
        this.friendFirstName = friendShip.getFriend().getUserName();
        this.friendLastName = friendShip.getFriend().getLastName();
        this.friendUserName = friendShip.getFriend().getUserName();
        this.friendEmail = friendShip.getFriend().getEmail();
    }

    private long friendShipId;

    private Date created;

    private FriendShipStatus status;

    private Long userId;

    private Long friendId;

    private String userFirstName;

    private String userLastName;

    private String userUserName;

    private String userEmail;

    private String friendFirstName;

    private String friendLastName;

    private String friendUserName;

    private String friendEmail;

    public long getFriendShipId() {
        return friendShipId;
    }

    public void setFriendShipId(long friendShipId) {
        this.friendShipId = friendShipId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public FriendShipStatus getStatus() {
        return status;
    }

    public void setStatus(FriendShipStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFriendFirstName() {
        return friendFirstName;
    }

    public void setFriendFirstName(String friendFirstName) {
        this.friendFirstName = friendFirstName;
    }

    public String getFriendLastName() {
        return friendLastName;
    }

    public void setFriendLastName(String friendLastName) {
        this.friendLastName = friendLastName;
    }

    public String getFriendUserName() {
        return friendUserName;
    }

    public void setFriendUserName(String friendUserName) {
        this.friendUserName = friendUserName;
    }

    public String getFriendEmail() {
        return friendEmail;
    }

    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
    }
}