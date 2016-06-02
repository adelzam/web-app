package com.springapp.mvc.services;

import com.springapp.mvc.common.PlaneInfo;
import com.springapp.mvc.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository repository;

    @Transactional
    public PlaneInfo getPlane(Long id) {
        return repository.findOne(id);
    }
}
