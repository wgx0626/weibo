package me.pppp.weibo002.Dao;



import me.pppp.weibo002.Entity.Message;

import java.util.List;

public interface MessageBoardDao {

    public List<Message> showBody();

    public void post(Message message);

    public void delete(Message message);

    public void Modify(Message message);

    public Message findMessageById(Long id);

    //public Pager<Message> findByPage(Pager<Message> page);

}
