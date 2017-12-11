package com.loyaltyone.portal.postportal.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amirreza Soudi
 * @since 2017-12-06.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // do not serialize null fields (omit them)
@JsonPropertyOrder({"id, date, parent_id, text, user_id, city, comments"})
public class PostModel {

    private String id;

    private LocalDateTime date;

    private String parent_id;

    private String text;

    private Long user_id;

    private CityModel city;

    private List<PostModel> comments;

    public PostModel() {
        text = "Nothing Here";
        this.comments = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonCreator
    public PostModel(@JsonProperty("id") String id,
                     @JsonProperty("date") LocalDateTime date,
                     @JsonProperty("parent_id") String parent_id,
                     @JsonProperty("text") String name,
                     @JsonProperty("user_id") long user_id,
                     @JsonProperty("city") CityModel city,
                     @JsonProperty("comments") List<PostModel> comments) {
        this.id = id;
        this.date = date;
        this.parent_id = parent_id;
        this.text = name;
        this.user_id = user_id;
        this.city = city;
        this.comments = comments;
        this.comments = new ArrayList<>();
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(Timestamp timestamp) {
        this.date = timestamp.toLocalDateTime();
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

    public CityModel getCity() {
        return city;
    }

    public void setCity(CityModel city) {
        this.city = city;
    }

    public List<PostModel> getComments() {
        return comments;
    }

    public void setComments(List<PostModel> comments) {
        this.comments = comments;
    }

    public void addComment(PostModel comment) {
        this.comments.add(comment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostModel postModel = (PostModel) o;

        if (id != null ? !id.equals(postModel.id) : postModel.id != null) return false;
        if (date != null ? !date.equals(postModel.date) : postModel.date != null) return false;
        if (parent_id != null ? !parent_id.equals(postModel.parent_id) : postModel.parent_id != null) return false;
        if (text != null ? !text.equals(postModel.text) : postModel.text != null) return false;
        if (user_id != null ? !user_id.equals(postModel.user_id) : postModel.user_id != null) return false;
        if (city != null ? !city.equals(postModel.city) : postModel.city != null) return false;
        return comments != null ? comments.equals(postModel.comments) : postModel.comments == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (parent_id != null ? parent_id.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(text)
                .append(user_id)
                .append(city)
                .append(comments)
                .toString();
    }
}
