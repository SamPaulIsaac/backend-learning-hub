package com.sam.basicCrudForOtherApp.repository;

import com.sam.basicCrudForOtherApp.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Long> {
}

