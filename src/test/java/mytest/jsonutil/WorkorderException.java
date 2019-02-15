package mytest.jsonutil;

import java.io.Serializable;

/**
 * 工单异常类
 * <p/>
 * Created by hzcaohuihe on 2017/3/23.
 */
public class WorkorderException extends Exception implements Serializable {

    private static final long serialVersionUID = 1581175212552520127L;

    //参数非法
    public static final int PARAMETER_ILLEGAL = -1;

    //工单已存在
    public static final int WORKORDER_EXISTENCE_ILLEGAL = -2;

    /**
     * 工单查询列表页导出，同一时间点，只能进行一个导出任务
     */
    public static final int WORKORDER_LIST_EXPORT_ONCE = -3;

    //工单不存在
    public static final int WORKORDER_NOT_EXISTENCE_ILLEGAL = -4;

    //操作失败
    public static final int OPERATE_FAIL_ILLEGAL = -5;

    //状态错误
    public static final int STATUS_ILLEGAL = -6;

    //账号错误
    public static final int ACCOUNT_ILLEGAL = -7;

    //优化卷商家类型与订单类型不匹配错误
    public static final int COUPON_MERCHANT_TYPE_ILLEGAL = -8;

    //待跟进状态错误
    public static final int FOLLOW_STATUS_ILLEGAL = -9;

    //超过最大数量错误
    public static final int OVER_SIZE_ILLEGAL = -10;

    //组不存在
    public static final int GROUP_NOT_EXISTENCE_ILLEGAL = -11;

    //工单操作不存在
    public static final int WORKORDER_LOG_NOT_EXISTENCE_ILLEGAL = -12;

    //手机号格式错误
    public static final int PHONE_FORMAT_ILLEGAL = -13;

    //存在未评价的第三方处理结果，请先评价
    public static final int MUST_EVALUATE_ILLEGAL = -14;

    //未知异常，用一个非常大的数字表示
    public static final int UNKNOWN_EXCEPTION = -100;

    //转单次数用完，不能转单
    public static final int CAN_NOT_TRANSFER_ORDER = -15;

    private int msgId;

    public WorkorderException() {
        super();
    }

    public WorkorderException(String msg) {
        super(msg);
    }

    public WorkorderException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public WorkorderException(int msgId, String msg) {
        super(msg);
        this.msgId = msgId;
    }

    public WorkorderException(Throwable e){
        super(e);
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
}

