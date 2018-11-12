package etg.utils;

import java.util.List;

public class MyPage<T> {
    //总条数
    private long total;
    //每页大小
    private int size;
    //页数
    private int pages;
    //当前页
    private int current;
    private List<T> records;

    public MyPage(long total, int size, int current, List<T> records) {
        this.total = total;
        this.size = size;
        this.current = current;
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        if(size ==0) return 0;
        return (int)total/size + 1;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
