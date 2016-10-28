package bo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Benjamin on 2015-11-09.
 */
public class CommunicationHandler {

    private static final String URI ="http://130.237.84.17:7080/communityservice/resource/";


    public User getUserbyId(Long userId) {
        RestCommunication communication = new RestCommunication();
        String data = communication.read(URI+"users/"+userId);
        RestConverter converter = RestConverter.getInstance();
        return converter.JsonToUser(data);
    }

    public FriendShip getFriendShip(long userId,long friendId) {
        RestCommunication communication = new RestCommunication();
        String data = communication.read(URI+"users/"+userId+"/friends/"+friendId);
        RestConverter converter = RestConverter.getInstance();
        return converter.JsonToFriendShip(data);
    }

    public boolean requestFriendShip(long userId,long friendId) {

        RestCommunication communication = new RestCommunication();
        RestConverter converter = RestConverter.getInstance();

        String data = communication.read(URI+"users/"+userId);
        User user = converter.JsonToUser(data);

        data = communication.read(URI+"users/"+friendId);
        User friend = converter.JsonToUser(data);

        FriendShip friendShip = new FriendShip(user,friend,FriendShipStatus.REQUESTED,new Date());
        String jsonData = converter.toJson(friendShip);
        String jsonFriend = communication.create(URI+"users/"+userId+"/friends",jsonData);

        friendShip = new FriendShip(friend,user,FriendShipStatus.ONWAIT,new Date());
        jsonData = converter.toJson(friendShip);
        String jsonUser = communication.create(URI+"users/"+friendId+"/friends",jsonData);

        if(jsonFriend!=null && jsonUser!=null){
            return true ;
        }
        return false ;
    }

    public boolean acceptFriendShip(long userId,long friendId) {
        RestCommunication communication = new RestCommunication();
        RestConverter converter = RestConverter.getInstance();

        String data = communication.read(URI+"users/"+userId);
        User user = converter.JsonToUser(data);

        data = communication.read(URI+"users/"+friendId);
        User friend = converter.JsonToUser(data);

        FriendShip friendShip = new FriendShip(user,friend,FriendShipStatus.FRIEND,new Date());
        String jsonData = converter.toJson(friendShip);
        String jsonFriend = communication.update(URI+"users/"+userId+"/friends",jsonData);

        friendShip = new FriendShip(friend,user,FriendShipStatus.FRIEND,new Date());
        jsonData = converter.toJson(friendShip);
        String jsonUser = communication.update(URI+"users/"+friendId+"/friends",jsonData);

        if(jsonFriend!=null && jsonUser!=null){
            return true ;
        }
        return false ;
    }

    public boolean denyFriendShip(long userId,long friendId) {
        RestCommunication communication = new RestCommunication();
        String data = communication.delete(URI+"users/"+userId+"/friends/"+friendId);
        String data1 = communication.delete(URI+"users/"+friendId+"/friends/"+userId);

        if(data!=null && data1!=null){
            return true ;
        }
        return false ;
    }



    public boolean sendMessage(long userId ,long receiverId,String text){

        Message message = new Message();
        message.setText(text);
        message.setCreated(new Date());
        message.setStatus(MessageStatus.UNREAD);
        try {
            RestConverter converter = RestConverter.getInstance();
            String data = converter.toJson(message);
            RestCommunication communication = new RestCommunication();
            communication.create(URI + "users/" + userId + "/messages/"+receiverId, data);
            return true;
        }catch (Exception e){
            return false ;
        }
    }


    public ArrayList<Message> findMessages(long userId , long receiverId, MessageStatus status){
        RestCommunication communication = new RestCommunication();
        String data = communication.read(URI+"users/"+userId+"/messages/receiver/"+receiverId+"/direction/both");
        RestConverter converter = RestConverter.getInstance();
        ArrayList<Message> tempList = (ArrayList<Message>) converter.JsonToMessageList(data);
        ArrayList<Message> messageList = new ArrayList<>();
        if(tempList!=null){
        for (Message message:tempList) {
            if(message.getStatus().equals(status)) {
                messageList.add(message);
                }
            }
        }

        return messageList ;
    }

    public ArrayList<Message> findInbox(long userId){
        RestCommunication communication = new RestCommunication();
        String data = communication.read(URI+"users/"+userId+"/messages/direction/both");
        RestConverter converter = RestConverter.getInstance();
        ArrayList<Message> messageList = (ArrayList<Message>) converter.JsonToMessageList(data);
        return messageList ;
    }

    public int countFriendRequest(long userId, FriendShipStatus status){

        ArrayList<FriendShip> friendShipList = findFriendRequest(userId);
        int count = 0 ;
        if(friendShipList!=null){
            for (FriendShip friendShip: friendShipList) {
                if (friendShip.getStatus().equals(status)) {
                    count = count + 1;
                }
            }
        }
        return count ;

    }

    public ArrayList<FriendShip> findFriendRequest(long userId){

        RestCommunication communication = new RestCommunication();
        RestConverter converter = RestConverter.getInstance();

        String data = communication.read(URI+"users/"+userId+"/friends");
       ArrayList<FriendShip> friendShips = (ArrayList<FriendShip>) converter.JsonToFriendShipList(data);

        return friendShips ;
    }
}
