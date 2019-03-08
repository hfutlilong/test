//package service.impl;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Service;
//import utils.Constants;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.net.InetAddress;
//import java.util.Arrays;
//import java.util.List;
//
//import static com.google.common.base.Preconditions.checkArgument;
//import static com.google.common.base.Preconditions.checkNotNull;
//
///**
// * elasticSearch 客户端工厂类
// *
// * @Author hzcaohuihe
// * @Date 2018/5/24 16:22
// * @Version 1.0
// */
//@Lazy
//@Service
//public class ElasticSearchClientFactory {
//
//    // 搜索客户端
//    private TransportClient client;
//
//    @PostConstruct
//    public void initialize() {
//        List<String> nodeList = Arrays.asList(Constants.ES_NODE_LIST.split(","));
//        checkNotNull(nodeList);
//        checkArgument(nodeList.size() > 0);
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
//        client = initClient(Constants.ES_CLUSTER_NAME, nodeList);
//        Thread shutdownThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                close();
//            }
//        }, "ElasticSearchShutdownHook");
//        shutdownThread.setPriority(Thread.MIN_PRIORITY);
//        Runtime.getRuntime().addShutdownHook(shutdownThread);
//    }
//
//    private TransportClient initClient(String name, List<String> nodes) {
//        try {
//            Settings settings = Settings.builder().put("cluster.name", name).put("client.transport.ping_timeout", "10s")
//                    .put("client.transport.sniff", false).build();
//            TransportClient client = new PreBuiltTransportClient(settings);
//            for (String node : nodes) {
//                String address;
//                int port;
//                try {
//                    String[] temp = node.split(":");
//                    address = temp[0];
//                    port = Integer.parseInt(temp[1]);
//                    Constants.LOG.info("init elasticsearch client, address:{}, port:{}", address, port);
//                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
//                    Constants.LOG.info("init elasticsearch client node fail:{},{}", node, e);
//                    continue;
//                }
//                client = client
//                        .addTransportAddress(new TransportAddress(InetAddress.getByName(address), port));
//            }
//            return client;
//        } catch (Exception e) {
//            Constants.LOG.error("init elasticsearch client fail:{},{},{}", name, nodes, e);
//            return null;
//        }
//    }
//
//    @PreDestroy
//    public void close() {
//        if (client != null) {
//            client.close();
//        }
//    }
//
//    public TransportClient getClient() {
//        return this.client;
//    }
//}
//
