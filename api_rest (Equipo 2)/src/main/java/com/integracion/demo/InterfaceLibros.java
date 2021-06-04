package com.integracion.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceLibros extends JpaRepository<Libro, Long>{
    
}
