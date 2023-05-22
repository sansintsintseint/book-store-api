package com.example.bookstoreapi;

import com.example.bookstoreapi.dao.CategoryDao;
import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.entity.Category;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class BookStoreApiApplication {
    @Autowired
    private CategoryDao categoryDao;
    @Transactional
    @Bean
    //@Profile("h2")
    public ApplicationRunner runner(){
        return args -> {
            Category c1=new Category();
            c1.setName("Historical");
            Category c2=new Category();
            c2.setName("Tragic");
            Category c3=new Category();
            c3.setName("Comedy");

            Book book1=new Book("World War 2",23.5, LocalDate.of(2021,3,11),
                    "Sun","https://source.unsplash.com/366x200/?nature,water","Thomas Hardey");
            Book book2=new Book("A pair of blue eyes",25.5, LocalDate.of(2020,3,10),
                    "Moon","https://source.unsplash.com/366x200/?nature,water","Ishiguro");
            Book book3=new Book("A Tale of two cities",30.5, LocalDate.of(2022,6,10),
                    "Sun","https://source.unsplash.com/366x200/?nature,water","Thomas William");
            Book book4=new Book("A history of human beings",33.5, LocalDate.of(2021,6,13),
                    "Moon","https://source.unsplash.com/366x200/?nature,water","Thomas Riches");


            c1.addBook(book1);
            c1.addBook(book2);
            c2.addBook(book3);
            c3.addBook(book4);

            categoryDao.save(c1);
            categoryDao.save(c2);
            categoryDao.save(c3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApiApplication.class, args);
    }

}
