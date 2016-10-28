package controlller;

import bo.*;
import dto.PostDto;
import dto.UserDto;

import java.util.ArrayList;

/**
 * Created by Benjamin on 2015-11-07.
 */
public class AccountController {

    public UserDto getUserbyId(long userId){

        AccountHandler account = new AccountHandler();
        return new UserDto(account.getUserbyId(userId));

    }


    public boolean savePost(String postText,long userId){
        AccountHandler account = new AccountHandler();
        return account.savePost(postText,userId);
    }

    public ArrayList<PostDto> getAllPosts(long userId){

       AccountHandler account = new AccountHandler();
        ArrayList<Post> postes = account.getAllPostes(userId);
        ArrayList<PostDto> postDtoList = new ArrayList<PostDto>();
        for (Post post:postes) {
            PostDto postDto = new PostDto(post);
            postDtoList.add(postDto);
        }
        return postDtoList ;
    }

    public boolean deletePost(long userId ,long postId){
        AccountHandler account = new AccountHandler();
        return account.deletePost(userId, postId);
    }


}
