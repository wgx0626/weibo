package me.xxx.springboot.Dao.Impl;

import me.xxx.springboot.Dao.MessageBoardDao;
import me.xxx.springboot.Entity.Member;
import me.xxx.springboot.Entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class MessageBoardDaoImpl implements MessageBoardDao {



    @Autowired
    JdbcTemplate jdbcTemplate;

    static class MessageRowMapper implements RowMapper<Message> {
        public Message mapRow(ResultSet resultSet, int i) throws SQLException {
            Message message = new Message();
            message.setId(resultSet.getLong("topicid"));
            message.setTitle(resultSet.getString("title"));
            message.setBody(resultSet.getString("content"));
            return message;
        }
    }

    @Override
    public List<Message> showBody() {


        return jdbcTemplate.query("select topicid,title,content from bbs_topic",new MessageRowMapper());
    }


    @Override
    public void delete(Message message) {
        jdbcTemplate.update("DELETE FROM bbs_topic WHERE topicid =?",message.getId());
    }

//UPDATE `stu`.`bbs_topic` SET `publishtime` = '2018-12-21 23:36:42' WHERE `topicid` = 4
    @Override
    public void post(Message message) {
        jdbcTemplate.update("INSERT INTO bbs_topic(title,content) VALUES (?, ?)",message.getTitle(),message.getBody());
    }

    @Override
    public Message findMessageById(Long id) {
        return jdbcTemplate.queryForObject("select topicid,title,content from bbs_topic where topicid =?",new MessageRowMapper(),new Object[]{id} );

    }


    @Override
    public void Modify(Message message) {
        jdbcTemplate.update("UPDATE bbs_topic SET content = ? WHERE topicid = ?",message.getBody(),message.getId());
    }
}
