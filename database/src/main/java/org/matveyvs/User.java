package org.matveyvs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Long id;
    private String name;
    private String company;

    public User(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("company") String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
