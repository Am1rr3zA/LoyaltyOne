package com.loyaltyone.portal.postportal.api.service;

import com.loyaltyone.portal.postportal.api.model.LoginModel;
import com.loyaltyone.portal.postportal.api.model.UserModel;
import com.loyaltyone.portal.postportal.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amirreza Soudi
 * @since 2017-12-09.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel getUserInfo(LoginModel user) throws Exception {
        return userRepository.getUserInfor(user);
    }
}
