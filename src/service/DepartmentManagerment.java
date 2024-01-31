package service;

import model.Department;
import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentManagerment implements Management<Department,String>{
    static List<Department> departments=new ArrayList<>();
    Scanner sc= new Scanner(System.in);

    public List<Department>getListDepartment(){
        return departments;
    }
    @Override
    public void display() {
        if (departments.isEmpty()){
            System.out.println("danh sách rỗng");
        }else{
        for (Department  department: departments) {
            System.out.println(department);
        }
        }
    }

    @Override
    public void add(Department element) {
        departments.add(element);
    }

    @Override
    public void editInfo(String id) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(id)){
                department.inputData(sc);
            }
        }
        System.out.println("sửa thành công");
    }

    @Override
    public Department findById(String id) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(id)){
                return department;
            }
        }
        return null;
    }
    public void showEmployeeofDeparment(String id){
        EmployeeManagerment employeeManagerment=new EmployeeManagerment();
        List<Employee> list=employeeManagerment.getInfoEployees();

        for (Employee employee : list) {
            if(employee.getDepartment()==findById(id)){
                System.out.println(employee);
            }
        }

    }
    public void delete(){
        System.out.println("nhập id cần xóa");
        String id=sc.nextLine();
        if (findById(id).getTotalMembers()==0){
        departments.remove(findById(id));
        }
        else {
            System.err.println("còn nhân viên trong phòng");
        }

    }
}
