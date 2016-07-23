/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Book {

    private String author;
    private String title;
    int pageNum;
    String coverColour;
    String titleFont;

    public Book(String author, String title, int pageNum, String coverColour, String titleFont) {
        this.author = author;
        this.title = title;
        this.pageNum = pageNum;
        this.coverColour = coverColour;
        this.titleFont = titleFont;
    }


    public static void main (String[] args) throws java.lang.Exception
    {Book blackBook = new Book("Matthews", "Mockingbird", 359, "black", "Monotype Corsiva");
        blackBook.pageNum = 347;
        blackBook.titleFont = "Lucinda Handwriting";
        Book blueBook = new Book("Kneale", "English Passengers", 500, "blue", "Algerian");
        blueBook.coverColour = "navy blue";
        blueBook.pageNum = 570;
        blueBook.titleFont = "Times New Roman";

    }
}