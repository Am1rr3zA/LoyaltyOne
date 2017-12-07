package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.config.Routes;
import com.loyaltyone.portal.postportal.api.model.PostModel;
import com.loyaltyone.portal.postportal.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amirreza Soudi
 * @since 2017-12-06.
 */
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = Routes.API_V1_GET_TEXT, method = RequestMethod.GET)
    public PostModel returnInputText(@RequestParam(value="name", defaultValue="Nothing Here") String input) {
        return new PostModel(input);
    }

    @RequestMapping(value = Routes.API_V1_GET_TEXT, method = RequestMethod.POST)
    public PostModel returnJsonBodyText(@RequestBody PostModel post) {
        postService.addNewPost(post);
        return post;
    }
}
