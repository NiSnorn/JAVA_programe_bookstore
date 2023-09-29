package FirstWithArraylist.Function;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Book {

    public static ArrayList list = new ArrayList();
    int num;
    String nameOfBooks;
    String nameOfAuthor;
    Scanner sc = new Scanner(System.in);


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNameOfBooks() {
        return nameOfBooks;
    }

    public void setNameOfBooks(String nameOfBooks) {
        this.nameOfBooks = nameOfBooks;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }





}
