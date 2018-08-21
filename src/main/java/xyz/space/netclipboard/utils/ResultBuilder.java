package xyz.space.netclipboard.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created By space on 2018/8/21
 */
@SuppressWarnings("unchecked")
public class ResultBuilder<T> {
    private static final int FAILURE_CODE = ErrorCode.ERROR.getVal();
    private static final int SUCCESS_CODE = ErrorCode.SUCCESS.getVal();

    private int error;
    private String msg;
    private T data;

    private ResultBuilder() {
        error = SUCCESS_CODE;
        msg = StringUtils.EMPTY;
    }

    private ResultBuilder(T t) {
        error = SUCCESS_CODE;
        msg = StringUtils.EMPTY;
        data = t;
    }

    public static <T> ResultBuilder<T> builder() {
        return new ResultBuilder();
    }

    public static <T> ResultBuilder<T> builder(T t) {
        return new ResultBuilder(t);
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
