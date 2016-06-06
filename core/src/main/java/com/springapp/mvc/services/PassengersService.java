package com.springapp.mvc.services;

import com.springapp.mvc.common.PassengersInfo;
import com.springapp.mvc.repository.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengersService {

    @Autowired
    private PassengersRepository passengersRepository;

    @Transactional
    public List<PassengersInfo> getPassengersByLastName(String lastName){
        return passengersRepository.getPassengersInfoByLastName(lastName);
    }
    @Transactional
    public List<PassengersInfo> getPassengers(){
        return passengersRepository.findAll();
    }

    @Transactional
    public PassengersInfo getPassenger(Long id){
        return passengersRepository.findOne(id);
    }

    @Transactional
    public void deletePassengers(Long id) {
        passengersRepository.delete(id);
    }

    @Transactional
    public void updatePassengers(PassengersInfo passengersInfo) {
        passengersRepository.save(passengersInfo);
    }
}
