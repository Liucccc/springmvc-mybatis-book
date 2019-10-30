package com.Liucccc.dao;

import com.Liucccc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 *
 * @author liuchao
 * @date 2019-10-29 14:15
 */
@Repository
public interface UserDao {
    List<User> findAll();
}
