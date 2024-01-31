package controler;

import model.Employee;
import service.EmployeeManagerment;

import java.util.Scanner;

public class EmployeeControler {
    static EmployeeManagerment employeeManagerment=new EmployeeManagerment ();
    public static void displayMenuEmployee(){
        Scanner sc=new Scanner(System.in);
        employeeManagerment.addEmployeesToList();
        while (true){
            System.out.println("Quản trị nhân viên" );
            System.out.println(
                    "1.HIển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)\n" +
                    "2.Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)\n" +
                    "3.Thêm mới nhân viên\n" +
                    "4.Chỉnh sửa thông tin nhân viên\n" +
                    "5.Xóa nhân viên \n" +
                    "6.Thống kê số lượng nhân viên trung bình của mỗi phòng \n" +
                    "7.Tìm ra 5 phòng có số lượng nhân viên đông nhất\n" +
                    "8.Tìm ra người quản lý nhiều  nhân viên nhất\n" +
                    "9.Tìm ra 5 nhân viên có tuổi cao nhất công ty\n" +
                    "10Tìm ra 5 nhân viên hưởng lương cao nhất\n" +
                            "11.thoát");
            int choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    employeeManagerment.display();
                    break;
                case 2:
                    employeeManagerment.displayAll();
                    break;
                case 3:
                    Employee newEmployee =new Employee();
                    newEmployee.inputData(sc);

                    employeeManagerment.add(newEmployee);
                    break;
                case 4:
                    employeeManagerment.display();
                    System.out.println("nhập id cần sửa");
                    String editId=sc.nextLine();
                    employeeManagerment.editInfo(editId);
                    break;
                case 5:
                    employeeManagerment.deleteEmployee();
                    break;
                case 6:
                    System.out.println("số nhân viên trung bình mỗi phòng là :"+ employeeManagerment.avgEployee());
                    break;
                case 7:
                    employeeManagerment.findDepartmentOfTop();
                    break;
                case 8:
                    System.out.println( employeeManagerment.findMostManagedEmployee());

                    break;
                case 9:
                    employeeManagerment.mostAgeofEmployee();
                    break;
                case 10:
                    System.out.println( employeeManagerment.findMostSalaryEmployee());

                    break;


                case 11:
                    return;
                default:
                    System.err.println("nhập sai lựa chọn");
            }
        }

    }
}
