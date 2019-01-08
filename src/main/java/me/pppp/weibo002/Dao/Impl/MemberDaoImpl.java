package me.pppp.weibo002.Dao.Impl;


import me.pppp.weibo002.Dao.MemberDao;
import me.pppp.weibo002.Entity.Member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 创建内部类的查询方法可复用
     */
    static class MemberRowMapper implements RowMapper<Member> {
        public Member mapRow(ResultSet resultSet, int i) throws SQLException {
            Member member = new Member();
            member.setuId(resultSet.getInt("uid"));
            member.setuName(resultSet.getString("uname"));
            member.setuPass(resultSet.getString("upass"));
            return member;
        }
    }

    /**
     * spring jdbc
     *
     * @param id
     * @return
     */
    @Override
    public Member findMember(int id) {
        String sql = "select uid,uname,upass from bbs_user where uid=?";
        Member member = jdbcTemplate.queryForObject(sql, new MemberRowMapper(), id);
        return member;
    }

    @Override
    public List<Member> findAll() {
        String sql = "select uid,uname,upass from bbs_user ";
        List<Member> memberlist = jdbcTemplate.query(sql, new MemberRowMapper());
        return memberlist;
    }

    @Override
    public Member findMember(String uname, String upass) throws SQLException {
        String sql = "select uid,uname,upass from bbs_user where uname =? and upass =?";

        return jdbcTemplate.queryForObject(sql, new MemberRowMapper(), uname, upass);
    }


    @Override
    public String getUpass(String uname) {
        String sql = "select  upass from bbs_user where uname =?";

        return this.jdbcTemplate.queryForObject(sql,new Object[]{uname},String.class);

    }


    public int getMatchCount(String uname) {
        String sql = "select count(*) from bbs_user " +
                " where uname=? ";
        return jdbcTemplate.queryForObject(sql,new Object[]{uname}, Integer.class);
    }


    @Override
    public Member findMemberByName(String uname) {
        String sql = "select uid,uname,upass from bbs_user where uname=?";
       //Member member = jdbcTemplate.queryForObject(sql, new MemberRowMapper(), uname);

        return jdbcTemplate.queryForObject(sql,new Object[]{uname}, BeanPropertyRowMapper.newInstance(Member.class));
    }

    @Override
    public void saveMember(Member member) {

        jdbcTemplate.update("insert into bbs_user(uname,upass) values(?,?)",
                new Object[]{member.getuName(),member.getuPass()});
        return;
    }
}
