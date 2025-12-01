package com.spring.jpa.JPA.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String author;
    private String title;

    @Column(unique = true)
    private String isbn;


    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //
    private Set<Page> pages =new HashSet<>(); //// pages is many-to-one relationship/mapping

    public Book() {
    }

    public Book(long id, String author, String title, String isbn, Set<Page> pages) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.pages = pages;
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }


//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", author='" + author + '\'' +
//                ", title='" + title + '\'' +
//                ", isbn='" + isbn + '\'' +
//                ", pages=" + pages +
//                '}';
//    }
}
