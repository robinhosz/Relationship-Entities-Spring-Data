package com.example.presentation.service;

import com.example.presentation.model.Empresario;
import com.example.presentation.repository.EmpresarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresarioService {

    @Autowired
    EmpresarioRepository empresarioRepository;

    public Empresario findById(Long id) {

        Optional<Empresario> obj = empresarioRepository.findById(id);
        return obj.get();
    }

    public List<Empresario> findAll() {
        return empresarioRepository.findAll();
    }

    public Empresario save(Empresario empresario) {
        return empresarioRepository.save(empresario);
    }

    public void delete(Long id) {

        empresarioRepository.deleteById(id);
    }
}
