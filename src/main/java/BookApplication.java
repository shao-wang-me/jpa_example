import entities.Author;
import entities.Book;
import entities.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class BookApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookApp");
        // Creating an EntityManager will trigger database login
        // and schema generation (because of the properties passed above)
        EntityManager em = emf.createEntityManager();

        Book book = new Book();
        book.setName("Book");
        Author author = new Author();
        author.setName("Author");
        Publisher publisher = new Publisher();
        publisher.setName("Publisher");

        Map<String, Author> authors = new HashMap<>();
        authors.put("Author", author);
        book.setAuthors(authors);

        book.setPublisher(publisher);

        Map<String, Book> books = new HashMap<>();
        books.put("Book", book);
        author.setBooks(books);

        publisher.setBooks(books);

        em.persist(book);

        if (em.contains(book)) {
            System.out.println("Persisted successfully.");

            Book newBook = em.find(Book.class, book.getId());
            Author newAuthor = book.getAuthors().get("Author");
            Publisher newPublisher = book.getPublisher();

            System.out.println(book);
            System.out.println(newBook);

            System.out.println(author);
            System.out.println(newAuthor);

            System.out.println(publisher);
            System.out.println(newPublisher);

            System.out.println(newBook.getName());
            System.out.println(newBook.getAuthors().get("Author").getName());
            System.out.println(newBook.getPublisher().getName());
        }

        em.close();
        emf.close();
    }
}
