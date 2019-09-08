package com.erp.controller;

import com.erp.constant.ErpConstant;
import com.erp.pojo.User;
import com.erp.service.UserService;
import com.erp.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Du
 * @date : 2019/8/24 21:11
 * @description :
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(User user, HttpServletRequest request) {
        System.out.print("================");
        if (!StringUtils.isBlank(user.getPassword())) {
            User result = userService.login(user);
            if (result != null) {
                request.getSession().setAttribute(ErpConstant.USER_IN_SESSION, result);
                return new Result(200);
            }
        }
        return new Result(403);
    }

    @RequestMapping("/logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().removeAttribute(ErpConstant.USER_IN_SESSION);
        return new Result(200);
    }
}
