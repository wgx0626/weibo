package me.xxx.springboot.Service.Impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import me.xxx.springboot.Dao.MemberDao;
import me.xxx.springboot.Entity.Member;
import me.xxx.springboot.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service("memberService")
public class MemberServiceImpl implements MemberService {


    @Autowired
    @Qualifier("memberDao")
    MemberDao memberDao;

    @Override
    public Member getMemberById(int id) {
        return memberDao.findMember(id);
    }

    @Override
    public List<Member> getAllMember() {


        return memberDao.findAll();
    }

    @Override
    public Member getMember(String uname, String upass) {

      return memberDao.findMember(uname, upass);
    }

    @Override
    public String login(String uname) {

        return memberDao.getUpass(uname);
    }

    @Override
    public Member getMemberByName(String uname) {
        return memberDao.findMemberByName(uname);
    }

    @Override
    public void regMember(Member member) {
        memberDao.saveMember(member);
        return;
    }


    @Override
    public boolean MemberIsExist(String uname) {
        return memberDao.getMatchCount(uname)>0;
    }
}
