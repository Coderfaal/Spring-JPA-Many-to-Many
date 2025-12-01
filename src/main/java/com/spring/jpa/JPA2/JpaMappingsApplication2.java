package com.spring.jpa.JPA2;


import com.spring.jpa.JPA2.Entity.Post;
import com.spring.jpa.JPA2.Entity.Tag;
import com.spring.jpa.JPA2.Repository.PostRepository;
import com.spring.jpa.JPA2.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;


@SpringBootApplication
public class JpaMappingsApplication2 implements CommandLineRunner {

	public static void main(String[] args)
    {
		SpringApplication.run(JpaMappingsApplication2.class, args);
	}

    @Autowired
    PostRepository pRepo;
    @Autowired
    TagRepository tRepo;
    @Override
    public void run(String... args) throws Exception {

        Post p = new Post("This is Manay to Many Relationship using SpringBoot JPA","Learn how to map with JPA",
                "Code Example with Java MAven");


        Tag t1= new Tag("SpringBoot");
        Tag t2 = new Tag("JPA- Hibernate");
        Tag t3= new Tag("Annotation-Configuration");

        p.getTags().add(t1);
        p.getTags().add(t2);
        p.getTags().add(t3);

        pRepo.save(p);



        Optional<Post> optional = pRepo.findById(1L);
        Post postRef = optional.isPresent()?
                optional.get():
                             optional.orElseThrow(()-> new NoSuchElementException("id not found")); //if object is null it will throw exception and it wont go further

        System.out.println(postRef);

        System.out.println(optional.get().getDescription());
        System.out.println(optional.get().getTitle());
        System.out.println(optional.get().getContent());

        Set<Tag> tags= postRef.getTags();
        for(Tag t :tags){
            System.out.println("Tag is : "+ t.getName());
        }



    }




}


