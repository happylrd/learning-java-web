package io.happylrd.demo1.service;

import io.happylrd.demo1.model.Book;
import io.happylrd.demo1.model.Category;

import java.util.List;

public interface BookService {

    List<Category> getAllCategories();

    Category getCategory(int id);

    List<Book> getAllBooks();

    Book get(long id);

    Book save(Book book);

    Book update(Book book);

    long getNextId();
}
