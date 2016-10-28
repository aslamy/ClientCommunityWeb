package bo;
import java.util.ArrayList;
import java.util.Date;

public class AccountHandler {

	private static final String URI ="http://130.237.84.17:7080/communityservice/resource/";

	public User getUserbyId(Long userId) {
		RestCommunication communication = new RestCommunication();
		String data = communication.read(URI+"users/"+userId);
		RestConverter converter = RestConverter.getInstance();
		return converter.JsonToUser(data);
	}

	public boolean savePost(String postText, long userId) {
		Post post = new Post();
		post.setText(postText);
		post.setCreated(new Date());
		try {
			RestConverter converter = RestConverter.getInstance();
			String data = converter.toJson(post);
			RestCommunication communication = new RestCommunication();
			communication.create(URI + "users/" + userId + "/posts", data);
			return true;
		}catch (Exception e){
			return false ;
		}


	}

	public ArrayList<Post> getAllPostes(long userId) {
		RestCommunication communication = new RestCommunication();
		String data = communication.read(URI+"users/"+userId+"/posts");
		RestConverter converter = RestConverter.getInstance();
		return (ArrayList<Post>)converter.JsonToPostList(data);
	}

	public ArrayList<User> getAllUserBeginsWith(String username) {
		RestCommunication communication = new RestCommunication();
		String data = communication.read(URI+"users?username="+username);
		RestConverter converter = RestConverter.getInstance();
		return (ArrayList<User>)converter.JsonToUserList(data);
	}

	public boolean deletePost(long userId, long postId){
		try {
			RestCommunication communication = new RestCommunication();
			communication.delete(URI + "users/" + userId + "/posts/"+postId);
			return true;
		}catch (Exception e){
			return false ;
		}
	}

}



