package com.loyaltyone.portal.postportal.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Amirreza Soudi
 * @since 2017-12-09.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"username, password"})
public class LoginModel {

    private String username;
    private String password;

    public LoginModel() {
    }

    @JsonCreator
    public LoginModel(@JsonProperty("username") String username,
                      @JsonProperty("password") String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginModel loginModel = (LoginModel) o;

        if (username != null ? !username.equals(loginModel.username) : loginModel.username != null) return false;
        return password != null ? !password.equals(loginModel.password) : loginModel.password != null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(username)
                .toString();
    }
}
