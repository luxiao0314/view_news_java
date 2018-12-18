//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.viet.news.common.page;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class SortField implements Serializable {
    public static final long serialVersionUID = -1L;
    @JsonProperty("direction")
    @JSONField(
        name = "direction"
    )
    private SortDirection direction;
    @JsonProperty("field_name")
    @JSONField(
        name = "field_name"
    )
    private String fieldName;

    public SortField() {
    }

    public SortField(String fieldName) {
        this(SortDirection.ASC, fieldName);
    }

    public SortField(SortDirection direction, String fieldName) {
        this.direction = direction;
        this.fieldName = fieldName;
    }

    public SortDirection getDirection() {
        return this.direction;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SortField)) {
            return false;
        } else {
            SortField other = (SortField)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$direction = this.getDirection();
                Object other$direction = other.getDirection();
                if (this$direction == null) {
                    if (other$direction != null) {
                        return false;
                    }
                } else if (!this$direction.equals(other$direction)) {
                    return false;
                }

                Object this$fieldName = this.getFieldName();
                Object other$fieldName = other.getFieldName();
                if (this$fieldName == null) {
                    if (other$fieldName != null) {
                        return false;
                    }
                } else if (!this$fieldName.equals(other$fieldName)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SortField;
    }

    public int hashCode() {
        Object $direction = this.getDirection();
        int result =  59 + ($direction == null ? 43 : $direction.hashCode());
        Object $fieldName = this.getFieldName();
        result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
        return result;
    }

    public String toString() {
        return "SortField(direction=" + this.getDirection() + ", fieldName=" + this.getFieldName() + ")";
    }
}
