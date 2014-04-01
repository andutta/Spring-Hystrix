package com.orbitz.example.hystrix.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

/**
 * Flex Mapping pojo, mapped to Couchbase and Solr.
 */
public class Mapping {

    @Id
    @Field("flex.id")
    private String id;

    @Field("flex.pos")
    private String pos;

    @Field("flex.locale")
    private String locale;

    @Field("flex.location")
    private String location;

    public Mapping() {
    }

    public Mapping(String id, String pos, String locale, String location) {
        this.id = id;
        this.pos = pos;
        this.locale = locale;
        this.location = location;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}