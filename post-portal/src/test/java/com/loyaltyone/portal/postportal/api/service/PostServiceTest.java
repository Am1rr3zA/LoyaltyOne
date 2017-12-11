package com.loyaltyone.portal.postportal.api.service;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import com.loyaltyone.portal.postportal.api.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Amirreza Soudi
 * @since 2017-12-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void addNewPost() throws Exception {
    }

    @Test
    public void getAllPostsOfUser() throws Exception {
        List<PostModel> list = postRepository.getAllPostsOfUser(4);
        assertEquals(4, list.size());
    }

}