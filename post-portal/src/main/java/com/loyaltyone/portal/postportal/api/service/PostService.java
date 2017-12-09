package com.loyaltyone.portal.postportal.api.service;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import com.loyaltyone.portal.postportal.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amirreza Soudi
 * @since 2017-12-07.
 */
@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public int addNewPost(PostModel post) {
        return postRepository.insertNewPost(post);
    }

    public List<PostModel> getAllPostsOfUser(long user_id) {
        return postRepository.getAllPostsOfUser(user_id);
    }
}
