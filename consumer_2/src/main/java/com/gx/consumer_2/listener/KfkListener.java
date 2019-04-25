package com.gx.consumer_2.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KfkListener {

    @KafkaListener(topics = {"topic001"},groupId = "group3")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record.key());
        System.out.println(record.value());
    }
}

