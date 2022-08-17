package com.chaossnow.ms.dao;

import com.chaossnow.ms.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> listBooks();

    Book bookByTitle(String title);
}
