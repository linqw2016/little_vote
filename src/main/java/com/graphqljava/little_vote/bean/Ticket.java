package com.graphqljava.little_vote.bean;

import com.graphqljava.little_vote.Utils.AesEncryptUtils;

import java.io.Serializable;
import java.util.Map;

public class Ticket implements Serializable {
    private String time;
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public Ticket(){}
    public Ticket(String time){
        this.time=time;
    }
    public boolean isUseful() throws Exception {
        Map<String, String> codeMap = TicketManager.codeMap;
        String token = AesEncryptUtils.encrypt(codeMap.get("ticket"));
        return token.equals(time);
    }
}
