package com.sam.asyncCrudProcess.repository;

import com.sam.asyncCrudProcess.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Long> {
}
