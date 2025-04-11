package com.sam.redisCache.service;

import com.sam.redisCache.entity.Cricketer;
import com.sam.redisCache.repository.CricketerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CricketerService {

    @Autowired
    private CricketerRepository cricketerRepository;

    @Cacheable(value = "cricketersCache", key = "#id")
    public Cricketer getCricketerById(Long id) {
        System.out.println("Actual CALL - getCricketerById");
        return cricketerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cricketer not found"));
    }

    @CachePut(value = "cricketersCache", key = "#cricketer.id")
    public Cricketer saveCricketer(Cricketer cricketer) {
        return cricketerRepository.save(cricketer);
    }

    @CacheEvict(value = "cricketersCache", key = "#id")
    public void deleteCricketer(Long id) {
        System.out.println("Actual CALL - deleteCricketer");
        cricketerRepository.deleteById(id);
    }

    @Cacheable("cricketerListCache  ")
    public List<Cricketer> getAllCricketers() {
        System.out.println("Actual CALL - getAllCricketers");
        return cricketerRepository.findAll();
    }
}

