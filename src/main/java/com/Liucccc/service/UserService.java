package com.Liucccc.service;

import com.Liucccc.dto.UserDTO;

/**
 * UserService
 *
 * @author liuchao
 * @date 2019-10-29 14:16
 */
public interface UserService {
    UserDTO find(String id);
}
