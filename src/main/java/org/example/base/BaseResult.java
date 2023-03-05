package org.example.base;

public class BaseResult {
    private String message;
    private int code;
    private Object data;

    public BaseResult(Object data) {
        this.data = data;
    }

    public BaseResult(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public BaseResult(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static BaseResult succees(Object data) {
        return new BaseResult(data);
    }

    public static BaseResult error(int code, String message) {
        return new BaseResult(message, code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
