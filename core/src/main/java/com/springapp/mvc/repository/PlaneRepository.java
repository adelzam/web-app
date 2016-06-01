package com.springapp.mvc.repository;


import com.springapp.mvc.common.PlaneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<PlaneInfo, Long> {

}
