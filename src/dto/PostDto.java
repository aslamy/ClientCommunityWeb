package dto;

import bo.Post;

import java.util.Date;

/**
 * Created by Benjamin on 2015-11-08.
 */
public class PostDto {
    public PostDto(Post post) {
        this.postId = post.getPostId();
        this.created = post.getCreated();
        this.text = post.getText();
        this.title = post.getTitle();
    }

    public PostDto(long postId, Date created, String text, String title) {
        this.postId = postId;
        this.created = created;
        this.text = text;
        this.title = title;
    }

    private long postId ;

    private String title ;

    private String text ;

    private Date created;

    public String getText() {
        return text;
    }

    public long getPostId() {
        return postId;
    }


    public Date getCreated() {
        return created;
    }

    public String getTitle() {
        return title;
    }

}
