package com.springapp.mvc.services;

import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.repository.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengersService {

    @Autowired
    private PassengersRepository passengersRepository;

    public List<PassengersInfo> getPassengersByLastName(String lastName){
        return passengersRepository.getPassengersInfoByLastName(lastName);
    }

}
