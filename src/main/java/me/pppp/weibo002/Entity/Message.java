package me.pppp.weibo002.Entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Message {
    //public interface Add{};

    @NotNull
    private Long id;
    //private String author;
    @NotBlank(message = "title not null")
    private  String title;
    @NotBlank(message = "body not null")
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
*/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
