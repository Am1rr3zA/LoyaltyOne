package com.loyaltyone.portal.postportal.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Amirreza Soudi
 * @since 2017-12-06.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // do not serialize null fields (omit them)
@JsonPropertyOrder({"id, text, user_id"})
public class PostModel {

    private String id;

    private String text;

    private Long user_id;

    public PostModel() {
        text = "Nothing Here";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonCreator
    public PostModel(@JsonProperty("id") String id,
                     @JsonProperty("text") String name,
                     @JsonProperty("user_id") long user_id) {
        this.id = id;
        this.text = name;
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostModel postModel = (PostModel) o;

        if (id != null ? !id.equals(postModel.id) : postModel.id != null) return false;
        if (text != null ? !text.equals(postModel.text) : postModel.text != null) return false;
        return user_id != null ? user_id.equals(postModel.user_id) : postModel.user_id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(text)
                .append(user_id)
                .toString();
    }
}
