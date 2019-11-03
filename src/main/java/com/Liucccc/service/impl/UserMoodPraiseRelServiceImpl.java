package com.Liucccc.service.impl;

import com.Liucccc.dao.UserMoodPraiseRelDao;
import com.Liucccc.entity.UserMoodPraiseRel;
import com.Liucccc.service.UserMoodPraiseRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * com.Liucccc.service.impl
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Service
public class UserMoodPraiseRelServiceImpl implements UserMoodPraiseRelService {
    @Resource
    UserMoodPraiseRelDao userMoodPraiseRelDao;

    @Override
    public boolean save(UserMoodPraiseRel userMoodPraiseRel) {
        return userMoodPraiseRelDao.save(userMoodPraiseRel);
    }
}
