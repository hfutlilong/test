package mytest.jsonutil;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

/**
 * @Description 商品评论信息
 * @Author lilong
 * @Date 2019-01-26 10:28
 */
public class GoodsCommentPO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 评论业务id
     */
    private String goodsCommentId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论星级，1~5
     */
    private Integer commentPoint;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * sku_id
     */
    private String skuId;

    /**
     * 评论反垃圾指定的状态，-2异常，1正常，3反垃圾判定删除
     */
    private AntispamStatusEnum antispamStatus;

    /**
     * 商家类型，0pop，1自营
     */
    private SellerTypeEnum sellerType;

    /**
     * 评论是否命中关键词
     */
    private ContainKeywordEnum containKeyword;

    /**
     * 评论创建时间
     */
    private Timestamp createTime;

    /**
     * 记录创建时间
     */
    private Timestamp dbCreateTime;

    /**
     * 记录更新时间
     */
    private Timestamp dbUpdateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsCommentId() {
        return goodsCommentId;
    }

    public void setGoodsCommentId(String goodsCommentId) {
        this.goodsCommentId = goodsCommentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentPoint() {
        return commentPoint;
    }

    public void setCommentPoint(Integer commentPoint) {
        this.commentPoint = commentPoint;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public AntispamStatusEnum getAntispamStatus() {
        return antispamStatus;
    }

    public void setAntispamStatus(AntispamStatusEnum antispamStatus) {
        this.antispamStatus = antispamStatus;
    }

    public SellerTypeEnum getSellerType() {
        return sellerType;
    }

    public void setSellerType(SellerTypeEnum sellerType) {
        this.sellerType = sellerType;
    }

    public ContainKeywordEnum getContainKeyword() {
        return containKeyword;
    }

    public void setContainKeyword(ContainKeywordEnum containKeyword) {
        this.containKeyword = containKeyword;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getDbCreateTime() {
        return dbCreateTime;
    }

    public void setDbCreateTime(Timestamp dbCreateTime) {
        this.dbCreateTime = dbCreateTime;
    }

    public Timestamp getDbUpdateTime() {
        return dbUpdateTime;
    }

    public void setDbUpdateTime(Timestamp dbUpdateTime) {
        this.dbUpdateTime = dbUpdateTime;
    }
}
