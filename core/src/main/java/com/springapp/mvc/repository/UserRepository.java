package com.springapp.mvc.repository;

import com.springapp.mvc.common.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ann on 06.06.2016.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo getUserInfoByLogin(String login);
}
