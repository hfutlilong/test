package dao.gen.po;

import entity.TestJsonDetail;

public class TestJsonPO {
    private Long id;

    private TestJsonDetail jsonDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestJsonDetail getJsonDetail() {
        return jsonDetail;
    }

    public void setJsonDetail(TestJsonDetail jsonDetail) {
        this.jsonDetail = jsonDetail;
    }
}