import com.aishang.rulemanager.assembly.config.db.DataSourceConfig;
import com.aishang.rulemanager.assembly.config.dubbo.DubboConfig;
import com.aishang.rulemanager.assembly.config.redis.RedisConfig;
import com.aishang.rulemanager.assembly.config.security.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//配置文件
@ContextConfiguration(classes = {DataSourceConfig.class, RedisConfig.class, SecurityConfig.class, DubboConfig.class})
@TestPropertySource(properties = {"spring.profiles.active=dev"})
public class test {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void show() {
        applicationEventPublisher.publishEvent("nihao");
    }
//    @BeforeClass
//    public static void t1(){
//        System.setProperty("spring.profiles.active","dev");
//    }

    /**
     * 定义事件类
     */
    public class ApplyMyoneySuccessEvent extends ApplicationEvent {
        public ApplyMyoneySuccessEvent(Object source) {
            super(source);
        }
    }

    public class ApplyMyoneSuccessListener implements ApplicationListener<ApplyMyoneySuccessEvent> {

        @Override
        public void onApplicationEvent(ApplyMyoneySuccessEvent applyMyoneySuccessEvent) {

            System.out.print("is generically parameterized with the type of your custom event,");
        }
    }
}
