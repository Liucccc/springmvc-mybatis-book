package com.Liucccc.entity;

import java.io.Serializable;

/**
 * User
 *
 * @author liuchao
 * @date 2019-10-29 14:12
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String account;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
