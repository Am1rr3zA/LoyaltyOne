package com.loyaltyone.portal.postportal.api.controller;

import com.loyaltyone.portal.postportal.api.config.Routes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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


    @Test
    public void returnInputText() throws Exception {
        this.mockMvc.perform(get(Routes.API_V1_GET_TEXT))
                .andExpect(status().isOk())
                .andExpect(content().string("Nothing Here"))
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