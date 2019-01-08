package me.pppp.weibo002.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Member {

    //@NotNull
    private Integer uId;

    //@NotBlank(message = "userName don't null")
    private String uName;

    //@NotBlank(message = "userPass don't null")
    private String uPass;

    public Member() {
    }

    public Member(Integer uid, String uName, String uPass) {
        uId = uid;
        this.uName = uName;
        this.uPass = uPass;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }
}
