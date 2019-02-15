package common;

import java.io.Serializable;

public class PaginationInfo implements Serializable {
    private static final long serialVersionUID = -7986077842495737835L;

    /**
     * 查询记录从第几条开始
     */
    private int offset = 0;
    /**
     * 当前页码
     */
    private int pageNo = 1;
    /**
     * 每页记录数
     */
    private int pageSize = 20;
    /**
     * 总页数
     */
    private int totalPages = 0;
    /**
     * 总记录数
     */
    private int totalCount = 0;

    public PaginationInfo(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.offset = (pageNo - 1) * pageSize;
    }

    public PaginationInfo(int pageNo, int pageSize, int totalCount) {
        this(pageNo, pageSize);
        setTotalCount(totalCount);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {

        if (pageNo != null) {
            this.pageNo = Math.max(pageNo, 1);
            this.offset = (this.pageNo - 1) * pageSize;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
        setPageNo(this.pageNo);
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        if (totalPages != null) {
            this.totalPages = totalPages;
            if (pageSize > 0 && totalPages > 0) {
                this.totalCount = pageSize * totalPages;
            }
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        if (totalCount != null) {
            this.totalCount = totalCount;
            if (pageSize > 0 && totalCount > 0) {
                this.totalPages = (int) (Math.ceil((double) totalCount / pageSize));
            }
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        if (offset != null) {
            this.offset = offset;
        }
    }

    @Override
    public String toString() {
        return "PaginationInfo{" +
                "offset=" + offset +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalCount=" + totalCount +
                '}';
    }

    /**
     * 定义分页相关常量
     */
    public static class Constants {
        /**
         * 私有构造方法，防止被实例化
         */
        private Constants() {
        }

        /**
         * 默认页码
         */
        public static final Integer DEFAULT_PAGE_NO = 1;

        /**
         * 默认分页展示个数
         */
        public static final Integer DEFAULT_PAGE_SIZE = 20;
    }

}
