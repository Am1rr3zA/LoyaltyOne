package com.loyaltyone.portal.postportal.api.service;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import com.loyaltyone.portal.postportal.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String, Integer> idMap = new HashMap<>();

        int index = 0;
        for (PostModel pm : listOfPosts) {
            idMap.put(pm.getId(), index);
            index++;
        }

        for (int i = 0; i < listOfPosts.size(); i++) {
            if (listOfPosts.get(i).getParent_id() != null) {
                int idx = idMap.get(listOfPosts.get(i).getParent_id());
                listOfPosts.get(idx).addComment(listOfPosts.get(i));
            }
        }

        List<PostModel> nestPostsList = listOfPosts.stream()
                .filter(c -> c.getParent_id() == null)
                .collect(Collectors.toList());



        return nestPostsList;
    }

    public PostModel getPostById(String id) {
        return postRepository.getPostById(id);
    }
}
