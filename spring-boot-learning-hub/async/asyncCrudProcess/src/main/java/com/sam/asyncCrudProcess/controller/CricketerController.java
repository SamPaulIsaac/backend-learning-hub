package com.sam.asyncCrudProcess.controller;

import com.sam.asyncCrudProcess.entity.Cricketer;
import com.sam.asyncCrudProcess.service.CricketerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/cricketers")
public class CricketerController {

    private final CricketerService cricketerService;

    public CricketerController(CricketerService cricketerService) {
        this.cricketerService = cricketerService;
    }

    @GetMapping
    public CompletableFuture<List<Cricketer>> getAllCricketers() {
        return cricketerService.getAllCricketers();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Cricketer> getCricketerById(@PathVariable Long id) {
        return cricketerService.getCricketerById(id);
    }

    @PostMapping
    public CompletableFuture<Cricketer> createCricketer(@RequestBody Cricketer cricketer) {
        return cricketerService.saveCricketer(cricketer);
    }

    @PutMapping("/{id}")
    public CompletableFuture<Cricketer> updateCricketer(@PathVariable Long id, @RequestBody Cricketer cricketerDetails) {
        return cricketerService.getCricketerById(id).thenCompose(cricketer -> {
            cricketer.setName(cricketerDetails.getName());
            cricketer.setCountry(cricketerDetails.getCountry());
            cricketer.setRuns(cricketerDetails.getRuns());
            return cricketerService.saveCricketer(cricketer);
        });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> deleteCricketer(@PathVariable Long id) {
        return cricketerService.deleteCricketer(id);
    }
}
