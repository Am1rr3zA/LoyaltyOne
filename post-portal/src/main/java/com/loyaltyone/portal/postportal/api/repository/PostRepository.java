package com.loyaltyone.portal.postportal.api.repository;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Amirreza Soudi
 * @since 2017-12-07.
 */
@Repository
public class PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public static final String TABLENAME = "POST";

    public int insertNewPost(PostModel post) {

        String sql = "INSERT INTO " + TABLENAME + " (text, creation_ts) VALUES(?, CURRENT_TIMESTAMP())";
        return jdbcTemplate.update(sql, post.getText());

    }

    public PostModel getPostByText(String text) {
        String sql = "SELECT * FROM " + TABLENAME + " where text = ?;";
        return jdbcTemplate.queryForObject(sql, new PostRowMapper(), new Object[] { text });
    }

    public class PostRowMapper implements RowMapper<PostModel>
    {
        public PostModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            PostModel customer = new PostModel();
            customer.setId(rs.getLong("id"));
            customer.setText(rs.getString("text"));
            return customer;
        }

    }
}
