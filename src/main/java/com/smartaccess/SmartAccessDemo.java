package com.smartaccess;

import java.util.Set;

public class SmartAccessDemo {
    public static void main(String[] args) {
        AccessControlService accessService = new AccessControlService();

        accessService.registerUser(new User("it_admin", "it123", Department.IT));
        accessService.registerUser(new User("hr_staff", "hr123", Department.HR));
        accessService.registerUser(new User("finance_staff", "fin123", Department.FINANCE));
        accessService.registerUser(new User("ops_staff", "ops123", Department.OPERATIONS));

        accessService.registerResource(new Resource(
                "Core Database",
                "CORE",
                true,
                Set.of(Department.IT)
        ));

        accessService.registerResource(new Resource(
                "Employee Records",
                "HR",
                false,
                Set.of(Department.HR, Department.IT)
        ));

        accessService.registerResource(new Resource(
                "Payroll System",
                "FINANCE",
                false,
                Set.of(Department.FINANCE, Department.IT)
        ));

        System.out.println("=== Smart Access Control Demo ===");

        User itUser = accessService.login("it_admin", "it123");
        User hrUser = accessService.login("hr_staff", "hr123");
        User financeUser = accessService.login("finance_staff", "fin123");
        User opsUser = accessService.login("ops_staff", "ops123");

        System.out.println("IT user logged in: " + itUser);
        System.out.println("HR user logged in: " + hrUser);
        System.out.println("Finance user logged in: " + financeUser);
        System.out.println("Operations user logged in: " + opsUser);

        System.out.println();
        System.out.println("IT accesses Core Database: " +
                accessService.canAccess(itUser, "Core Database", Action.ACCESS_CORE));
        System.out.println("HR accesses Core Database: " +
                accessService.canAccess(hrUser, "Core Database", Action.ACCESS_CORE));
        System.out.println("HR reads Employee Records: " +
                accessService.canAccess(hrUser, "Employee Records", Action.READ_EMPLOYEE));
        System.out.println("Finance accesses Payroll System: " +
                accessService.canAccess(financeUser, "Payroll System", Action.VIEW_PAYROLL));
        System.out.println("Operations accesses Payroll System: " +
                accessService.canAccess(opsUser, "Payroll System", Action.VIEW_PAYROLL));
    }
}
