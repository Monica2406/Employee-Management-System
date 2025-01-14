package emps.com;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;
    private String designation;
    private String phone;

    public Employee(int id, String name, double salary, String designation, String phone) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Salary: " + salary + "\n" +
               "Designation: " + designation + "\n" +
               "Phone: " + phone;
    }
}

public class EmployeeManagementSystem {
    private final List<Employee> employees = new ArrayList<>();

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    private boolean isValidPhone(String phone) {
    	return phone.matches("\\d{10}");

    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee with the given ID already exists!");
                return;
            }
        }

        String name;
        while (true) {
            System.out.print("Enter Employee Name: ");
            name = scanner.nextLine();
            if (isValidName(name)) {
                break;
            } else {
                System.out.println("Invalid name. Please enter letters only.");
            }
        }

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Employee Designation: ");
        String designation = scanner.nextLine();

        String phone;
        while (true) {
            System.out.print("Enter Employee Phone Number: ");
            phone = scanner.nextLine();
            if (isValidPhone(phone)) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter exactly 10 digits.");
            }
        }

        employees.add(new Employee(id, name, salary, designation, phone));
        System.out.println("Employee added successfully!");
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.println();
        }
    }

    public void searchEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp);
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    public void modifyEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to modify: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Current Details:");
                System.out.println(emp);
                System.out.println();

                System.out.print("Enter new name (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isBlank() && isValidName(name)) {
                    emp.setName(name);
                } else if (!name.isBlank()) {
                    System.out.println("Invalid name. Keeping current.");
                }

                System.out.print("Enter new salary (leave blank to keep current): ");
                String salaryInput = scanner.nextLine();
                if (!salaryInput.isBlank()) {
                    emp.setSalary(Double.parseDouble(salaryInput));
                }

                System.out.print("Enter new designation (leave blank to keep current): ");
                String designation = scanner.nextLine();
                if (!designation.isBlank()) {
                    emp.setDesignation(designation);
                }

                System.out.print("Enter new phone number (leave blank to keep current): ");
                String phone = scanner.nextLine();
                if (!phone.isBlank() && isValidPhone(phone)) {
                    emp.setPhone(phone);
                } else if (!phone.isBlank()) {
                    System.out.println("Invalid phone number. Keeping current.");
                }

                System.out.println("Employee details updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    public void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    public void deleteAllEmployees() {
        employees.clear();
        System.out.println("All employees deleted successfully!");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== Employee Management System ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Modify Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Delete All Employees");
            System.out.println("7. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.addEmployee();
                    break;
                case 2:
                    system.displayEmployees();
                    break;
                case 3:
                    system.searchEmployee();
                    break;
                case 4:
                    system.modifyEmployee();
                    break;
                case 5:
                    system.deleteEmployee();
                    break;
                case 6:
                    system.deleteAllEmployees();
                    break;
                case 7:
                    System.out.println("Thank you for using the Employee Management System. Have a good Day:)!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
