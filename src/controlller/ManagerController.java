package controlller;
import bo.ManagerHandler;
import bo.User;
import dto.UserDto;


public class ManagerController {

    public boolean register(UserDto userDto){
        ManagerHandler manage = new ManagerHandler();
        User user = new User();
        user.setUserName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return manage.register(user);
    }


    public long login(String userName , String password){
        ManagerHandler account = new ManagerHandler();
        long userId = account.login(userName,password);
        return userId ;
    }


}
