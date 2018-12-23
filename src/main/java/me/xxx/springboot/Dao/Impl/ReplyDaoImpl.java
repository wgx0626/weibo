package me.xxx.springboot.Dao.Impl;

import me.xxx.springboot.Dao.ReplyDao;
import me.xxx.springboot.Entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Reply> findAll() {
        return null;
    }
}
