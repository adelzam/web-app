package com.springapp.mvc.services;

import com.springapp.mvc.common.PlaneInfo;
import com.springapp.mvc.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaneService {

    @Autowired
    private PlaneRepository repository;

    @Transactional
    public PlaneInfo getPlane(Long id) {
        return repository.findOne(id);
    }

    public PlaneInfo getPlaneByName(String plane) {
        return repository.getPlaneByName(plane);
    }

    public List<PlaneInfo> getAll() {
        return repository.findAll();
    }
}
