package me.xxx.springboot.Service;

import me.xxx.springboot.Entity.Member;

import java.util.List;

public interface MemberService {

    public Member getMemberById(int id);

    Member getMemberByName(String uname);

    public List<Member> getAllMember();

    Member getMember(String uname,String upass);

    String login(String uname);

    void regMember(Member member);

    public boolean MemberIsExist(String uname);
}
