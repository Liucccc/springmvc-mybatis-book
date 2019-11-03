package com.Liucccc.service;

import com.Liucccc.entity.UserMoodPraiseRel;
import org.springframework.stereotype.Service;

/**
 * com.Liucccc.service.impl
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Service
public interface UserMoodPraiseRelService {
    boolean save(UserMoodPraiseRel userMoodPraiseRel);
}
