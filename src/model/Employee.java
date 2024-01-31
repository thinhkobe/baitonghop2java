package model;

import service.DepartmentManagerment;
import service.EmployeeManagerment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Employee {
    String employeeID, getEmployeeName;
    LocalDate birthday;
    boolean sex;
    BigDecimal salary;
    Employee manager;
    Department department;

    public Employee() {
    }

    public Employee(String employeeID, String getEmployeeName, LocalDate birthday, boolean sex, BigDecimal salary, Employee manager, Department department) {
        this.employeeID = employeeID;
        this.getEmployeeName = getEmployeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getGetEmployeeName() {
        return getEmployeeName;
    }

    public void setGetEmployeeName(String getEmployeeName) {
        this.getEmployeeName = getEmployeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeName='" + getEmployeeName + '\'' +
                ", birthday=" + birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", sex=" + (sex ? "Nam" : "Nữ") +
                ", salary=" + salary +
                ", manager=" + (manager != null ? this.manager.getEmployeeName : "Không có quản lí") +
                ", department=" + (department != null ? department.getDepartmentName() : "Không thuộc phòng ban nào") +
                '}';
//        return "Tên nhân viên : %s | Id nhân viên : %s | Ngày sinh :%s | Giới tính : %s |Lương : %s | Người quản lí :%s |" +
//                "Phòng ban :%s \n",getEmployeeName,
    }
    public  void displayData(){
        System.out.printf("Tên nhân viên : %s | Id nhân viên : %s | Ngày sinh :%s | Giới tính : %s |Lương : %s | Người quản lí :%s |\" +\n" +
                "Phòng ban :%s \n",getEmployeeName,employeeID,birthday,(sex?"nam":"nữ"),salary,manager != null ? this.manager.getEmployeeName : "Không có quản lí");
    }


    public void inputData(Scanner sc){
       if (employeeID==null){
           System.out.println("nhập ID cho nhân viên");
           String id=sc.nextLine();
           // Kiểm tra điều kiện về mã nhân viên
           if (!id.startsWith("E") || id.length() != 5) {
               throw new IllegalArgumentException("Mã nhân viên không hợp lệ");
           }
          this.employeeID=id;
       }

        System.out.println("nhập tên nhân viên");
       this.getEmployeeName=sc.nextLine();

        System.out.print("Ngày sinh (định dạng dd/MM/yyyy): ");
        String birthdayStr = sc.nextLine();
        this.birthday= LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Giới tính (true - Nam, false - Nữ): ");
        this.sex  = sc.nextBoolean();
        sc.nextLine();  // Đọc bỏ dòng new line

        System.out.print("Lương cơ bản: ");
        this.salary = sc.nextBigDecimal();
        sc.nextLine();  // Đọc bỏ dòng new line

        //thêm thông tin người quản lí
        EmployeeManagerment employeeManagerment=new EmployeeManagerment();
        employeeManagerment.display();
        System.out.println("nhập ID người quản lí");
        String id=sc.nextLine();
        this.manager= employeeManagerment.findById(id);

        //thêm vào phòng ban
        DepartmentManagerment departmentManagerment=new DepartmentManagerment();
        departmentManagerment.display();
        System.out.println("nhập id phòng ban");
        String id1=sc.nextLine();
        this.department=departmentManagerment.findById(id1);
    }
}
