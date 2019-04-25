package com.gx.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
        @Autowired
        private KafkaTemplate kafkaTemplate;

        @Test
        public void contextLoads() {
            int count = 0;
            try {
                while (true){
                    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic001","luoye2", "2hello kafka.." + count);
                    future.addCallback(new ListenableFutureCallback<SendResult< String, String >>() {
                        @Override
                        public void onSuccess(SendResult<String, String> result) {
                            System.out.println(result.toString());
                            System.out.println("推送消息成功");
                        }

                        @Override
                        public void onFailure(Throwable throwable) {
                            System.out.println("推送消息失败");
                        }
                    });
                    count ++;
                    Thread.sleep(2000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
