package com.spring.jpa.JPA;

import com.spring.jpa.JPA.Entity.Book;
import com.spring.jpa.JPA.Entity.Page;
import com.spring.jpa.JPA.Repository.BookRepository;
import com.spring.jpa.JPA.Repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class JpaMappingsApplication {
    //one-to-many
    @Autowired
    BookRepository bRepo;
    @Autowired
    PageRepository pRepo;
	public static void main(String[] args) {
		SpringApplication.run(JpaMappingsApplication.class, args);
	}


    @Bean
    public CommandLineRunner mappingDemo(BookRepository bRepo, PageRepository pRepo) {
        return (args) -> {


            Book b = new Book("Spring Boot", "roh Johnson", "3435");

            Page p1 = new Page(1, "Introduction", "IOC Dependency", b);
            Page p2 = new Page(165, "Java 8 Contents", "Java Features", b);
            Page p3 = new Page(96, "Concurrency", "Virtual Threads ", b);
            Page p4 = new Page(345, "OOPS Concepts", "Core Java", b);


            b.getPages().add(p1);
            b.getPages().add(p2);
            b.getPages().add(p3);
            b.getPages().add(p4);

            bRepo.save(b);


            Book bb = new Book("Harry Potter and the Chamber of Secrets  ", "J.K Rowling", "7756");
            Page pp1 = new Page(45, "The Whomping Willow", "Adventures with trhe willow Tree", bb);
            Page pp2 = new Page(178, "The Polyjuice Potion", "Things that happen at Portions Lab", bb);
            Page pp3 = new Page(296, "The Chamber of Secrets", "Tom Riddles Beginning ", bb);
            Page pp4 = new Page(325, "Dobby's Reward", "Dobby is Freee!", bb);


            bb.getPages().add(pp1);
            bb.getPages().add(pp2);
            bb.getPages().add(pp3);
            bb.getPages().add(pp4);

            bRepo.save(bb);



            Set<Page> pages = b.getPages();
            for(Page page:pages)
            System.out.println(page.getChapter()+","+page.getNumber()+","+page.getContent());

            Optional<Page> tempPage= pRepo.findById(1l);
            System.out.println(tempPage.get());


            Set<Page> pages2 = bb.getPages();
            for(Page page:pages2)
                System.out.println(page.getChapter()+"---"+page.getNumber()+"--"+page.getContent());

            Optional<Page> temp2Page= pRepo.findById(1l);
            System.out.println(temp2Page.get());





        };
    }
}


