package com.parentlyx.service;

import com.parentlyx.model.Parent;
import com.parentlyx.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }
}