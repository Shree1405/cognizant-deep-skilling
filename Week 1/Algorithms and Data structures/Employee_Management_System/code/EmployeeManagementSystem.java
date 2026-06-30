package Employee_Management_System.code;

public class EmployeeManagementSystem {

    static Employee[] employees =
            new Employee[5];

    static int count = 0;

    // Add Employee
    public static void addEmployee(
            Employee employee) {

        if (count < employees.length) {

            employees[count] = employee;
            count++;

            System.out.println(
                    "Employee Added Successfully");
        }

        else {

            System.out.println(
                    "Employee Array is Full");
        }
    }

    // Search Employee
    public static void searchEmployee(
            int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId
                    == employeeId) {

                System.out.println(
                        employees[i]);

                return;
            }
        }

        System.out.println(
                "Employee Not Found");
    }

    // Traverse Employees
    public static void traverseEmployees() {

        for (int i = 0; i < count; i++) {

            System.out.println(
                    employees[i]);

            System.out.println(
                    "---------------------");
        }
    }

    // Delete Employee
    public static void deleteEmployee(
            int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId
                    == employeeId) {

                for (int j = i;
                     j < count - 1;
                     j++) {

                    employees[j] =
                            employees[j + 1];
                }

                employees[count - 1] = null;
                count--;

                System.out.println(
                        "Employee Deleted Successfully");

                return;
            }
        }

        System.out.println(
                "Employee Not Found");
    }

    public static void main(
            String[] args) {

        addEmployee(
                new Employee(
                        101,
                        "Rahul",
                        "Developer",
                        60000));

        addEmployee(
                new Employee(
                        102,
                        "Priya",
                        "Tester",
                        50000));

        addEmployee(
                new Employee(
                        103,
                        "Ananya",
                        "Manager",
                        85000));

        System.out.println(
                "\nEmployee Records\n");

        traverseEmployees();

        System.out.println(
                "\nSearching Employee\n");

        searchEmployee(
                102);

        System.out.println(
                "\nDeleting Employee\n");

        deleteEmployee(
                102);

        System.out.println(
                "\nEmployee Records After Deletion\n");

        traverseEmployees();
    }
}