package com.springapp.mvc.services;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adelzamalutdinov on 08.05.16.
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookInfo getBookByName(String name){
        return bookRepository.getBookInfoByName(name);
    }
}
