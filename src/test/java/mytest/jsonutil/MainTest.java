package mytest.jsonutil;

import com.netease.haitao.core.fastjson.FastJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import utils.DateUtil;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-01-26 18:42
 */
public class MainTest {
    public static void main(String[] args) {
        String json = "{\n" +
                "   \"goodsCommentId\":\"commentId0001\",\n" +
                "   \"commentContent\":\"商品评价详情\",\n" +
                "   \"commentPoint\":5,\n" +
                "   \"goodsId\":111111,\n" +
                "   \"skuId\":\"string\",\n" +
                "   \"antispamStatus\":-2,\n" +
                "   \"sellerType\": 0,\n" +
                "   \"containKeyword\": 0,\n" +
                "   \"createTime\": 1548502980000\n" +
                "}";

        GoodsCommentPO goodsCommentPO = null;
        try {
            goodsCommentPO = parseGoodsCommentMsg(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(JSON.toJSONString(goodsCommentPO));

        System.out.println(DateUtil.formatTime(goodsCommentPO.getCreateTime()));
        System.out.println(DateUtil.formatTime(goodsCommentPO.getDbCreateTime()));
        System.out.println(DateUtil.formatTime(goodsCommentPO.getDbUpdateTime()));
    }

    private static GoodsCommentPO parseGoodsCommentMsg(String goodsCommentMsg) throws WorkorderException {
        GoodsCommentBO goodsCommentBO = FastJsonUtil.parse(goodsCommentMsg, GoodsCommentBO.class);
        if (goodsCommentBO == null) {
            throw new WorkorderException("parseGoodsCommentMsg failed, goodsCommentBO is null.");
        }

        if (StringUtils.isBlank(goodsCommentBO.getGoodsCommentId())) {
            throw new WorkorderException("goodsCommentId is unique key, cannot be blank.");
        }

        GoodsCommentPO goodsCommentPO = new GoodsCommentPO();
        // 属性值拷贝：只拷贝类型一致的值
        BeanUtils.copyProperties(goodsCommentBO, goodsCommentPO);

        /* 类型不一致的值特殊处理 */
        // 反垃圾状态
        Integer antispamStatusInt = goodsCommentBO.getAntispamStatus();
        if (antispamStatusInt != null) {
            goodsCommentPO.setAntispamStatus(AntispamStatusEnum.getByIntValue(antispamStatusInt));
        }

        // 商家类型
        Integer sellerType = goodsCommentBO.getSellerType();
        if (sellerType != null) {
            goodsCommentPO.setSellerType(SellerTypeEnum.getByIntValue(sellerType));
        }

        // 是否命中关键词
        Integer containKeyword = goodsCommentBO.getContainKeyword();
        if (containKeyword != null) {
            goodsCommentPO.setContainKeyword(ContainKeywordEnum.getByIntValue(containKeyword));
        }

        // 评论创建时间
        Long createTime = goodsCommentBO.getCreateTime();
        if (createTime != null) {
            goodsCommentPO.setCreateTime(new Timestamp(createTime));
        }

        /* 添加属性：db记录创建时间和（或）更新时间 */
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        goodsCommentPO.setDbCreateTime(currentTime);
        goodsCommentPO.setDbUpdateTime(currentTime);

        return goodsCommentPO;
    }
}
