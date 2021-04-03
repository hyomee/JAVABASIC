package com.hyomee.cleancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 복합한 조건은 Mathod 참조
 * 복잡한 기은은 Method 첨조
 */
public class ComplicatedComtion {
    public static void main(String[] args) {

        Executable exe = text -> Printer.printSomething(text);
        Executable exe2 = Printer::printSomething;
        exe.doSomething("do something");
        exe2.doSomething("do something");

        // Static Method 참조
        ReferencetoStaticMethod referencetoStaticMethod = new ReferencetoStaticMethod();
        referencetoStaticMethod.changeCapitaliz();

        //
        ComplicatedStreamBooks complicatedStreamBooks = new ComplicatedStreamBooks();
        System.out.println(" IT 분류 이면서 Spring 도서인 경우 책 갯수 " + complicatedStreamBooks.countCategory("IT"));
        System.out.println(" IT 분류 이면서 Spring 도서인 경우 책 갯수 " + complicatedStreamBooks.countCategoryByMethod("IT"));

        // 새로운 객체로 변환
        complicatedStreamBooks.getCategoryByMethod("IT")
                .stream()
                .forEach(complicatedBook -> complicatedBook.printString());
    }
}

/**
 * 람다 - Static 참조를 위한 Interface
 */
interface Executable {
    void doSomething(String text);
}

class Printer {
    static void printSomething(String text) {
        System.out.println(text);
    }
}



// Static Method 참조
class ReferencetoStaticMethod {
    List<ComplicatedBook> books = Arrays.asList(
            new ComplicatedBook("01", "Spring", "IT"),
            new ComplicatedBook("02", "Spring", "문학"),
            new ComplicatedBook("03", "JAVA", "IT")
    );

    // Static Method 참조
    public void changeCapitaliz() {
        books.stream().map(book -> StringUtils.toUpperCase(book.getBookName()))
                      .forEach(System.out::println);
    }
}

class StringUtils {
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}


class ComplicatedStreamBooks {
    List<ComplicatedBook> complicatedBooks = Arrays.asList(
            new ComplicatedBook("01", "Spring", "IT"),
            new ComplicatedBook("02", "Spring", "문학"),
            new ComplicatedBook("03", "JAVA", "IT")
    );

    // 복잡한 조건
    public long countCategory(String category) {
        return complicatedBooks.stream().filter((complicatedBook -> complicatedBook.getCategory().contains(category)
                                             && complicatedBook.getBookName().equals("Spring")))
                .map(book -> book.getBookId())
                .distinct()
                .count();
    }

    // 복잡한 조건 Method 참조
    public long countCategoryByMethod(String category) {
        return complicatedBooks.stream().filter( complicatedBook -> isContains(complicatedBook, category))
                .map(complicatedBook -> complicatedBook.getBookId())
                .distinct()
                .count();
    }

    // 복잡한 조건 Method 참조 비교 후 새로운 객체 리턴
    public List<ComplicatedBook> getCategoryByMethod(String category) {
        return complicatedBooks.stream().filter( complicatedBook -> isContains(complicatedBook, category))
                .map(ComplicatedBook::new)
                // .map(complicatedBook -> new ComplicatedBook(complicatedBook))
                .collect(Collectors.toList());
    }

    private boolean isContains(ComplicatedBook book, String targetCategory) {
        return book.getCategory().contains(targetCategory) && book.getBookName().equals("Spring");
    }


}

class ComplicatedBook {
    private String bookId;
    private String bookName;
    private String category;

    ComplicatedBook(String bookId, String bookName, String category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.category = category;
    }

    ComplicatedBook(ComplicatedBook complicatedBook) {
        this.bookId = complicatedBook.getBookId();
        this.bookName = complicatedBook.getBookName();
        this.category = complicatedBook.getCategory();
    }

    public void printString() {
        System.out.println(String.format(" 도서번호 :: %s, 도서명 :: %s, 분류 :: %s  ",  this.bookId , this.bookName , this.category));
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