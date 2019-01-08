package me.pppp.weibo002.conf;


import me.xxx.springboot.Entity.Member;
import me.xxx.springboot.Service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户的用户名: {}", username);

        String userpass = memberService.getUpassByName(username);

        String password = passwordEncoder.encode(userpass);
        logger.info("password: {}", password);

        //Member member = memberService.getMember(username,userpass);
        // TODO 根据用户名，查找到对应的密码，与权限

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username,password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        return user;
    }
}

