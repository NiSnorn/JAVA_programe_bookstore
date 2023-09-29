package ThirdWithMySQL.Systems;

import ThirdWithMySQL.Editor.Basic;
import ThirdWithMySQL.Editor.DQL;

import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.浏览书架");
            System.out.println("2.查询图书");
            System.out.println("3.离开书城");
            System.out.println("请输入您的选择：");
            int choice2 = sc.nextInt();
            if (choice2==1){
                DQL dql = new DQL();
                dql.print();
            }
            if (choice2==2){
                System.out.println("请输入查询书籍的编号：");
                Basic b = DQL.FindOne(sc.nextInt());
                if (b ==null){
                    System.out.println("查无此书");
                }else {
                    System.out.println(
                            "书籍编码："+b.getId()+"  书籍名称："+b.getBookname()+"  作者："+b.getAuthorname()+"  剩余数量："+b.getNum()+"  建议售价："+b.getPri()+"元");
                }
            }
            if (choice2 == 3) {
                break;
            }

        }

    }
}
