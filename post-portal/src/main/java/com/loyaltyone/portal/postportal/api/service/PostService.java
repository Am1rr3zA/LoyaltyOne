package com.loyaltyone.portal.postportal.api.service;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import com.loyaltyone.portal.postportal.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<PostModel> listOfPosts = postRepository.getAllPostsOfUser(user_id);
        List<PostModel> nestPostsList = listOfPosts.stream()
                .filter(c -> c.getParent_id() == null)
                .collect(Collectors.toList());



        for (PostModel pm : nestPostsList) {
            pm.setComments(listOfPosts.stream().filter(c -> pm.getId().equals(c.getParent_id())).collect(Collectors.toList()));
            for (PostModel pm2 : pm.getComments()) {
                pm2.setComments(listOfPosts.stream().filter(c -> pm2.getId().equals(c.getParent_id())).collect(Collectors.toList()));
            }
        }


        return nestPostsList;
    }

    public PostModel getPostById(String id) {
        return postRepository.getPostById(id);
    }
}
