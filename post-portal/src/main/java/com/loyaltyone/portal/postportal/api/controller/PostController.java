package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.config.Routes;
import com.loyaltyone.portal.postportal.api.model.PostModel;
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
    @RequestMapping(value = Routes.API_V1_GET_TEXT, method = RequestMethod.GET)
    public String returnInputText(@RequestParam(value="name", defaultValue="Nothing Here") String input) {
        return input;
    }

    @RequestMapping(value = Routes.API_V1_GET_TEXT, method = RequestMethod.POST)
    public String returnJsonBodyText(@RequestBody PostModel post) {
        return post.toString();
    }
}
