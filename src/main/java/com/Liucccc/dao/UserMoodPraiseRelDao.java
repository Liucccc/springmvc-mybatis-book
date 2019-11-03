package com.Liucccc.dao;

import com.Liucccc.entity.UserMoodPraiseRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * com.Liucccc.dao
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Repository
public interface UserMoodPraiseRelDao {
    boolean save(@Param("userMoodPraiseRel") UserMoodPraiseRel userMoodPraiseRel);
}
