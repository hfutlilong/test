package mytest.jsonutil;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-26 19:25
 */
public class GoodsCommentInfo {
    private String goodsCommentId;
    private String commentContent;
    private Integer commentPoint;
    private Long goodsId;
    private String skuId;
    private Integer antispamStatus;
    private Integer sellerType;
    private Integer containKeyword;
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
