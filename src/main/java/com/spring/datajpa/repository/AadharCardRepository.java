package com.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.datajpa.entity.AadharCard;

@Repository
public interface AadharCardRepository extends JpaRepository<AadharCard, Long> {

}
