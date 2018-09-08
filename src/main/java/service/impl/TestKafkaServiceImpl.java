package service.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import service.TestKafkaService;
import utils.Constants;

import javax.annotation.Resource;

@Service("testKafkaService")
public class TestKafkaServiceImpl implements TestKafkaService {
    @Resource
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Override
    public void testKafkaSend() {
        kafkaTemplate.sendDefault("BigLong Test Kafka Send Message.");
        System.out.println("##### 发送成功！");
    }

    @Override
    public void testLog4j() {
        Constants.LOG.trace("trace level");
        Constants.LOG.debug("debug level");
        Constants.LOG.info("info level");
        Constants.LOG.warn("warn level");
        Constants.LOG.error("error level");
        Constants.LOG.fatal("fatal level");
    }
}
