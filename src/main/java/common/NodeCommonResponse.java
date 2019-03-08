package common;

import java.io.Serializable;

/**
 * @Description 前端rpc接口通用返回结构
 * @Author lilong
 * @Date 2019-02-26 20:08
 */
public class NodeCommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -5878785345475824018L;

    /**
     * 返回码
     */
    private int retCode;

    /**
     * 返回信息
     */
    private String retDesc;

    /**
     * 返回数据
     */
    private T data;


    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T>NodeCommonResponse<T> build(WebCommRetEnum retEnum) {
        NodeCommonResponse<T> ret = new NodeCommonResponse<>();
        ret.setRetCode(retEnum.retCode);
        ret.setRetDesc(retEnum.retMsg);
        return ret;
    }


    public static <T>NodeCommonResponse<T> build(WebCommRetEnum webCommRetEnum, T data) {
        NodeCommonResponse<T> ret = build(webCommRetEnum);
        ret.setData(data);
        return ret;
    }

    public static <T>NodeCommonResponse<T> succ() {
        return NodeCommonResponse.build(WebCommRetEnum.SUCCESS);
    }

    public static <T>NodeCommonResponse<T> succ(T data) {
        NodeCommonResponse<T> ret = NodeCommonResponse.succ();
        ret.setData(data);
        return ret;
    }

    public static <T>NodeCommonResponse<T> fail() {
        return NodeCommonResponse.build(WebCommRetEnum.FAIL);
    }

    public static <T>NodeCommonResponse<T> systemError() {
        return NodeCommonResponse.build(WebCommRetEnum.SYSTEM_ERROR);
    }

    public static <T>NodeCommonResponse<T> parameterError() {
        return NodeCommonResponse.build(WebCommRetEnum.ILLEGAL_PARAM_FAIL);
    }

    /**
     * 失败
     *
     * @param retDesc
     * @return
     */
    public static <T>NodeCommonResponse<T> fail(String retDesc) {
        NodeCommonResponse<T> ret = NodeCommonResponse.build(WebCommRetEnum.FAIL);
        ret.setRetDesc(retDesc);
        return ret;
    }

    /**
     * 失败
     * @param retCode
     * @param retMsg
     * @return
     */
    public static <T>NodeCommonResponse<T> fail(Integer retCode, String retMsg) {
        NodeCommonResponse<T> ret = new NodeCommonResponse<>();
        ret.setRetCode(retCode);
        ret.setRetDesc(retMsg);
        return ret;
    }

    /**
     * 失败
     * @param webCommRetEnum
     * @return
     */
    public static <T>NodeCommonResponse<T> fail(WebCommRetEnum webCommRetEnum) {
        NodeCommonResponse<T> ret = new NodeCommonResponse<>();
        ret.setRetCode(webCommRetEnum.getRetCode());
        ret.setRetDesc(webCommRetEnum.getRetMsg());
        return ret;
    }

    /**
     * 失败
     * @param webCommRetEnum
     * @return
     */
    public static <T>NodeCommonResponse<T> fail(WebCommRetEnum webCommRetEnum, T data) {
        NodeCommonResponse<T> ret = new NodeCommonResponse<>();
        ret.setRetCode(webCommRetEnum.getRetCode());
        ret.setRetDesc(webCommRetEnum.getRetMsg());
        ret.setData(data);
        return ret;
    }

    /**
     * 失败
     *
     * @param retDesc
     * @param data
     * @return
     */
    public static <T>NodeCommonResponse<T> fail(String retDesc, T data) {
        NodeCommonResponse<T> ret = build(WebCommRetEnum.FAIL);
        ret.setRetDesc(retDesc);
        ret.setData(data);
        return ret;
    }

    /**
     * 失败，带回数据
     *
     * @param data
     * @return
     */
    public static <T>NodeCommonResponse<T> failWithData(T data) {
        NodeCommonResponse<T> nodeCommonResponse = NodeCommonResponse.build(WebCommRetEnum.FAIL);
        nodeCommonResponse.setData(data);
        return nodeCommonResponse;
    }

    public boolean isSucc() {
        return retCode == WebCommRetEnum.SUCCESS.retCode;
    }


    public enum WebCommRetEnum {
        SUCCESS(200, "成功"),
        EXPORT_EXCEL_SUCCESS(201, "excel导出成功"),

        FAIL(400, "服务端失败"),
        ILLEGAL_PARAM_FAIL(402, "参数不合法"),
        FORBIDDEN(403, "禁止访问"),
        TOKEN_VALID_FAIL(300, "token校验失败"),

        // 公共返回参数 600-999
        PARAM_ERROR(600, "参数错误"),
        SYSTEM_ERROR(500, "服务端异常"),
        // 1000+ 订单相关

        ;

        private int retCode;

        private String retMsg;

        private WebCommRetEnum(int retCode, String retDesc) {
            this.retCode = retCode;
            this.retMsg = retDesc;
        }

        public int getRetCode() {
            return retCode;
        }

        public String getRetMsg() {
            return retMsg;
        }
    }
}

