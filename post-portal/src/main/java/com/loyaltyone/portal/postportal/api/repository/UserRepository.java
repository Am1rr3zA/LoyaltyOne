package com.loyaltyone.portal.postportal.api.repository;

import com.loyaltyone.portal.postportal.api.model.LoginModel;
import com.loyaltyone.portal.postportal.api.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Amirreza Soudi
 * @since 2017-12-09.
 */
@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static final String TABLENAME = "USER";

    public UserModel getUserInfor(LoginModel user) throws Exception {
        String sql = "SELECT * FROM " + TABLENAME + " where username = ?";
        List<UserModel> list = jdbcTemplate.query(sql, new PostRowMapper(), new Object[]{user.getUsername()});
        if (list.size() > 0)
            return list.get(0);
        else
            throw new Exception("User does not exist");

    }

    public class PostRowMapper implements RowMapper<UserModel> {
        public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserModel user = new UserModel();
            user.setId(rs.getLong("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            return user;
        }

    }
}
