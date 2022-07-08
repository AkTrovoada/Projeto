package com.api.Projeto.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public class FeignDto{

        @JsonProperty
        private String Municipio;

        private String nomeProduto;

        @JsonProperty
        private String MesEmissao;

        @JsonProperty
        private String AnoEmissao;

        private String cdPrograma;

        private String cdSubPrograma;

        private String cdFonteRecurso;

        private String cdTipoSeguro;

        private String cdEstado;

        private String cdMunicipio;

        private String cdProduto;

        @JsonProperty
        private double VlCusteio;

        @JsonProperty
        private String Atividade;

        private String cdModalidade;

        @JsonProperty
        private String AreaInvest;

    }
