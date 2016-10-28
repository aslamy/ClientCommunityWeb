package beans;

import controlller.AccountController;
import dto.PostDto;
import dto.UserDto;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "account")
@SessionScoped
public class AccountBean implements Serializable{


    private UserDto userDto ;

    private String postText ;

    private String searchText ;

    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean ;


    @PostConstruct
    public void init(){
        getUser();
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void getUser(){
    AccountController controller = new AccountController();
    userDto = controller.getUserbyId(loginBean.getUserId());
}

    public void savePost(){
        AccountController controller = new AccountController();
        boolean isPosted = false ;
        if(postText!=null && !postText.trim().isEmpty()) {
            isPosted = controller.savePost(postText, loginBean.getUserId());
        }
        if(isPosted==true){
            postText = null ;
        }
    }

    public void deletePost(long postId){
        AccountController controller = new AccountController();
        controller.deletePost(loginBean.getUserId(),postId);
    }


    public ArrayList<PostDto> getAllPosts(){

        AccountController controller = new AccountController() ;
        return controller.getAllPosts(loginBean.getUserId());

    }


    public void setUser(UserDto user) {
        this.userDto = user;
    }

    public UserDto getUserDto() {
        return userDto;
    }


    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
