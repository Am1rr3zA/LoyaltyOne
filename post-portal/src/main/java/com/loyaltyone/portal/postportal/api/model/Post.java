package com.loyaltyone.portal.postportal.api.model;

/**
 * @author Amirreza Soudi
 * @since 2017-12-06.
 */
public class Post {
    private String name;

    public Post(String name) {
        this.name = name;
    }

    public Post() {

    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

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
