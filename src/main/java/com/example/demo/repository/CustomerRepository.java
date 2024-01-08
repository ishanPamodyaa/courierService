package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Cstomer;

public interface CustomerRepository extends JpaRepository<Cstomer, Integer> {

}
