package com.Liucccc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.junit.Test;

/**
 * SpringTest
 *
 * @author liuchao
 * @date 2019-10-28 14:38
 */
@Service
public class SpringTest {
    @Test
    public void testSpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringTest springTest = (SpringTest) applicationContext.getBean("springTest");
        springTest.sayHello();

    }
    public void sayHello(){
        System.out.println("hello world");
    }
}
