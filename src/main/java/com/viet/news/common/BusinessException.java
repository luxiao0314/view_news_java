//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.viet.news.common;

import java.util.Arrays;

public class BusinessException extends RuntimeException {
    private String code;
    private Exception cause;
    private Object[] args;

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String code, Object[] args) {
        this.code = code;
        this.args = args;
    }

    public BusinessException(String code, Object[] args, Exception cause) {
        this.code = code;
        this.args = args;
        this.cause = cause;
    }

    public String getCode() {
        return this.code;
    }

    public Exception getCause() {
        return this.cause;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCause(Exception cause) {
        this.cause = cause;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BusinessException)) {
            return false;
        } else {
            BusinessException other = (BusinessException)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label39: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label39;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label39;
                    }

                    return false;
                }

                Object this$cause = this.getCause();
                Object other$cause = other.getCause();
                if (this$cause == null) {
                    if (other$cause != null) {
                        return false;
                    }
                } else if (!this$cause.equals(other$cause)) {
                    return false;
                }

                if (!Arrays.deepEquals(this.getArgs(), other.getArgs())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BusinessException;
    }

    public int hashCode() {
        Object $code = this.getCode();
        int result = 59 + ($code == null ? 43 : $code.hashCode());
        Object $cause = this.getCause();
        result = result * 59 + ($cause == null ? 43 : $cause.hashCode());
        result = result * 59 + Arrays.deepHashCode(this.getArgs());
        return result;
    }

    public String toString() {
        return "BusinessException(code=" + this.getCode() + ", cause=" + this.getCause() + ", args=" + Arrays.deepToString(this.getArgs()) + ")";
    }
}
