package com.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.datajpa.entity.DebitCard;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {

}
