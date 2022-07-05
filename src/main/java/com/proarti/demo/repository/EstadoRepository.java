package com.proarti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proarti.demo.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, String> {

}
