package me.xxx.springboot.Dao;

import me.xxx.springboot.Entity.Member;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.sql.SQLException;
import java.util.List;

public interface MemberDao {

    public Member findMember(int  id) ;

    public List<Member> findAll();

    Member findMember (String uname, String upass);


    String getUpass(String uname);

    Member findMemberByName(String uname);

    void saveMember(Member member);

    public int getMatchCount(String uname);
}
