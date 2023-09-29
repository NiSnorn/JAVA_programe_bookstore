package ThirdWithMySQL.Systems;

import ThirdWithMySQL.Editor.DML;
import ThirdWithMySQL.Editor.DQL;

import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {


        while (true) {
            System.out.println("1.浏览书架");
            System.out.println("2.添加图书");
            System.out.println("3.删除图书");
            System.out.println("4.关闭书城");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                DQL dql = new DQL();
                dql.print();
            }
            if (choice == 2) {
                new DML().Add();
            }
            if (choice == 3) {
                new DML().Delete();

            }
            if (choice == 4) {
                new DML().Commit();
                break;
            }
        }
    }


}
