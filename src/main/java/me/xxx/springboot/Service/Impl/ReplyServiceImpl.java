package me.xxx.springboot.Service.Impl;

import me.xxx.springboot.Dao.ReplyDao;
import me.xxx.springboot.Entity.Reply;
import me.xxx.springboot.Service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyDao replyDao;


    @Override
    public List<Reply> getAll() {


        return replyDao.findAll();
    }
}
