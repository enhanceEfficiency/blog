package cn.gsein.blog.base.entity;

/**
 * Created by G.Seinfeld on 2017/4/20.
 * 用于分布和排序功能，封装了分页的开始条数和结束条数以及排序语句
 */
public class PageAndOrder {
    private int startIndex;
    private int rowsPerPage;
    private String orderStatement;

    public PageAndOrder(int startIndex, int rowsPerPage, String orderStatement) {
        this.startIndex = startIndex;
        this.rowsPerPage = rowsPerPage;
        this.orderStatement = orderStatement;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public String getOrderStatement() {
        return orderStatement;
    }

    public void setOrderStatement(String orderStatement) {
        this.orderStatement = orderStatement;
    }
}
