package me.pppp.weibo002.Dao.Impl;


import me.pppp.weibo002.Dao.ReplyDao;
import me.pppp.weibo002.Entity.Reply;
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
