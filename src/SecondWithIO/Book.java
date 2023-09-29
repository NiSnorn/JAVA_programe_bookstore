package SecondWithIO;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Book implements Serializable {

    private int num;
    private String nameOfBooks;
    private String nameOfAuthor;


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
