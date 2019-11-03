package com.Liucccc.service;

import com.Liucccc.dto.MoodDTO;
import com.Liucccc.entity.Mood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * com.Liucccc.service
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
public interface MoodService {
    List<MoodDTO> findAll();

    boolean praiseMood(String userId, String moodId);

    boolean update(@Param("mood") Mood mood);

    Mood findById(String id);

    List<MoodDTO> findAllForRedis();

    boolean praiseMoodForRedis(String userId, String moodId);

}
