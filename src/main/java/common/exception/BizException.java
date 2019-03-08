package common.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 自定义异常
 * @Author lilong
 * @Date 2019-03-08 19:33
 */
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 发生错误的数据信息
     */
    private Map<String,Object> attachInfoMap;

    public BizException(int errorCode,String message,Throwable cause){
        super(message,cause);
        this.errorCode = errorCode;
    }

    public BizException(int errorCode,String message){
        super(message);
        this.errorCode = errorCode;
    }
    public BizException(String message){
        this(ErrorCode.BIZ_ERROR,message);
    }

    public BizException(String message,Throwable cause){
        this(ErrorCode.BIZ_ERROR,message,cause);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public BizException setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public BizException addAttachInfo(String key,Object value){
        if(null == attachInfoMap){
            attachInfoMap = new HashMap<>();
        }
        attachInfoMap.put(key,value);
        return this;
    }

    public Object getAttachInfo(String key){
        return attachInfoMap.get(key);
    }
}
