package org.matveyvs;

public class UserDto {
    private Long id;
    private String name;
    private String company;

    public UserDto(Long id, String name, String company) {
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
}
