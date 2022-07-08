package com.api.Projeto.Service;


//vai ser o bean do string

import com.api.Projeto.Model.EstadoModel;
import com.api.Projeto.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

@Service
public class EstadoService {



    @Autowired
    private EstadoRepository estadoRepository;

    public EstadoModel getAllPosts(EstadoModel estadoModel){
        return estadoRepository.save(estadoModel);
    }

    public EstadoService(EstadoRepository estadoRepository) {

        this.estadoRepository = estadoRepository;
    }

    @Transactional
    public EstadoModel save(EstadoModel estadoModel) {

        return estadoRepository.save(estadoModel);
    }

    public Optional<EstadoModel> findById(Long id) {
        return estadoRepository.findById(id);
    }

    @Transactional
    public void delete(EstadoModel estadoModel) {
        estadoRepository.delete(estadoModel);
    }

    public Page<EstadoModel> findAll(Pageable pageable) {
        return estadoRepository.findAll(pageable);
    }
}







