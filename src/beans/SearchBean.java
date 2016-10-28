package beans;

import controlller.SearchController;
import dto.UserDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Benjamin on 2015-11-08.
 */
@ManagedBean(name = "search")
@SessionScoped
public class SearchBean implements Serializable {

    private String searchText ;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public ArrayList<UserDto> userList = new ArrayList<UserDto>();


    public void getSearchedUser(){
        SearchController controller = new SearchController();
        if(searchText!=null && !searchText.trim().isEmpty()) {
            userList = controller.getAllUserBeginsWith(searchText);
        }
    }

    public ArrayList<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserDto> userList) {
        this.userList = userList;
    }


}
