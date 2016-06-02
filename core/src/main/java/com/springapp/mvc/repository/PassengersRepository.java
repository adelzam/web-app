package com.springapp.mvc.repository;

import com.springapp.mvc.common.PassengersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 08.05.16.
 */
public interface PassengersRepository extends JpaRepository<PassengersInfo, Long> {
    List<PassengersInfo> getPassengersInfoByLastName(String lastName);
}
