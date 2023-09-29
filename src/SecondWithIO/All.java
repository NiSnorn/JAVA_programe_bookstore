package SecondWithIO;



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class All {
    public static void main(String[] args) throws Exception {
        Book b = new Book();
        File f = new File("C:\\Users\\Xi\\IdeaProjects\\MyBookstore\\src\\SecondWithIO\\Information.text");


        while (true) {
            System.out.println("————————————————WELCOME TO BOOKSTORE————————————————");
            System.out.println("1.展示书籍");
            System.out.println("2.添加书籍");
            System.out.println("3.删除书籍");
            System.out.println("4.退出书城");
            System.out.println("请录入你想要执行的功能序号：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice == 1) {
                if (f.exists() == true) {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                    ArrayList list = (ArrayList) ois.readObject();
                    list.add(b);
                    for (int i = 1; i <= list.size()-1; i++) {
                        b = (Book) list.get(i);
                        System.out.println(b.getNum() + "---" + b.getNameOfBooks() + "---" + b.getNameOfAuthor());
                    }
                } else {
                    System.out.println("当前书城为空，请添加书籍");
                }

            }
            if (choice == 2) {
                System.out.println("图书编号：");
                int num = sc.nextInt();
                System.out.println("书籍名称：");
                String nameOfBooks = sc.next();
                System.out.println("作者名称：");
                String nameOfAuthor = sc.next();

                b.setNum(num);
                b.setNameOfBooks(nameOfBooks);
                b.setNameOfAuthor(nameOfAuthor);


                if (f.exists() == true) {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                    ArrayList list = (ArrayList) ois.readObject();
                    list.add(b);
                    OUTPUT(f, list);
                } else {
                    ArrayList list = new ArrayList();
                    list.add(b);
                    OUTPUT(f, list);
                    System.out.println("SUCCEED!");
                }


            }
            if (choice == 3) {
                System.out.println("请输入删除的图书编号");
                int num =sc.nextInt();
                b.setNum(num);
                b.setNameOfAuthor(b.getNameOfAuthor());
                b.setNameOfBooks(b.getNameOfBooks());
                if (f.exists()==true) {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                    ArrayList list = (ArrayList) ois.readObject();
                    list.remove(b);
                    OUTPUT(f, list);
                    System.out.println("SUCCEED!");
                }else {
                    System.out.println("当前书城已空");
                }
            }
            if (choice == 4) {
                System.out.println("SEE YOU NEXT TIME!!!");
                break;
            }
        }
    }


    public static void OUTPUT(File f ,ArrayList list) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(list);
        oos.close();
    }
}
