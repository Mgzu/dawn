package org.dawn.dto;

/**
 * 默认数据返回类
 *
 * @author mgzu
 * @date 2018/5/9
 */
public class RestDto {

    private boolean isSuccess;
    private int strutsCode;
    private Object data;
    private String msg;

    /**
     * 成功
     */
    public RestDto() {
        super();
        this.isSuccess = true;
        this.strutsCode = 200;
        this.msg = "成功！";
    }

    /**
     * 成功（需要返回数据）
     */
    public RestDto(Object data) {
        super();
        this.isSuccess = true;
        this.strutsCode = 200;
        this.data = data;
        this.msg = "成功！";
    }

    /**
     * 失败
     */
    public RestDto(int strutsCode, String msg) {
        super();
        this.isSuccess = false;
        this.strutsCode = strutsCode;
        this.msg = msg;
    }

    public RestDto(int strutsCode, boolean success, Object data, String msg) {
        super();
        this.isSuccess = success;
        this.strutsCode = strutsCode;
        this.data = data;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getStrutsCode() {
        return strutsCode;
    }

    public void setStrutsCode(int strutsCode) {
        this.strutsCode = strutsCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
