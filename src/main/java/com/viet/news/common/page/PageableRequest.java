//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.viet.news.common.page;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class PageableRequest implements Serializable {
    @JsonProperty("page_number")
    @JSONField(
        name = "page_number"
    )
    private Integer pageNumber;
    @JsonProperty("page_size")
    @JSONField(
        name = "page_size"
    )
    private Integer pageSize;
    @JsonProperty("sort_fields")
    @JSONField(
        name = "sort_fields"
    )
    private List<SortField> sortFields;

    public PageableRequest() {
    }

    public PageableRequest(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageableRequest)) {
            return false;
        } else {
            PageableRequest other = (PageableRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$pageNumber = this.getPageNumber();
                    Object other$pageNumber = other.getPageNumber();
                    if (this$pageNumber == null) {
                        if (other$pageNumber == null) {
                            break label47;
                        }
                    } else if (this$pageNumber.equals(other$pageNumber)) {
                        break label47;
                    }

                    return false;
                }

                Object this$pageSize = this.getPageSize();
                Object other$pageSize = other.getPageSize();
                if (this$pageSize == null) {
                    if (other$pageSize != null) {
                        return false;
                    }
                } else if (!this$pageSize.equals(other$pageSize)) {
                    return false;
                }

                Object this$sortFields = this.getSortFields();
                Object other$sortFields = other.getSortFields();
                if (this$sortFields == null) {
                    if (other$sortFields != null) {
                        return false;
                    }
                } else if (!this$sortFields.equals(other$sortFields)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageableRequest;
    }

    public int hashCode() {
        Object $pageNumber = this.getPageNumber();
        int result =  59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
        Object $pageSize = this.getPageSize();
        result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
        Object $sortFields = this.getSortFields();
        result = result * 59 + ($sortFields == null ? 43 : $sortFields.hashCode());
        return result;
    }

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public List<SortField> getSortFields() {
        return this.sortFields;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortFields(List<SortField> sortFields) {
        this.sortFields = sortFields;
    }

    public String toString() {
        return "PageableRequest(pageNumber=" + this.getPageNumber() + ", pageSize=" + this.getPageSize() + ", sortFields=" + this.getSortFields() + ")";
    }
}
