package bo;

import util.HibernateUtil;

import javax.persistence.EntityManager;


import java.util.ArrayList;

public class ManagerHandler {

	private static final String URI ="http://130.237.84.17:7080/communityservice/resource/";

	public Boolean register(User user){
		try{
			RestCommunication communication = new RestCommunication();
			RestConverter converter = RestConverter.getInstance();
			String data = converter.toJson(user);
			String result = communication.create(URI+"users",data);
			if(result.isEmpty()){
				return false;
			}
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public long login(String userName , String password){
		RestCommunication communication = new RestCommunication();
		String data = communication.read(URI+"users?username="+userName+"&password="+password);
		RestConverter converter = RestConverter.getInstance();
		ArrayList<User> userList = (ArrayList<User>)converter.JsonToUserList(data);
		if(userList!=null && userList.size()==1){
			return userList.get(0).getUserId();
		}
		return -1;
	}

}
