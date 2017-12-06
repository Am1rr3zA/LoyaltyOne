package com.loyaltyone.portal.postportal.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Amirreza Soudi
 * @since 2017-12-06.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // do not serialize null fields (omit them)
@JsonPropertyOrder({"name"})
public class PostModel {
    private String name;

    public PostModel() {
        name = "Nothing Here";
    }

    @JsonCreator
    public PostModel(@JsonProperty("name") String name) {

        this.name = name;


    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostModel post = (PostModel) o;

        return name != null ? name.equals(post.name) : post.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).toString();
    }
}
