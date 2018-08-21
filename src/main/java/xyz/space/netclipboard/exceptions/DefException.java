package xyz.space.netclipboard.exceptions;


import xyz.space.netclipboard.utils.ErrorCode;

/**
 * Created by space on 2017/10/30.
 */
public class DefException extends RuntimeException{
    private ErrorCode errorCode = ErrorCode.ERROR;
    private String customMsg;

    public DefException() {
        super("内部错误，操作不成功");
        customMsg = "内部错误，操作不成功";
    }

    public DefException(String msg) {
        super(msg);
        customMsg = msg;
    }

    public DefException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
        customMsg = errorCode.getMsg();
    }

    public DefException(ErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
        customMsg = msg;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getCustomMsg() {
        return customMsg;
    }
}
