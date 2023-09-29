package FirstWithArraylist.Function;



public class AddBooks extends Book {
    public void Action(){

        System.out.println("What's the number of this book ?");
        this.num = sc.nextInt();
        System.out.println("What's the name of this book ?");
        this. nameOfBooks = sc.next();
        System.out.println("What's the name of the author ?");
        this.nameOfAuthor = sc.next();

        Book b = new Book();
        b.setNum(num);
        b.setNameOfBooks(nameOfBooks);
        b.setNameOfAuthor(nameOfAuthor);

        list.add(b);
        System.out.println("SUCCEED!");
    }












}
