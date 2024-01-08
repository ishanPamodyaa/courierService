package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PackageHistory;

public interface PackageHistoryRepository extends JpaRepository<PackageHistory, Integer>{

}
