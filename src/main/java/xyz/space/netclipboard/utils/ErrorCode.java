package xyz.space.netclipboard.utils;

/**
 * Created By space on 2018/8/21
 */
public enum  ErrorCode {
    SUCCESS(0),
    ERROR(1),
    ;
    private final int val;
    private String msg;

    ErrorCode(int val) {
        this.val = val;
    }

    ErrorCode(int val, String msg) {
        this.val = val;
        this.msg = msg;
    }

    public int getVal() {
        return val;
    }

    public String getMsg() {
        return msg;
    }
}
