package org.dawn.dto;

/**
 * Web Socket 消息类
 *
 * @author mgzu
 * @date 2018/7/11
 */
public class Greeting {
    private String content;
    private Object userNum;

    public Greeting() {
    }

    public Greeting(String content, Object userNum) {
        super();
        this.content = content;
        this.userNum = userNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getUserNum() {
        return userNum;
    }

    public void setUserNum(Object userNum) {
        this.userNum = userNum;
    }

}
