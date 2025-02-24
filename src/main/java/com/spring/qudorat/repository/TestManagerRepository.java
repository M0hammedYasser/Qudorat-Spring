package com.spring.qudorat.repository;

import com.spring.qudorat.model.entity.TestManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestManagerRepository extends JpaRepository<TestManager,Integer> {
}
