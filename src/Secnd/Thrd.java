package Secnd;

import java.util.ArrayList;
import java.util.List;

public class Thrd {
    public static void main(String[] args) {
        List<Author> authors = getAuthorsList();
        List<Book> books = getBookList(authors);
        List<Book> sortedBooks;

        // NOTE: This sorts by each category independently
        sortedBooks = books.stream().sorted((b1,b2) -> b1.getAuthor().getLastName().compareTo(b2.getAuthor().getLastName()))
                .sorted((b1,b2) ->b1.getAuthor().getFirstName().compareTo(b2.getAuthor().getFirstName()))
                .sorted((b1,b2) -> b1.getTitle().compareTo(b2.getTitle()))
                .toList();
        System.out.println(books);
        System.out.println(sortedBooks);
        System.out.println(books.stream().allMatch(book -> book.getAuthor().getFirstName().startsWith("M")));
    }

    private static List<Author> getAuthorsList(){
        List<Author> authors = new ArrayList<>();
        authors.add(new Author().setFirstName("Wojtek").setLastName("Szumlewicz"));
        authors.add(new Author().setFirstName("Adam").setLastName("Mickiewicz"));
        authors.add(new Author().setFirstName("Henryk").setLastName("Sienkiewicz"));
        return authors;
    }

    private static List<Book> getBookList(List<Author> authors){
        List<Book> books = new ArrayList<>();
        books.add(new Book().setTitle("Krzyżacy").setAuthor(authors.get(0)));
        books.add(new Book().setTitle("Wkłady").setAuthor(authors.get(1)));
        books.add(new Book().setTitle("Kamienie").setAuthor(authors.get(2)));
        books.add(new Book().setTitle("Patyk").setAuthor(authors.get(0)));
        books.add(new Book().setTitle("Bema").setAuthor(authors.get(2)));
        return books;
    }
}
