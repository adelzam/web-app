package com.springapp.mvc.repository;

import com.springapp.mvc.common.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adelzamalutdinov on 08.05.16.
 */
public interface BookRepository extends JpaRepository<BookInfo, Long> {
     BookInfo getBookInfoByName(String name);
}
