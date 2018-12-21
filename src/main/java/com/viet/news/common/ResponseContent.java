//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.viet.news.common;

import com.viet.news.controller.UserController;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseContent<T> {
    private static Logger logger = LoggerFactory.getLogger(ResponseContent.class);
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = 2;
    public static final int AUTH_FAIL_CODE = 1;
    public static final int SIGNATURE_ERROR_CODE = 3;
    public static final int INTERNAL_SERVER_ERROR_CODE = 500;
    public static final int BUSINESS_EXCEPTION_CODE = 1000;
    public static final int NO_PERMiSSION = 961;
    private int code;
    private String message;
    private T data;

    public ResponseContent() {
    }

    public ResponseContent(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseContent(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseContent buildSuccess(String message) {
        return new ResponseContent(0, message);
    }

    public static <T> ResponseContent buildSuccess(String message, T data) {
        return new ResponseContent(0, message, data);
    }

    public static ResponseContent buildFail(int code, String message) {
        return new ResponseContent(code, message);
    }

    public static ResponseContent buildFail(int code, String message, String detail) {
        return new ResponseContent(code, message, detail);
    }

    public static ResponseContent buildFail(int code, String message, Object data) {
        return new ResponseContent(code, message, data);
    }

    public static ResponseContent buildFail(String message) {
        logger.error("error", message);
        return new ResponseContent(2, message);
    }

    public static ResponseContent buildNoPermissionFail(String message) {
        return new ResponseContent(961, message);
    }

    public static ResponseContent buildFail(String message, Object data) {
        return new ResponseContent(2, message, data);
    }

    public static ResponseContent buildServerError(String message) {
        return new ResponseContent(500, message);
    }

    public static ResponseContent buildSignatureError(String message) {
        return new ResponseContent(3, message);
    }

    public static ResponseContent buildAuth(String msg) {
        return new ResponseContent(1, msg);
    }

    public static ResponseContent buildCustomizedException(int code, String message) {
        return new ResponseContent(code, message);
    }

    public static <T> ResponseContent buildCustomizedException(int code, String message, T data) {
        return new ResponseContent(code, message, data);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseContent)) {
            return false;
        } else {
            ResponseContent<?> other = (ResponseContent)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseContent;
    }

    public int hashCode() {
        int result = 59 + this.getCode();
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseContent(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
