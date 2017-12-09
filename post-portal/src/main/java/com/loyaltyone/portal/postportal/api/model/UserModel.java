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
@JsonPropertyOrder({"id, firstname, lastname"})
public class UserModel {
    private long id;
    private String firstname;
    private String lastname;

    public UserModel() {
    }

    @JsonCreator
    public UserModel(@JsonProperty("id") long id,
                     @JsonProperty("firstname") String firstname,
                     @JsonProperty("lastname") String lastname) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (firstname != null ? !firstname.equals(userModel.firstname) : userModel.firstname != null) return false;
        return lastname != null ? lastname.equals(userModel.lastname) : userModel.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(id)
                .append(firstname)
                .append(lastname)
                .toString();
    }
}
