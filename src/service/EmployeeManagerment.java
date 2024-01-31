package service;

import model.Department;
import model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagerment implements Management<Employee, String> {
    Scanner sc = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();
    Employee employee = new Employee();




    public List<Employee> getInfoEployees() {
        return this.employees;
    }
    public  void addEmployeesToList() {
        // Tạo đối tượng Department để sử dụng
        Department department = new Department("D001", "Sales", 50);

        // Tạo đối tượng Employee và thêm vào mảng employeeList
       Employee employee1 = new Employee("E001", "John Doe", LocalDate.of(1990, 1, 15), true, BigDecimal.valueOf(5000), null, department);
        Employee employee2 = new Employee("E002", "Jane Smith", LocalDate.of(1985, 5, 20), false, BigDecimal.valueOf(6000), employee1, department);
        Employee employee3 = new Employee("E003", "Bob Johnson", LocalDate.of(1995, 10, 10), true, BigDecimal.valueOf(4500), employee1, department);
        Employee employee4=new Employee("E0001","aa",LocalDate.of(1990, 1, 15),true,BigDecimal.valueOf(5000),employee2,department);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

    }


    @Override
    public void display() {
        for (Employee employee : employees) {
            System.out.println("Mã nhân viên" + employee.getEmployeeID() +
                    "tên nhân viên" + employee.getGetEmployeeName());
        }
    }

    public void displayAll() {
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }

    @Override
    public void add(Employee element) {
        employees.add(element);
        Department department=element.getDepartment();
        department.setTotalMembers(department.getTotalMembers()+1);
        System.out.println("thêm thành công");

    }

    @Override
    public void editInfo(String id) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getEmployeeID(), id)) {
                employee.inputData(sc);
            }
        }
    }

    @Override
    public Employee findById(String id) {
        for (Employee employee1 : employees) {
            if (Objects.equals(employee1.getEmployeeID(), id)) {
                return employee1;
            }
        }
        return null;
    }

    public void deleteEmployee() {
        System.out.println("nhập id nhân viên cần xóa");
        String id = sc.nextLine();
        employees.remove(findById(id));
    }

    public double avgEployee() {
        DepartmentManagerment departmentManagerment = new DepartmentManagerment();
        double totalsMember = 0;
        List<Department> list = departmentManagerment.getListDepartment();
        for (Department department : list) {
            totalsMember += department.getTotalMembers();
        }
        return totalsMember / list.size();
    }

    public void findDepartmentOfTop() {
        DepartmentManagerment departmentManagerment = new DepartmentManagerment();
        List<Department> list = departmentManagerment.getListDepartment();
        List<Department>list1=list.stream().sorted(Comparator.comparing(Department::getTotalMembers)).limit(5).toList();
//        list.stream().sorted((o1, o2) -> o2.getTotalMembers() - o1.getTotalMembers())
//                .limit(5).collect(Collectors.toList());
        for (Department department : list1) {
            System.out.println(department);
        }
    }

    public Employee findMostSalaryEmployee() {
        employees.sort((o1, o2) -> o2.getSalary().compareTo(o1.getSalary()));
        return employees.getFirst();
    }

    //    "8.Tìm ra người quản lý nhiều  nhân viên nhất\n" +
    public  Employee findMostManagedEmployee() {
        Map<Employee, Long> managerCount = new HashMap<>();

        // Đếm số lượng nhân viên mà mỗi người quản lý quản lý
        for (Employee employee : employees) {
            if (employee.getManager() != null) {
                managerCount.put(employee.getManager(), managerCount.getOrDefault(employee.getManager(), 0L) + 1);
            }
        }

        // Tìm ra người quản lý có số lượng nhân viên quản lý nhiều nhất
        Employee mostManagedEmployee = null;
        long maxManagedCount = 0;

        for (Map.Entry<Employee, Long> entry : managerCount.entrySet()) {
            if (entry.getValue() > maxManagedCount) {
                mostManagedEmployee = entry.getKey();
                maxManagedCount = entry.getValue();
            }
        }

        return mostManagedEmployee;
    }

//            "9.Tìm ra 5 nhân viên có tuổi cao nhất công ty\n" +
    public void mostAgeofEmployee() {
        List<Employee>employees1= employees.stream().sorted((o1, o2) -> o2.getBirthday().compareTo(o1.getBirthday()))
                .limit(5).toList();
        for (Employee department : employees1) {
            System.out.println(department);
        }
    }


}
