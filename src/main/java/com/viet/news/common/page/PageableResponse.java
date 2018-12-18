//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.viet.news.common.page;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class PageableResponse<T extends Serializable> implements Serializable {
    public static final long serialVersionUID = -1L;
    @JSONField(
        name = "total_count"
    )
    @JsonProperty("total_count")
    private long totalCount;
    @JSONField(
        name = "total_pages"
    )
    @JsonProperty("total_pages")
    private int totalPages;
    @JSONField(
        name = "list"
    )
    @JsonProperty("list")
    private List<T> list;

    public PageableResponse() {
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageableResponse)) {
            return false;
        } else {
            PageableResponse<?> other = (PageableResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotalCount() != other.getTotalCount()) {
                return false;
            } else if (this.getTotalPages() != other.getTotalPages()) {
                return false;
            } else {
                Object this$list = this.getList();
                Object other$list = other.getList();
                if (this$list == null) {
                    if (other$list == null) {
                        return true;
                    }
                } else if (this$list.equals(other$list)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageableResponse;
    }

    public int hashCode() {
        long $totalCount = this.getTotalCount();
        int result = 59 + (int)($totalCount >>> 32 ^ $totalCount);
        result = result * 59 + this.getTotalPages();
        Object $list = this.getList();
        result = result * 59 + ($list == null ? 43 : $list.hashCode());
        return result;
    }

    public String toString() {
        return "PageableResponse(totalCount=" + this.getTotalCount() + ", totalPages=" + this.getTotalPages() + ", list=" + this.getList() + ")";
    }
}
