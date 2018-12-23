package me.xxx.springboot.Entity;

public class Member {

    private Integer uId;
    private String uName;
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

    public void setId(Integer id) {
        uId = id;
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
