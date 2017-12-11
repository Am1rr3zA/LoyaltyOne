package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import com.loyaltyone.portal.postportal.api.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Amirreza Soudi
 * @since 2017-12-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostControllerService {

    @Autowired
    PostService postService;

    @Test
    public void GetAllpostsByUser() {
        List<PostModel> list = postService.getAllPostsOfUser(4);
        assertEquals(2,list.size());
    }
}
