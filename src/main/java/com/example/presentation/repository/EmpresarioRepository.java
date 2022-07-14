package com.example.presentation.repository;

import com.example.presentation.model.Empresario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresarioRepository extends JpaRepository<Empresario, Long> {
}
