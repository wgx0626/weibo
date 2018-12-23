package me.xxx.springboot.Service;

import me.xxx.springboot.Entity.Message;

import java.util.List;

public interface MessageBoardService {

    public List<Message> listMessages();

    public void postMessage(Message message);

    public void deleteMessage(Message message);

    public void modifyMessage(Message message);

    public  Message findMessageById(Long messageId);



}
