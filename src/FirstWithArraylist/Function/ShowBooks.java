package FirstWithArraylist.Function;

public class ShowBooks extends Book {
    Book b = new Book();
    public void Action() {
        for (int i = 0; i <= list.size() - 1; i++) {
             b= (Book) list.get(i);
            System.out.println(b.getNum() + "---" + b.getNameOfBooks() + "---" + b.getNameOfAuthor());
        }
    }

}
