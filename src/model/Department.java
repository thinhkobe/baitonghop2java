package model;

import service.DepartmentManagerment;
import service.EmployeeManagerment;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Department {
    String departmentId;
    String departmentName;
    int totalMembers=0;


    public Department() {
    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", totalMembers=" + totalMembers +
                '}';
    }

    public  void inputData(Scanner sc){
        if (departmentId==null){
            System.out.println("nhập mã phòng ban(bắt đầu bằng kí tự D và có" +
                    "đúng 4 kí tự.\n)");
            String id=sc.nextLine();
            // Kiểm tra điều kiện về mã phòng ban
            if (!id.startsWith("D") || id.length() != 4) {
                throw new IllegalArgumentException("Mã phòng ban không hợp lệ");
            }
            else {
                this.departmentId=id;
            }
        }

        System.out.println("nhập tên phòng");
        this.departmentName= sc.nextLine();


    }
}
