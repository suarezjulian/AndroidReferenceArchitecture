package com.tech.freak.referencearchitecture.model;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j.suarez on 4/14/2015.
 */
public class Value implements Serializable {
    @Expose
    private Integer id;
    @Expose
    private String joke;
    @Expose
    private List<String> categories = new ArrayList<>();

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The joke
     */
    public String getJoke() {
        return joke;
    }

    /**
     * @param joke The joke
     */
    public void setJoke(String joke) {
        this.joke = joke;
    }

    /**
     * @return The categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(joke).append(categories).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Value) == false) {
            return false;
        }
        Value rhs = ((Value) other);
        return new EqualsBuilder().append(id, rhs.id).append(joke, rhs.joke).append(categories, rhs.categories).isEquals();
    }
}
