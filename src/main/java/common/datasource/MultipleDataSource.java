package common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * @ClassName: MultipleDataSource
 * @Description: 多数据源
 * @author hzhuangxiaojun<hzhuangxiaojun@corp.netease.com>
 * @date 2015年8月26日 下午4:28:07
 *
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<String>();

    /**
     *
     * @Description: 设置当前线程的数据源
     * @author hzhuangxiaojun
     * @date 2015年8月26日 下午4:29:01
     * @param dataSource
     */
    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
    public static String getDataSourceKey(){return dataSourceKey.get();}

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public static void removeDataSourceKey() {
        dataSourceKey.remove();
    }

}