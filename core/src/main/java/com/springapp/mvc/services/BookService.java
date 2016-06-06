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
    public BookInfo getBookByName(String name) {
        return bookRepository.getBookInfoByName(name);
    }

    @Transactional
    public String generateBook() {
        char[] book = bookRepository.findTop1ByOrderByIdDesc().getName().toCharArray();
        char symb;
        for (int i = book.length-1; i >-1 ; i--) {
             symb = book[i];
            if((int) symb == (int) '9') {
                book[i] = 'A';
                break;
            }
            if (((int) symb < (int) 'Z') && ((int) symb >= 'A') || ((int) symb < (int) '9') && ((int) symb >= '0')) {
                book[i] = (char) ((int) symb + 1);
                break;
            }
        }
        return String.valueOf(book);
    }
}
