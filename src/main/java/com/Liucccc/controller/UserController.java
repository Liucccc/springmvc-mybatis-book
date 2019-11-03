package com.Liucccc.controller;

import com.Liucccc.entity.User;
import com.Liucccc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserController
 *
 * @author liuchao
 * @date 2019-10-29 14:19
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
}
