package com.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.datajpa.entity.ATM;

@Repository
public interface AtmRepository extends JpaRepository<ATM, String> {

}
