package com.springapp.mvc.repository;

import com.springapp.mvc.common.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<BookInfo, Long> {
     BookInfo getBookInfoByName(String name);

     List<BookInfo> getBookInfoByLogin(String login);

     BookInfo findTop1ByOrderByIdDesc();
}
