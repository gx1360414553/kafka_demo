package com.gx.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KfkListener {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record.key());
        System.out.println(record.value());

                ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test1",record.key(), record.value());
    }
}

