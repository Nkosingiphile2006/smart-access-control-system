package com.smartaccess;

public class User {
    private final String username;
    private final String password;
    private final Department department;

    public User(String username, String password, Department department) {
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", department=" + department +
                '}';
    }
}
