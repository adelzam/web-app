package com.springapp.mvc.services;

import com.springapp.mvc.common.BookInfo;
import com.springapp.mvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public BookInfo getBookByName(String name) {
        return bookRepository.getBookInfoByName(name);
    }

    @Transactional
    public List<BookInfo> getBookByLogin(String login) {
        return bookRepository.getBookInfoByLogin(login);
    }

    @Transactional
    public BookInfo saveBook(BookInfo bookInfo) {
        return bookRepository.save(bookInfo);
    }

    @Transactional
    public String generateBook() {
        char[] book;
        if (bookRepository.findTop1ByOrderByIdDesc() != null) {
            book = bookRepository.findTop1ByOrderByIdDesc().getName().toCharArray();
        } else {
            book = "A12BC".toCharArray();
        }
        char symb;
        for (int i = book.length - 1; i > -1; i--) {
            symb = book[i];
            if ((int) symb == (int) '9') {
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
