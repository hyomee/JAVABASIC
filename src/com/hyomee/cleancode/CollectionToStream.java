package com.hyomee.cleancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Collection 객체의 처리는 Stream을 사용 하는 읽기 쉬운 코드를 작성 할 수 잇다.
 */
public class CollectionToStream {

    public  static void main(String[] str) {
        Books books = new Books();
        System.out.println(" IT 분류 책 갯수 " + books.countCategory("IT"));

        StreamBooks streamBooks = new StreamBooks();
        System.out.println(" IT 분류 책 갯수 " + streamBooks.countCategory("IT"));
    }
}


class Books {
    List<Book> books = Arrays.asList(
            new Book("01", "Spring", "IT"),
            new Book("02", "Spring", "문학"),
            new Book("03", "JAVA", "IT")
    );

    public long countCategory(String category) {
        List<Book> bookList = new ArrayList<>();

        for (Book book: books) {
            if (book.getCategory().contains(category)) {
                bookList.add(book);
            }
        }

        return bookList.size();
    }
}

class StreamBooks {
    List<Book> books = Arrays.asList(
            new Book("01", "Spring", "IT"),
            new Book("02", "Spring", "문학"),
            new Book("03", "JAVA", "IT")
    );

    public long countCategory(String category) {

        return books.stream().filter((book -> book.getCategory().contains(category)))
                             .map(book -> book.getBookId())
                             .distinct()
                             .count();
    }
}

class Book {
    private String bookId;
    private String bookName;
    private String category;

    Book(String bookId, String bookName, String category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.category = category;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setgetCategory(String category) {
        this.category = category;
    }

}
