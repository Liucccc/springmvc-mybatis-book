package com.Liucccc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * com.Liucccc.entity
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
public class Mood implements Serializable {
    private String id;
    private String content;
    private Integer praiseNum;
    private String userId;
    private Date publishTime;

    @Override
    public String toString() {
        return "Mood{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", praiseNum=" + praiseNum +
                ", userId='" + userId + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
