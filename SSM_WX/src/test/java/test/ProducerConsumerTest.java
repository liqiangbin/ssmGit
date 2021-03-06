package test;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.ProducerService;

@RunWith(SpringJUnit4ClassRunner.class)     //��ʾ�̳���SpringJUnit4ClassRunner��  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class ProducerConsumerTest {  
 private static Logger logger = Logger.getLogger(ProducerConsumerTest.class); 
 @Resource  
 private  ProducerService producerService;
 @Autowired  
 @Qualifier("queueDestination")  
 @Resource 
 private Destination destination;  
   
 @Test  
 public void testSend() {  
     for (int i=0; i<2; i++) {  
         producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));  
     }  
 }  
   
}  