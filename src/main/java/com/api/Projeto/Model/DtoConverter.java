package com.api.Projeto.Model;

import com.api.Projeto.Dto.FeignDto;
import com.api.Projeto.Dto.ListDto;
import com.api.Projeto.repository.EstadoRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;



@Data
public class DtoConverter {
    @Autowired
    private static EstadoRepository estadoRepository;
    @Autowired
    private static ListDto listDto;
    public static EstadoModel getList(FeignDto feignDto){
        return EstadoModel.builder()
                .cdMuicipio(feignDto.getCdMunicipio())
                .AnoEmissao(feignDto.getAnoEmissao())
                .AreaInvest(feignDto.getAreaInvest())
                .Atividade(feignDto.getAtividade())
                .cdEstado(feignDto.getCdEstado())
                .cdFonteRecurso(feignDto.getCdFonteRecurso())
                .cdModalidade(feignDto.getCdModalidade())
                .cdProduto(feignDto.getCdProduto())
                .cdPrograma(feignDto.getCdPrograma())
                .cdSubPrograma(feignDto.getCdSubPrograma())
                .cdTipoSeguro(feignDto.getCdTipoSeguro())
                .MesEmissao(feignDto.getMesEmissao())
                .Municipio(feignDto.getMunicipio())
                .nomeProduto(feignDto.getNomeProduto())
                .VlCusteio(feignDto.getVlCusteio())
                .build();
    }






}
