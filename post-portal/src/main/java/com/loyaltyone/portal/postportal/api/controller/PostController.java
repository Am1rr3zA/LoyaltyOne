package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.config.Routes;
import com.loyaltyone.portal.postportal.api.model.PostModel;
import com.loyaltyone.portal.postportal.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Amirreza Soudi
 * @since 2017-12-06.
 */
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = Routes.API_GET_POST, method = RequestMethod.POST)
    public PostModel returnJsonBodyText(@RequestBody PostModel post) {
        postService.addNewPost(post);
        return post;
    }

    @RequestMapping(value = Routes.API_GET_ALL_POSTS_BY_USER, method = RequestMethod.GET)
    public List<PostModel> returnAllPostsByUSer(@RequestParam(value="id", required=false) String id) {
        List<PostModel> ss = postService.getAllPostsOfUser(Long.valueOf(id));
        return ss;
    }
}
