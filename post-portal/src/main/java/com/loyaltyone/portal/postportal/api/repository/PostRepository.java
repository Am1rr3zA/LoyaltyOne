package com.loyaltyone.portal.postportal.api.repository;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author Amirreza Soudi
 * @since 2017-12-07.
 */
@Repository
public class PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public final String tableName = "POST";

    public int insertNewPost(PostModel post) {

        String sql = "INSERT INTO POST (text, creation_ts) VALUES(?, CURRENT_TIMESTAMP());";
        return jdbcTemplate.update(sql, post.getName());

    }

}
