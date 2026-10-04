package com.smartaccess;

import java.util.HashSet;
import java.util.Set;

public class Resource {
    private final String name;
    private final String category;
    private final boolean coreResource;
    private final Set<Department> allowedDepartments;

    public Resource(String name, String category, boolean coreResource, Set<Department> allowedDepartments) {
        this.name = name;
        this.category = category;
        this.coreResource = coreResource;
        this.allowedDepartments = new HashSet<>(allowedDepartments);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCoreResource() {
        return coreResource;
    }

    public Set<Department> getAllowedDepartments() {
        return allowedDepartments;
    }

    public boolean allowsDepartment(Department department) {
        return allowedDepartments.contains(department);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", coreResource=" + coreResource +
                ", allowedDepartments=" + allowedDepartments +
                '}';
    }
}
