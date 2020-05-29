package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;

/**
 * WebSocket message model
 */
public class Message {
    public static final String SPEAK = "SPEAK";
    public static final String QUIT = "QUIT";
    public static final String ENTER = "ENTER";

    private String username;
    private String msg;
    private Integer onlineCount;
    private String type;

    public Message(){}

    public Message(String username, String type, String msg, Integer onlineCount)
    {
        this.username = username;
        this.onlineCount = onlineCount;
        this.msg = msg;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String jsonStr(String type, String username, String msg, Integer onlineCount){
        return JSON.toJSONString(new Message(username, type, msg, onlineCount));
    }
}
