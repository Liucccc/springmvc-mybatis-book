package com.Liucccc.service.impl;

import com.Liucccc.dao.UserDao;
import com.Liucccc.entity.User;
import com.Liucccc.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author liuchao
 * @date 2019-10-29 14:17
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findALl();
    }
}
