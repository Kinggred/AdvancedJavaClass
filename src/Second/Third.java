package Second;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Third {
    public static void main(String[] args) {
        List<Author> authors = getAuthorsList();
        List<Book> books = getBookList(authors);
        List<Book> sortedBooks;

        // A
        Comparator<Book> compareBySurname = (b1, b2) -> b1.getAuthor().getLastName().compareTo(b2.getAuthor().getLastName());
        Comparator<Book> compareByFirstName = (b1,b2) ->b1.getAuthor().getFirstName().compareTo(b2.getAuthor().getFirstName());
        Comparator<Book> compareByTitle = (b1,b2) -> b1.getTitle().compareTo(b2.getTitle());

        Comparator<Book> compareCollected = compareBySurname.thenComparing(compareByFirstName).thenComparing(compareByTitle);

        sortedBooks = books.stream().sorted(compareCollected).toList();
        System.out.println(books);
        System.out.println(sortedBooks);

        // B, C
        System.out.println(books.stream().sorted(compareCollected).allMatch(book -> book.getAuthor().getFirstName().startsWith("M")));

        // D
        List<Author> authorList = new ArrayList<>();
        books.forEach(book -> {
            Author author = book.getAuthor();
            if(!authorList.contains(author)) authorList.add(author);
        });
        System.out.println(authorList);
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
