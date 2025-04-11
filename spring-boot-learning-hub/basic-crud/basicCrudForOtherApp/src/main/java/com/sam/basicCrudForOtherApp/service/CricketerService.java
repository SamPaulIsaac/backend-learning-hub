package com.sam.basicCrudForOtherApp.service;

import com.sam.basicCrudForOtherApp.entity.Cricketer;
import com.sam.basicCrudForOtherApp.repository.CricketerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CricketerService {

    @Autowired
    private CricketerRepository cricketerRepository;

    public Cricketer getCricketerById(Long id) {
        System.out.println("Actual CALL - getCricketerById");
        try {
            Thread.sleep(5000);  // 5-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cricketerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cricketer not found"));
    }

    public Cricketer saveCricketer(Cricketer cricketer) {
        return cricketerRepository.save(cricketer);
    }

    public void deleteCricketer(Long id) {
        System.out.println("Actual CALL - deleteCricketer");
        cricketerRepository.deleteById(id);
    }

    public List<Cricketer> getAllCricketers() {
        System.out.println("Actual CALL - getAllCricketers");
        return cricketerRepository.findAll();
    }
}

