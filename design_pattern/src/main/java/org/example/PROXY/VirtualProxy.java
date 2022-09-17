package main.java.org.example.PROXY;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Company {
    private String companyName;
    private String companyAddress;
    private ContactList contactList;

    public Company(String companyName, String companyAddress, ContactList contactList) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contactList = contactList;
        System.out.println("Company Object Created");
    }

    public Company() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }
}

interface ContactList {
    public List<Employee> getEmployeeList();
}

class Employee {

    private String employeeName;
    private double employeeSalary;
    private String employeeDesignation;

    public Employee(String employeeName, double employeeSalary, String
            employeeDesignation) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public String toString() {
        return "Employee Name: " + employeeName + ", EmployeeDesignation: " +
                employeeDesignation + ", Employee Salary: " + employeeSalary;
    }
}

class ContactListImpl implements ContactList {
    @Override
    public List<Employee> getEmployeeList() {
        return getEmpList();
    }

    private static List<Employee> getEmpList() {
        List<Employee> empList = new ArrayList<Employee>(5);
        empList.add(new Employee("Employee A", 2565.55, "SE"));
        empList.add(new Employee("Employee B", 22574, "Manager"));
        empList.add(new Employee("Employee C", 3256.77, "SSE"));
        empList.add(new Employee("Employee D", 4875.54, "SSE"));
        empList.add(new Employee("Employee E", 2847.01, "SE"));
        return empList;
    }
}


class ContactListProxyImpl implements ContactList {
    private ContactList contactList;
    @Override
    public List<Employee> getEmployeeList() {
        if (contactList == null) {
            System.out.println("Creating contact list and fetching list of employees...");
            contactList = new ContactListImpl();
        }
        return contactList.getEmployeeList();
    }
}

public class VirtualProxy {
    public static void main(String[] args) {
        Objects.isNull(null);
    ContactList contactList = new ContactListImpl();
    Company company = new Company("Guru Tech","5/6 Savithiri nagar",contactList);
    contactList = company.getContactList();


    }
}
