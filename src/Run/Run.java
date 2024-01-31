package Run;

import controler.DepertmentControler;
import controler.EmployeeControler;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("=======MENU======");
            System.out.println("1.quản lí phòng ban\n" +
                    "2.quản lí nhân viên\n" +
                    "3.thoát chương trình.");
            int choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    DepertmentControler.displayMenuDepertment();
                    break;
                case 2:
                    EmployeeControler.displayMenuEmployee();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.err.println("nhập sai lựa chọn");
            }
        }
    }
}
