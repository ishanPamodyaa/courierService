package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Branch;

public interface BranchRepository extends JpaRepository< Branch , Integer> {

}
