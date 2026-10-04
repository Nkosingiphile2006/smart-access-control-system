# Smart Access Control System

This Java project models a smart access control system for an organization. It supports:

- Employee/user login with department-specific credentials
- Smart resource access rules
- ACL-style authorization checks
- Restriction of core resources to the IT department only
- Sample demo that simulates access requests by department

## Features

- User authentication using username/password
- Department-based users: IT, HR, FINANCE, and OPERATIONS
- Resource classification: core vs. non-core
- Access decisions based on department permissions and specific action rules

## Project Structure

- `src/main/java/com/smartaccess/Department.java`
- `src/main/java/com/smartaccess/Action.java`
- `src/main/java/com/smartaccess/User.java`
- `src/main/java/com/smartaccess/Resource.java`
- `src/main/java/com/smartaccess/AccessControlService.java`
- `src/main/java/com/smartaccess/SmartAccessDemo.java`

## Run the program

```bash
mvn compile exec:java -Dexec.mainClass=com.smartaccess.SmartAccessDemo
```

If `exec-maven-plugin` is not configured, run:

```bash
mvn compile
java -cp target/classes com.smartaccess.SmartAccessDemo
```

## Example logic

- Only IT can access the `Core Database`
- HR can access employee records
- Finance can access the payroll system
- Any department without permission is denied

