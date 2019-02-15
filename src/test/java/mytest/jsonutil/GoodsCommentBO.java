package mytest.jsonutil;

/**
 * @Description kafka消息中的商品评论信息
 * @Author lilong
 * @Date 2019-01-26 19:29
 */
public class GoodsCommentBO {
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
    private Integer antispamStatus;

    /**
     * 商家类型，0pop，1自营
     */
    private Integer sellerType;

    /**
     * 评论是否命中关键词
     */
    private Integer containKeyword;

    /**
     * 评论创建时间
     */
    private Long createTime;

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

    public Integer getAntispamStatus() {
        return antispamStatus;
    }

    public void setAntispamStatus(Integer antispamStatus) {
        this.antispamStatus = antispamStatus;
    }

    public Integer getSellerType() {
        return sellerType;
    }

    public void setSellerType(Integer sellerType) {
        this.sellerType = sellerType;
    }

    public Integer getContainKeyword() {
        return containKeyword;
    }

    public void setContainKeyword(Integer containKeyword) {
        this.containKeyword = containKeyword;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}

