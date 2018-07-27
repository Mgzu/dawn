package org.dawn.dto;

/**
 * 消息 dto
 *
 * @author mgzu
 * @date 2018/5/9
 */
public class MessageDto {

    private int type;
    private int userNum;
    private String message;

    public MessageDto() {
        super();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
