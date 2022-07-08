package com.api.Projeto.repository;

import com.api.Projeto.Model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {

    List<EstadoModel> municipioProdutoPorId(String name);





}
