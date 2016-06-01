package com.springapp.mvc.services;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public BookInfo getBookByName(String name){
        return bookRepository.getBookInfoByName(name);
    }
}
