package com.Liucccc.dao;

import com.Liucccc.entity.Mood;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.Liucccc.dao
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Repository
public interface MoodDao {
    List<Mood> findAll();

    boolean update(@Param("mood") Mood mood);

    Mood findById(String id);
}
