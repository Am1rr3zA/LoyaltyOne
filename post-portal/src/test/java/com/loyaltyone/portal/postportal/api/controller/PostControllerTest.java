package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.config.Routes;
import com.loyaltyone.portal.postportal.api.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
    public void returnDefaultInputText() throws Exception {
        this.mockMvc.perform(get(Routes.API_V1_GET_TEXT))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Nothing Here\"}"))
                .andDo(print());
    }

    @Test
    public void returnParameterInputText() throws Exception {
        this.mockMvc.perform(get(Routes.API_V1_GET_TEXT)
                .param("name", "John"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"John\"}"))
                .andDo(print());
    }

    @Test
    public void returnJsonBodyText() throws Exception {

        mockMvc.perform(post(Routes.API_V1_GET_TEXT)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Amirreza\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Amirreza")));
    }

}