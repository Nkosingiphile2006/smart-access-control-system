package com.smartaccess;

import java.util.HashMap;
import java.util.Map;

public class AccessControlService {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Resource> resources = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void registerResource(Resource resource) {
        resources.put(resource.getName(), resource);
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean canAccess(User user, String resourceName, Action action) {
        Resource resource = resources.get(resourceName);
        if (user == null || resource == null) {
            return false;
        }

        if (resource.isCoreResource()) {
            if (user.getDepartment() != Department.IT) {
                return false;
            }
        }

        if (!resource.allowsDepartment(user.getDepartment())) {
            return false;
        }

        switch (action) {
            case ACCESS_CORE:
                return resource.isCoreResource() && user.getDepartment() == Department.IT;
            case READ_EMPLOYEE:
                return "HR".equalsIgnoreCase(resource.getCategory()) &&
                        (user.getDepartment() == Department.HR || user.getDepartment() == Department.IT);
            case VIEW_PAYROLL:
                return "FINANCE".equalsIgnoreCase(resource.getCategory()) &&
                        (user.getDepartment() == Department.FINANCE || user.getDepartment() == Department.IT);
            case VIEW:
            case EDIT:
            case DELETE:
                return true;
            default:
                return false;
        }
    }
}
