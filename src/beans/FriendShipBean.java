package beans;



import bo.FriendShip;
import bo.FriendShipStatus;
import controlller.CommunicationController;
import dto.FriendShipDto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 * Created by Benjamin on 2015-11-11.
 */
@SessionScoped
@ManagedBean(name = "friendShip")
public class FriendShipBean {

    private  String countRequset ;

    private ArrayList<FriendShipDto> friendShip ;


    private final FriendShipStatus REQUESTED  = FriendShipStatus.REQUESTED;

    private final FriendShipStatus FRIEND = FriendShipStatus.FRIEND ;

    private final FriendShipStatus ONWAIT = FriendShipStatus.ONWAIT ;


    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean ;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public  String getCountRequset() {
        CommunicationController controller = new CommunicationController();
        int count  = controller.countFriendRequest(loginBean.getUserId());
        if(count<1){
            countRequset = null ;
        }else{
            countRequset = String.valueOf(count);
        }
        return countRequset;
    }

    public ArrayList<FriendShipDto> getFriendShip() {
        CommunicationController controller = new CommunicationController();
        friendShip =  controller.findAllFriendRequest(loginBean.getUserId());
        return friendShip;
    }

    public void accpetFriendShip(long friendId){
        CommunicationController controller = new CommunicationController();
        controller.acceptFriendShip(friendId,loginBean.getUserId());

    }
    public void denyFriendShip(long friendId){
        CommunicationController controller = new CommunicationController();
        controller.denyFriendShip(friendId,loginBean.getUserId());

    }


    public FriendShipStatus getREQUESTED() {
        return REQUESTED;
    }

    public FriendShipStatus getFRIEND() {
        return FRIEND;
    }

    public FriendShipStatus getONWAIT() {
        return ONWAIT;
    }
}
