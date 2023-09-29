package FirstWithArraylist.Bookstore;





import FirstWithArraylist.Function.AddBooks;
import FirstWithArraylist.Function.DeleteBooks;
import FirstWithArraylist.Function.QuitBookstore;
import FirstWithArraylist.Function.ShowBooks;

import java.util.Scanner;


public class Structure {
    public static void main(String[] args)  {

       while (true){
           System.out.println("————————————————WELCOME TO BOOKSTORE————————————————");
           System.out.println("1.SHOW BOOKS");
           System.out.println("2.ADD BOOKS");
           System.out.println("3.DELETE BOOKS");
           System.out.println("4.QUIT BOOKSTORE");
           System.out.println("请录入你想要执行的功能序号：");
           Scanner sc = new Scanner(System.in);



           QuitBookstore quit = new QuitBookstore();
           AddBooks add =new AddBooks();
           DeleteBooks del = new DeleteBooks();
           ShowBooks sb = new ShowBooks();
           int choice = sc.nextInt();

           if (choice==1){
               sb.Action();

           }
           if (choice==2){
               add.Action();

           }
           if (choice == 3) {
               del.Action();

           }
           if (choice==4){
               quit.print();
               break;
           }
       }
    }

}
