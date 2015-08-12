package com.tech.freak.referencearchitecture.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;

/**
 * Created by j.suarez on 4/14/2015.
 */
public class Jokes implements Serializable {
    @Expose
    private String type;
    @Expose
    private List<Value> value = new ArrayList<Value>();

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The value
     */
    public List<Value> getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(List<Value> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Jokes)) {
            return false;
        }
        Jokes rhs = ((Jokes) other);
        return new EqualsBuilder().append(type, rhs.type).append(value, rhs.value).isEquals();
    }
}
