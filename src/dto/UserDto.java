package dto;

import bo.User;

/**
 * Created by Benjamin on 2015-11-07.
 */
public class UserDto {
    public UserDto(long userId,String username,String password, String firstName, String lastName, String email) {
        this.username = username;
        this.userId = userId ;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDto(User user) {

        if(user!=null){
        this.userId = user.getUserId();
        this.username = user.getUserName();
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        }
    }

    private String username;

    private String password ;

    private long userId;

    private String firstName;

    private String lastName;

    private String email;


    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getUsername() {
        return username;
    }

    public long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
