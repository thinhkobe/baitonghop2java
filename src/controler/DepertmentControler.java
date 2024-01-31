package controler;

import model.Department;
import service.DepartmentManagerment;

import java.util.Scanner;

public class DepertmentControler {
   static     DepartmentManagerment departmentManagerment=new DepartmentManagerment();
   static Department department=new Department();
   static     Scanner sc=new Scanner(System.in);
   public static void displayMenuDepertment(){
       while (true){
           System.out.println("=======Quản trị phòng ban======");
           System.out.println(
                           "1.Hiển thị danh sách phòng ban\n" +
                           "2.Thêm mới phòng ban\n" +
                           "3.Chỉnh sửa tên phòng ban\n" +
                           "4.Hiển thị danh sách nhân viên của phòng ban theo mã phòng\n" +
                           "5.Xóa phòng ban (chỉ xóa khi ko có nhân viên nào)\n" +
                                   "6.Thoát"
                   );
           int choice= Integer.parseInt(sc.nextLine());
           switch (choice){
               case 1:
                   departmentManagerment.display();
                   break;
               case 2:
                   addDepartment();
                   break;
               case 3:
                   departmentManagerment.display();
                   System.out.println("nhập id phòng ");
                   String id=sc.nextLine();
                  departmentManagerment.editInfo(id);
                   break;
               case 4:
                   departmentManagerment.display();
                   System.out.println("nhập id phòng ");
                   String idKey=sc.nextLine();
                   departmentManagerment.showEmployeeofDeparment(idKey);
                   break;
               case 5:
                   departmentManagerment.delete();
               case 6:
                  return;

               default:
                   System.err.println("nhập sai lựa chọn");
           }
       }
   }
   public static void addDepartment(){
       Department department1=new Department();
       department1.inputData(sc);
       departmentManagerment.add(department1);
   }

}
