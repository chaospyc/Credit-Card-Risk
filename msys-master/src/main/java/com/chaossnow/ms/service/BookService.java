package com.chaossnow.ms.service;

import com.chaossnow.ms.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();

    Book bookByTitle(String title);
}
