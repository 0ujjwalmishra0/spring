package com.example.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lib.model.Fine;

public interface FineRepo extends JpaRepository<Fine, Long>{

}
