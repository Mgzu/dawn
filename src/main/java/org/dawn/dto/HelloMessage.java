package org.dawn.dto;

/**
 * hello 消息类
 *
 * @author mgzu
 * @date 2018/5/9
 */
public class HelloMessage {
    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
