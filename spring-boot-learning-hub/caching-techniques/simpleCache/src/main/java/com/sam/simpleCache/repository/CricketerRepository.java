package com.sam.simpleCache.repository;

import com.sam.simpleCache.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Long> {
}

