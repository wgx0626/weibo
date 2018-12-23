package me.xxx.springboot.Service.Impl;

import me.xxx.springboot.Dao.MessageBoardDao;
import me.xxx.springboot.Entity.Message;
import me.xxx.springboot.Service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageBoardServiceImpl implements MessageBoardService {

    @Autowired
    MessageBoardDao messageBoardDao;


    @Override
    public List<Message> listMessages() {
        return messageBoardDao.showBody();
    }

    @Override
    public Message findMessageById(Long messageId) {
        return messageBoardDao.findMessageById(messageId);
    }

    @Override
    public  synchronized void deleteMessage(Message message) {
        messageBoardDao.delete(message);
    }

    @Override
    public synchronized void postMessage(Message message) {
        messageBoardDao.post(message);
    }

    @Override
    public synchronized void modifyMessage(Message message) {
        messageBoardDao.Modify(message);
    }
}
