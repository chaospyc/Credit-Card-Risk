package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.BookDao;
import com.chaossnow.ms.pojo.Book;
import com.chaossnow.ms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chaos
 * @ClassName LibraryServiceImpl
 * @date 2022年08月07日 21:51
 * @Version 1.0
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> listBooks() {
        List<Book> bookList= bookDao.listBooks();
        return bookList;
    }

    @Override
    public Book bookByTitle(String title) {
        Book book = bookDao.bookByTitle(title);
        return book;
    }
}
