package controlller;

import bo.AccountHandler;
import bo.User;
import dto.UserDto;
import java.util.ArrayList;

/**
 * Created by Benjamin on 2015-11-08.
 */
public class SearchController {

    public ArrayList<UserDto> getAllUserBeginsWith(String username) {
        AccountHandler handler = new AccountHandler() ;
        ArrayList<User> userList= handler.getAllUserBeginsWith(username);
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();
        for (User user:userList) {
            userDtoList.add(new UserDto(user));

        }
       return userDtoList;
    }
}
