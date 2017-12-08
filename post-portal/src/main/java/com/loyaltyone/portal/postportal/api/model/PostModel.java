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
@JsonPropertyOrder({"text"})
public class PostModel {

    private Long id;

    private String text;

    public PostModel() {
        text = "Nothing Here";
    }

    public PostModel(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonCreator
    public PostModel(@JsonProperty("text") String name) {

        this.text = name;


    }

    public String getText() {
        return text;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostModel post = (PostModel) o;

        return text != null ? text.equals(post.text) : post.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(text).toString();
    }
}
