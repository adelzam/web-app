package com.springapp.mvc.repository;

import com.springapp.mvc.common.FlightClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 02.06.16.
 */
public interface FlightClassRepository extends JpaRepository<FlightClassInfo, Long> {

}
