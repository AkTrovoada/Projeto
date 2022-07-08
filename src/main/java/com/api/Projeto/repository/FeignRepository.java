package com.api.Projeto.repository;


import com.api.Projeto.Dto.ListDto;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "Dados", url = "https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/InvestMunicipioProduto?$top=500&$format=json")
public interface FeignRepository {



        @RequestMapping(method = RequestMethod.GET,value = "")
        ListDto getAllPosts();



    }
