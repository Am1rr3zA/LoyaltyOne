package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.config.Routes;
import com.loyaltyone.portal.postportal.api.service.PostService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author Amirreza Soudi
 * @since 2017-12-06.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void returnJsonBodyText() throws Exception {

        mockMvc.perform(post(Routes.API_GET_POST)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"abc\", \"text\": \"ddd\", \"user_id\": 1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void returnEmptyListForUser() throws Exception {
        this.mockMvc.perform(get(Routes.API_GET_ALL_POSTS_BY_USER)
                .param("id", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }


}