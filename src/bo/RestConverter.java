package bo;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.google.gson.reflect.TypeToken;

        import java.lang.reflect.Type;
        import java.util.List;

public class RestConverter {

    private static RestConverter singleton = new RestConverter( );
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    private RestConverter(){ }

    public static RestConverter getInstance( ) {
        return singleton;
    }

    public  User JsonToUser(String jsonData) {

        return gson.fromJson(jsonData,User.class);
    }

    public  List<User> JsonToUserList(String jsonData) {
        Type listType = new TypeToken<List<User>>() {}.getType();
        return gson.fromJson(jsonData,listType);
    }

    public  List<Post> JsonToPostList(String jsonData) {
        Type listType = new TypeToken<List<Post>>() {}.getType();
        return gson.fromJson(jsonData,listType);
    }

    public String toJson(Object object){
        return gson.toJson(object);
    }

    public  FriendShip JsonToFriendShip(String jsonData) {
        return gson.fromJson(jsonData,FriendShip.class);
    }

    public  List<FriendShip> JsonToFriendShipList(String jsonData) {
        Type listType = new TypeToken<List<FriendShip>>() {}.getType();
        return gson.fromJson(jsonData,listType);
    }

    public  List<Message> JsonToMessageList(String jsonData) {
        Type listType = new TypeToken<List<Message>>() {}.getType();
        return gson.fromJson(jsonData,listType);
    }


}