package com.springapp.mvc.repository;

import com.springapp.mvc.common.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookInfo, Long> {
     BookInfo getBookInfoByName(String name);

     BookInfo findTop1ByOrderByIdDesc();
}
