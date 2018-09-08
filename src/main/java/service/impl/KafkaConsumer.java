package service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer implements MessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> records) {
        String val = JSON.toJSONString(records.value());
        System.out.println("############ receive success, message:" + val);
    }
}
