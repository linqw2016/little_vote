package com.graphqljava.little_vote.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Person implements Serializable{
    private Integer id;
    private String username;
    private Integer voteNums;
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Person(int id, int voteNums){
        this.id=id;
        this.voteNums=voteNums;
    }
    public Person(String username,int voteNums){
        this.username=username;
        this.voteNums=voteNums;
    }
    public Person(){}

    public Integer getVoteNums() {
        return voteNums;
    }

    public void setVoteNums(Integer voteNums) {
        this.voteNums = voteNums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
