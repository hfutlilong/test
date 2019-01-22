package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constants {
    public static final Logger LOG = LogManager.getLogger("mylog");

    /**
     * elasticsearch配置
     */
    public static final String ES_CLUSTER_NAME = "es_test";
    public static final String ES_NODE_LIST = "192.168.160.128:9300";
}
