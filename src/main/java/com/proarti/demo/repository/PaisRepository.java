package com.proarti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proarti.demo.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, String> {

}
