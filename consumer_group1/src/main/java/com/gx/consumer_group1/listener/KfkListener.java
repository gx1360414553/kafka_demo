package com.gx.consumer_group1.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KfkListener {

    @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(record.key());
        System.out.println(record.value());
    }
}

