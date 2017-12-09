package com.loyaltyone.portal.postportal.api.repository;

import com.loyaltyone.portal.postportal.api.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

        String sql = "INSERT INTO " + TABLENAME + " (text, creation_ts, user_id) VALUES(?, CURRENT_TIMESTAMP(), ?)";
        return jdbcTemplate.update(sql, post.getText(), post.getUser_id());

    }

    public PostModel getPostByText(String text) {
        String sql = "SELECT * FROM " + TABLENAME + " where text = ?;";
        return jdbcTemplate.queryForObject(sql, new PostRowMapper(), new Object[]{text});
    }

    public List<PostModel> getAllPostsOfUser(long user_id) {
        String sql = "SELECT * FROM " + TABLENAME + " where user_id = ?;";
        return jdbcTemplate.query(sql, new PostRowMapper(), new Object[]{user_id});
    }

    public class PostRowMapper implements RowMapper<PostModel> {
        public PostModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            PostModel customer = new PostModel();
            customer.setId(rs.getLong("id"));
            customer.setText(rs.getString("text"));
            customer.setUser_id(rs.getLong("user_id"));
            return customer;
        }

    }
}
