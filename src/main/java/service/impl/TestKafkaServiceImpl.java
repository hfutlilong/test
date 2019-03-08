//package service.impl;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import service.TestKafkaService;
//import utils.Constants;
//
//import javax.annotation.Resource;
//
//@Service("testKafkaService")
//public class TestKafkaServiceImpl implements TestKafkaService {
//    @Resource
//    private KafkaTemplate<Integer, String> kafkaTemplate;
//
//    @Override
//    public void testKafkaSend() {
//        String json = "{\n" +
//                "   \"goodsCommentId\":\"commentId0001\",\n" +
//                "   \"commentContent\":\"商品评价详情\",\n" +
//                "   \"commentPoint\":5,\n" +
//                "   \"goodsId\":111111,\n" +
//                "   \"skuId\":\"string\",\n" +
//                "   \"antispamStatus\":-2,\n" +
//                "   \"sellerType\": 0,\n" +
//                "   \"containKeyword\": 0,\n" +
//                "   \"createTime\": 1548502980000\n" +
//                "}";
//        kafkaTemplate.sendDefault(json);
//        System.out.println("##### 发送成功！");
//    }
//
//    @Override
//    public void testLog4j() {
//        Constants.LOG.trace("trace level");
//        Constants.LOG.debug("debug level");
//        Constants.LOG.info("info level");
//        Constants.LOG.warn("warn level");
//        Constants.LOG.error("error level");
//        Constants.LOG.fatal("fatal level");
//    }
//}
