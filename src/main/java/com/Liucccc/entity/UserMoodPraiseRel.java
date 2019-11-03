package com.Liucccc.entity;

import java.io.Serializable;

/**
 * com.Liucccc.entity
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
public class UserMoodPraiseRel implements Serializable {
    private String id;
    private String moodId;
    private String userId;

    @Override
    public String toString() {
        return "UserMoodPraiseRel{" +
                "id='" + id + '\'' +
                ", moodId='" + moodId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoodId() {
        return moodId;
    }

    public void setMoodId(String moodId) {
        this.moodId = moodId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
