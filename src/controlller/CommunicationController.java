package controlller;

import bo.*;
import dto.FriendShipDto;
import dto.MessageDto;
import dto.PostDto;
import dto.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Benjamin on 2015-11-09.
 */
public class CommunicationController {

    public boolean sendMessage(long userId, long receiverId, String text) {
        CommunicationHandler handler = new CommunicationHandler();
        return handler.sendMessage(userId, receiverId, text);
    }

    public ArrayList<MessageDto> findUnreadMessages(long userId, long userToId) {
        CommunicationHandler handler = new CommunicationHandler();
        ArrayList<Message> messages = handler.findMessages(userId, userToId, MessageStatus.UNREAD);
        ArrayList<MessageDto> messagesDto = new ArrayList<MessageDto>();
        for (Message message : messages) {
            MessageDto messageDto = new MessageDto(message);
            messagesDto.add(messageDto);
        }
        return messagesDto;
    }

    public ArrayList<UserDto> findInbox(long userId) {

        CommunicationHandler handler = new CommunicationHandler();
        ArrayList<Message> messages = handler.findInbox(userId);

        Map<String, User> userMap = new HashMap<String, User>();

        for (Message message : messages) {
            if (message.getUser().getUserId() == userId) {
                userMap.put(message.getReceiver().getUserName(), message.getReceiver());

            } else {
                userMap.put(message.getUser().getUserName(), message.getUser());
            }
        }
        List<User> userList = new ArrayList<User>(userMap.values());
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();
        for (User user : userList) {
            UserDto userDto = new UserDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public int countFriendRequest(long userId) {
        CommunicationHandler handler = new CommunicationHandler();
        return handler.countFriendRequest(userId, FriendShipStatus.ONWAIT);
    }

    public ArrayList<FriendShipDto> findAllFriendRequest(long userId) {
        CommunicationHandler handler = new CommunicationHandler();
        ArrayList<FriendShip> friendShips = handler.findFriendRequest(userId);
        ArrayList<FriendShipDto> friendShipDtos = new ArrayList<>();
        for (FriendShip friend : friendShips) {
            friendShipDtos.add(new FriendShipDto(friend));
        }
        return friendShipDtos;
    }

    public FriendShipStatus getFriendShipStatus(long userId, long friendId) {
        CommunicationHandler handler = new CommunicationHandler();
        FriendShip friendShip = handler.getFriendShip(userId, friendId);
        if (friendShip != null) {
            return handler.getFriendShip(userId, friendId).getStatus();
        }
        return null;
    }

    public boolean requestFriendShip(long userId, long friendId) {
        CommunicationHandler handler = new CommunicationHandler();
        return handler.requestFriendShip(userId, friendId);
    }

    public boolean acceptFriendShip(long userId, long friendId) {
        CommunicationHandler handler = new CommunicationHandler();
        return handler.acceptFriendShip(userId, friendId);
    }

    public boolean denyFriendShip(long userId, long friendId) {
        CommunicationHandler handler = new CommunicationHandler();
        return handler.denyFriendShip(userId, friendId);
    }
}
