package me.xxx.springboot.Controller;



import me.xxx.springboot.Controller.form.MemberForm;
import me.xxx.springboot.Entity.Member;
import me.xxx.springboot.Entity.Message;
import me.xxx.springboot.Service.MemberService;
import me.xxx.springboot.Service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    @Qualifier("memberService")
    MemberService memberService;

    @GetMapping("/{id}.json")
    @ResponseBody
    public Member hello(@PathVariable int id){

        return memberService.getMemberById(id);
    }


    @GetMapping("/{id}/all.html")
    public ModelAndView findAll(@PathVariable int id,ModelAndView view){

        view.addObject("member",memberService.getMemberById(id));
        view.addObject("Memberlist",memberService.getAllMember());
        view.setViewName("/MemberList.btl");
        return view;
    }

    @GetMapping("/all.json")
    @ResponseBody
    public List<Member> hello1(){

        return memberService.getAllMember();
    }

    @RequestMapping("/login")
    public String login1(HttpServletRequest request, HttpServletResponse response){
        String uname=request.getParameter("uname");
        String upass=request.getParameter("upass");
        String pass = memberService.login(uname);
        if("pppp".equals(uname)) {
            System.out.println("success");
            return "forward:/login/houtai/pppp.html";
        }
            //return "forward:/hello/" + uname;
//        return "redirect:/houtai?uname=" + uname;
        else {
            System.out.println("fali");
            return "login.html";

        }
    }

    @RequestMapping("/login/houtai/{uname}")
    public ModelAndView loginSuccess(@PathVariable String uname,ModelAndView view){

        view.addObject("n",uname);
        view.setViewName("success.btl");


        return view;
    }

   /* @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String uname=request.getParameter("uname");
        String upass=request.getParameter("upass");
        if(!uname.equals("") && upass!=""){
            Member member =new Member();
            member.setuName(uname);
            member.setuPass(upass);
            request.getSession().setAttribute("member",member);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
    }*/
/*    @RequestMapping("/reg")
    @ResponseBody
   public Member reg(HttpServletResponse response,HttpServletRequest request){
       String uname=request.getParameter("uname");
       String upass=request.getParameter("upass");
       Member member = new Member();
       member.setuName(uname);
       member.setuPass(upass);
       memberService.regMember(member);
       return memberService.getMemberByName(member.getuName());
   }*/

    @RequestMapping("/reg")
    @ResponseBody
    public Member reg(HttpServletResponse response,HttpServletRequest request){
        String uname=request.getParameter("uname");
        String upass=request.getParameter("upass");
        Member member = new Member();
        member.setuName(uname);
        member.setuPass(upass);
        HttpSession session = request.getSession();
        // 保存数据
        session.setAttribute("username", uname);
        // 打印SessionID

        String sessionId = session.getId();

        Cookie cookie = new Cookie("ppppID", sessionId);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);

        System.out.println(sessionId);
        if(!memberService.MemberIsExist(uname)) {
            memberService.regMember(member);
            return memberService.getMemberByName(uname);
        }
        else return null;
    }



}
