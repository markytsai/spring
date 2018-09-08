import com.ilsxh.config.AppConfig;
import com.ilsxh.dao.MemberDao;
import com.ilsxh.dao.MemberDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberDao memberDao = (MemberDao) ctx.getBean("dao");
        memberDao.query();
        memberDao.update();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                MemberDaoImpl.class, MemberDaoImpl.class
        );


    }
}
