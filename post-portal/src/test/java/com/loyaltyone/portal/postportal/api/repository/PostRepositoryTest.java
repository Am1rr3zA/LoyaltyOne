package com.loyaltyone.portal.postportal.api.repository;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Amirreza Soudi
 * @since 2017-12-08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;


    @Test
    public void InserNewPost() {
        PostModel pm = new PostModel( "absdcjgs","Test Post", 1);
        postRepository.insertNewPost(pm);
        PostModel dbPost =  postRepository.getPostByText("Test Post");
//        List<PostModel> aa = postRepository.getAllPostsOfUser(1);
        assertEquals(pm.getText(), dbPost.getText());
    }

}