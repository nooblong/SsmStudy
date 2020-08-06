package github.nooblong.ui;

import github.nooblong.dao.IAccountDao;
import github.nooblong.service.IAccountService;
import github.nooblong.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
//        IAccountService as2 = (IAccountService)ac.getBean("accountService");
//        IAccountService as3 = (IAccountService)ac.getBean("accountService");
//        System.out.println(as2 == as3);


        IAccountDao ad = ac.getBean("accountDao",IAccountDao.class);
        as.saveAccount();
        as.strings();


//        as = (IAccountService)ac.getBean("accountService2");
//        as.saveAccount();
//        as.strings();

        ac.close();
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        IAccountService as2 = (IAccountService)beanFactory.getBean("accountService");
//        System.out.println(as2);
    }
}
