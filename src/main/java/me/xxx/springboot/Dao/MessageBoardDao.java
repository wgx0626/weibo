package me.xxx.springboot.Dao;

import me.xxx.springboot.Entity.Message;

import java.util.List;

public interface MessageBoardDao {

    public List<Message> showBody();

    public void post(Message message);

    public void delete(Message message);

    public void Modify(Message message);

    public Message findMessageById(Long id);



}
