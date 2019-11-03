package com.Liucccc.dto;

import com.Liucccc.entity.Mood;

import java.io.Serializable;

/**
 * com.Liucccc.dto
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
public class MoodDTO extends Mood implements Serializable {
    private String userName;
    private String userAccount;

    @Override
    public String toString() {
        return "MoodDTO{" +
                "userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
