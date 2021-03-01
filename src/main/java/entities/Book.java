package entities;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Book {
    private Long id;
    private Publisher publisher;
    private Map<String, Author> authors;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Map<String, Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Map<String, Author> authors) {
        this.authors = authors;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
