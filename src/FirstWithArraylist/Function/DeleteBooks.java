package FirstWithArraylist.Function;

public class DeleteBooks extends Book {


    public void Action()  {

        System.out.println("What's the number of the book which you want to delete ?");
        this.num = sc.nextInt();

        Book b = new Book();
        b.setNum(num);

        list.remove(b);
        System.out.println("SUCCEED!");



    }

}
