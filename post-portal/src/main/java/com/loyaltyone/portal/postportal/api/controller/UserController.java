package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.config.Routes;
import com.loyaltyone.portal.postportal.api.model.LoginModel;
import com.loyaltyone.portal.postportal.api.model.UserModel;
import com.loyaltyone.portal.postportal.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amirreza Soudi
 * @since 2017-12-09.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = Routes.API_GET_USER, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public UserModel returnJsonBodyText(@RequestBody LoginModel user) throws Exception {
        UserModel um = userService.getUserInfo(user);
        return um;
    }
}
