package com.spring.jpa.JPA.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pages")
public class Page implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @ManyToOne(fetch =FetchType.EAGER,optional = false)
            @JoinColumn(name = "book_id",nullable = false)
            private Book book;
    private String chapter;

    private String content;
    private int number;


    public Page() {
    }

    //without book constructor

    public Page(long id, String chapter, String content, int number) {
        this.id = id;
        this.chapter = chapter;
        this.content = content;
        this.number = number;
    }

    public Page(long id, Book book, String chapter, String content, int number) {
        this.id = id;
        this.book = book;
        this.chapter = chapter;
        this.content = content;
        this.number = number;
    }


    public Page(int number , String chapter, String content, Book book) {
        this.number = number;
        this.chapter = chapter;
        this.content = content;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


//    @Override
//    public String toString() {
//        return "Page{" +
//                "id=" + id +
//                ", book=" + book +
//                ", chapter='" + chapter + '\'' +
//                ", content='" + content + '\'' +
//                ", number=" + number +
//                '}';
//    }
}
