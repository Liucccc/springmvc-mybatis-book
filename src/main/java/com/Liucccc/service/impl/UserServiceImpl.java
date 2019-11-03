package com.Liucccc.service.impl;

import com.Liucccc.dao.UserDao;
import com.Liucccc.dto.UserDTO;
import com.Liucccc.entity.User;
import com.Liucccc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author liuchao
 * @date 2019-10-29 14:17
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserDTO find(String id) {
        User user = userDao.find(id);
        return convertMode2DTO(user);
    }

    private UserDTO convertMode2DTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAccount(user.getAccount());
        return userDTO;
    }
}
