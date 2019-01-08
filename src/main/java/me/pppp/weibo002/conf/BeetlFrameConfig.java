package me.pppp.weibo002.conf;


//import me.xxx.springboot.Util.FirstFunction;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * beetl的配置类
 */
@Configuration
public class BeetlFrameConfig {
    @Autowired
    GroupTemplate groupTemplate;

    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    public void config(){
        Map<String, Object> shared = new HashMap<String, Object>();
        shared.put("jsVersion", System.currentTimeMillis());
        //注册方法
        //groupTemplate.registerFunction("hi",applicationContext.getBean(FirstFunction.class));
      /*  //注册标签
        groupTemplate.registerTagFactory("myTag", new TagFactory(){

            public Tag createTag() {
                return  applicationContext.getBean(SimpleTag.class);
            }

        });*/
        URL url = BeetlFrameConfig.class.getResource("/templates/functions");
        System.out.print("=================="+url);
    }

}
