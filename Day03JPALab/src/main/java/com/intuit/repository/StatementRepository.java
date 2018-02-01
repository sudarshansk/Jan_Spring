package com.intuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.domain.Statement;

@Repository
public interface StatementRepository  extends JpaRepository<Statement, Integer> {
}
