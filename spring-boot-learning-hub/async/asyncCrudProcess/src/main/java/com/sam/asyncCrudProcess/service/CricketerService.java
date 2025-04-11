package com.sam.asyncCrudProcess.service;

import com.sam.asyncCrudProcess.entity.Cricketer;
import com.sam.asyncCrudProcess.repository.CricketerRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CricketerService {

    private final CricketerRepository cricketerRepository;

    public CricketerService(CricketerRepository cricketerRepository) {
        this.cricketerRepository = cricketerRepository;
    }

    @Async
    public CompletableFuture<List<Cricketer>> getAllCricketers() {
        List<Cricketer> cricketers = cricketerRepository.findAll();
        return CompletableFuture.completedFuture(cricketers);
    }

    @Async
    public CompletableFuture<Cricketer> getCricketerById(Long id) {
//        Optional<Cricketer> cricketer = cricketerRepository.findById(id);
//        return CompletableFuture.completedFuture(cricketer.orElseThrow(() -> new RuntimeException("Cricketer not found")));

        // Simulating a long-running task
        try {
            Thread.sleep(5000);  // 5-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(cricketerRepository.findById(id).orElseThrow());

    }

    @Async
    public CompletableFuture<Cricketer> saveCricketer(Cricketer cricketer) {
        Cricketer savedCricketer = cricketerRepository.save(cricketer);
        return CompletableFuture.completedFuture(savedCricketer);
    }

    @Async
    public CompletableFuture<Void> deleteCricketer(Long id) {
        cricketerRepository.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }
}
