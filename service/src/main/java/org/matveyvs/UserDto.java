package org.matveyvs;

public class UserDto {
    private String name;
    private String company;

    public UserDto(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }
}
