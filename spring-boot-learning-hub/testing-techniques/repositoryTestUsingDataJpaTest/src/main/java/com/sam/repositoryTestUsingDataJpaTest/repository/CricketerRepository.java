package com.sam.repositoryTestUsingDataJpaTest.repository;

import com.sam.repositoryTestUsingDataJpaTest.entity.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Long> {
}

