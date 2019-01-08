package me.pppp.weibo002.Controller;


import me.pppp.weibo002.Entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;


@Controller
@RequestMapping("/msg")
public class  MessageController {

    @Autowired
    MessageBoardService messageBoardService;

    /**
     * 显示留言
     * @param model
     * @return 留言列表
     */
    @RequestMapping("messageList")
    public String MessageList(Model model){
        int pageNum = 1;
        int pageSize = 5;
        //List<Message> messages = messageBoardService.listMessages(pageNum,pageSize);
        List<Message> messages = messageBoardService.listMessages();
        model.addAttribute("message",messages);
        return "/messageList.btl";
    }

    /**
     * 提交留言
     * @param
     * @return
     */
    /* @ModelAttribute
    public String setupPostForm(Model model){
        Message messages = new Message();
        model.addAttribute("message",messages);
        return "/messagePost";
    }*/
    @GetMapping("proMessagePost")
    public String MessagePost(){
        return "/messagePost.btl";
    }

    @PostMapping("messagePost")
    public String MessagePost(@ModelAttribute("message")Message message, BindingResult result){
        if(result.hasErrors()){
            return "/messagePost.btl";
        }else {
            messageBoardService.postMessage(message);
            return "redirect:messageList";
        }
    }

    /**
     * 删除留言
     * @param messageId
     * @param model
     * @return model
     */
    @GetMapping("messageDelete")
    public String messageDelte(@RequestParam(required = true,value = "id") Long messageId,  Model model){
        Message message = messageBoardService.findMessageById(messageId);
        messageBoardService.deleteMessage(message);
        List<Message> messages = messageBoardService.listMessages();
        model.addAttribute("message",messages);
        return "/messageList.btl";
    }

    /**
     * 修改内容
     * @param messageId
     * @param model
     * @return
     */
    @GetMapping("proModify")
    public String messageProModify(@RequestParam(required = true,value = "id") Long messageId, Model model){

        model.addAttribute("id",messageId);

        return "/modifyMessage.btl";
    }

    /**
     * 修改内容
     * @param
     * @return
     */
/*    @ModelAttribute
    public String setupModifyForm(Model model){
        Message messages = new Message();
        model.addAttribute("modifyMessage",messages);
        return "/messageMoidify";
    }*/
    @PostMapping("messageModify")
    public String messageModify(@ModelAttribute("modifyMessage") Message message , BindingResult result){

        if(result.hasErrors()){
            return "/modifyMessage.btl";
        }else {
            messageBoardService.modifyMessage(message);
            return "redirect:messageList";
        }

    }


/*
    @GetMapping("getList")
    public List<Message> getGoodsTypeList(int pageNum, int pageSize)  {
        // 调用业务逻辑,返回数据
        //return messageBoardService.listMessages(pageNum,pageSize);
        return null;
    }
*/

}
